package com.synavos.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.scribe.builder.ServiceBuilder;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.oauth.OAuthService;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.synavos.dao.ProfileDAO;
import com.synavos.model.Activities;
import com.synavos.model.Profile;
import com.synavos.util.ApplicationConstant;
import com.synavos.util.FitbitApi;

/**
 * Created by bilalilyas on 09/08/15.
 */
//@WebServlet(name = "FitbitProfileServlet")
public class FitbitProfileServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            // Set response content type
            //--response.setContentType("text/html");
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");

            // Actual logic goes here.
            PrintWriter out = response.getWriter();

            OAuthService service = new ServiceBuilder()
                    .provider(FitbitApi.class)
                    .apiKey(ApplicationConstant.MY_HEALTH_FITBIT_API_KEY)
                    .apiSecret(ApplicationConstant.MY_HEALTH_FITBIT_API_SECRET)
                    .build();
            //Jan
            Token accessToken= new Token("3e70b74f68f9fd4868d1a38d60e07038","fb7ce85b37b72b9a31e15a1ccfc73d8b");
            //Bilal
            //Token accessToken= new Token("eed84dde45083855088de32ebe735d52","99cdae3f325b43cccb7fa51313653347");
            OAuthRequest requestOAuth = new OAuthRequest(Verb.GET,
                    "https://api.fitbit.com/1/user/-/profile.json");
            service.signRequest(accessToken, requestOAuth); // the access token from step
            // 4
            final Response responseProfile = requestOAuth.send();
            System.out.println("Profile Info=" + responseProfile.getBody());

            ObjectMapper mapper = new ObjectMapper();
            Profile profile = null;
            try {
                profile = mapper.readValue(responseProfile.getBody(),Profile.class);
            } catch (JsonMappingException e) {
                e.printStackTrace();
            }

            System.out.println("Profile info from POJO= "+profile);
            
            System.out.println("Profile info from POJO user age = "+profile.user.age);
            
            out.println(responseProfile.getBody());

            requestOAuth = new OAuthRequest(Verb.GET,"https://api.fitbit.com/1/user/-/activities.json");
            service.signRequest(accessToken, requestOAuth); // the access token from step
            // 4
            final Response responseActivities = requestOAuth.send();
            System.out.println("Activities=" + responseActivities.getBody());

            ObjectMapper objectMapper = new ObjectMapper();
            Activities activities = null;
            try {
                activities = objectMapper.readValue(responseActivities.getBody(),Activities.class);
            } catch (JsonMappingException e) {
                e.printStackTrace();
            }

            System.out.println("Activities info from POJO= "+activities);
            requestOAuth = new OAuthRequest(Verb.GET,"https://api.fitbit.com/1/user/-/sleep/date/2015-07-14.json");
            service.signRequest(accessToken, requestOAuth); // the access token from step
            // 4
            final Response responseSleepTime = requestOAuth.send();
            System.out.println("responseSleepTime="+responseSleepTime.getBody());

        }catch(Exception e){

        }
    }
}
