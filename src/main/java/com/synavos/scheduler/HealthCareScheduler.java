package com.synavos.scheduler;

import static org.quartz.JobBuilder.newJob;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.Semaphore;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.scribe.builder.ServiceBuilder;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.oauth.OAuthService;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.synavos.dao.ProfileDAO;
import com.synavos.model.Profile;
import com.synavos.model.WebUser;
import com.synavos.util.ApplicationConstant;
import com.synavos.util.FitbitApi;

public class HealthCareScheduler {

	// final static Logger logger = LoggerFactory.getLogger(HealthCareScheduler.class);

	SchedulerFactory schedulerFactory = new StdSchedulerFactory();
	String scheduleTime = "0/1 * * * * ?";
	public static Semaphore available = new Semaphore(1, true);
	public static OAuthService service = null;

	public HealthCareScheduler() {
		service = new ServiceBuilder().provider(FitbitApi.class)
				.apiKey(ApplicationConstant.MY_HEALTH_FITBIT_API_KEY)
				.apiSecret(ApplicationConstant.MY_HEALTH_FITBIT_API_SECRET)
				.build();
	}

	public static class ScheduleJob implements Job {

		public void execute(JobExecutionContext context)
				throws JobExecutionException {

			if (available.tryAcquire()) {
				System.out.println("Healthcare new job invoked");
				
				// TODO: Save application profile data
				ConfigurableApplicationContext springContext = new ClassPathXmlApplicationContext("Spring-Module.xml");
				ProfileDAO profileDAO = (ProfileDAO) springContext.getBean("profileDAOImpl");
				List<WebUser> webUserList = profileDAO.fetchAllWebUsers();
				for (WebUser webUser : webUserList) {
					Profile profile = fetchProfile(webUser.getToken(), webUser.getSecret());
					System.out.println("Profile info from POJO= " + profile);
					System.out.println("Profile info from POJO user age = "+ profile.user.age);
					profileDAO.insertORUpdate(profile.user, webUser.getUserId());
				}
				springContext.close();

				available.release();
			} else{
				//System.out.println("Healthcare job already processing request");
			}
		}
		private Profile fetchProfile(String token, String secret){
			// Jan
			Token accessToken = new Token(token,secret);
			// Bilal
			// Token accessToken= new Token("eed84dde45083855088de32ebe735d52","99cdae3f325b43cccb7fa51313653347");
			OAuthRequest requestOAuth = new OAuthRequest(Verb.GET,
					"https://api.fitbit.com/1/user/-/profile.json");
			service.signRequest(accessToken, requestOAuth); // the access
															// token from
															// step
			// 4
			final Response responseProfile = requestOAuth.send();
			System.out.println("Profile Info=" + responseProfile.getBody());

			ObjectMapper mapper = new ObjectMapper();
			Profile profile = null;
			try {
				profile = mapper.readValue(responseProfile.getBody(), Profile.class);
			} catch (JsonMappingException e) {
				e.printStackTrace();
			} catch (JsonParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return profile;
		}

	}

	public static void main(String[] args) {
		HealthCareScheduler importScheduler = new HealthCareScheduler();
		Scheduler scheduler = null;
		try {
			JobDetail jobDetail = newJob(ScheduleJob.class).build();

			CronTrigger cronTrigger = TriggerBuilder
					.newTrigger()
					.withIdentity("crontrigger", "crontriggergroup1")
					.withSchedule(CronScheduleBuilder.cronSchedule(importScheduler.scheduleTime))
					.build();
			scheduler = importScheduler.schedulerFactory.getScheduler();
			scheduler.scheduleJob(jobDetail, cronTrigger);
			scheduler.start();

		} catch (Exception e) {
			if (scheduler != null) {
				try {
					scheduler.shutdown();
				} catch (SchedulerException e1) {
					System.out.println("An exception occured when starting or while running the scheduler:"
									+ e1.getMessage());
					e.printStackTrace();
				}
			}
			System.out.println("An exception occured when starting or while running the scheduler:"
							+ e.getMessage());
			e.printStackTrace();
			System.exit(-1);
		}
	}

	/**
	 * Shutdown the scheduler, allowing jobs to complete prior. If a scheduler
	 * exception occurs we throw a runtime exception.
	 */
	public void shutdown() {
		boolean doWaitForJobsToComplete = true;
		Scheduler scheduler;
		try {
			scheduler = schedulerFactory.getScheduler();
			scheduler.shutdown(doWaitForJobsToComplete);
		} catch (SchedulerException e) {
			throw new RuntimeException("Failed to shutdown the scheduler: "
					+ e.getMessage(), e);
		}
	}
}
