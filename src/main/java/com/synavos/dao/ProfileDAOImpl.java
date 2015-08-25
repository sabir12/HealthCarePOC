package com.synavos.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.synavos.dao.rowmapper.ProfileRowMapper;
import com.synavos.dao.rowmapper.WebUserRowMapper;
import com.synavos.model.TopBadges;
import com.synavos.model.User;
import com.synavos.model.WebUser;

public class ProfileDAOImpl implements ProfileDAO{
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	private final String HC_USER_COLUMNS ="user_id,date_of_birth,weight,glucose_unit,foodsLocale,"
			+ "locale,averageDailySteps,startDayOfWeek,timezone,avatar150,height,"
			+ "age,heightUnit,gender,waterUnit,strideLengthWalking,"
			+ "memberSince,weightUnit,offsetFromUTCMillis,avatar,waterUnitName,strideLengthRunning,"
			+ "fullName,encodedId,distanceUnit,displayName"; 
	
	public void insertORUpdate(User user, String userId){
        String sql = "REPLACE INTO hc_profile " +
            "("+HC_USER_COLUMNS+") VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        System.out.println(sql);
        jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update(sql, new Object[] { userId,user.dateOfBirth,user.weight,user.glucoseUnit,user.foodsLocale,
        		user.locale,user.averageDailySteps,user.startDayOfWeek,user.timezone,user.avatar150,user.height,
        		user.age,user.heightUnit,user.gender,user.waterUnit,user.strideLengthWalking,user.memberSince,
        		user.weightUnit,user.offsetFromUTCMillis,user.avatar,user.waterUnitName,user.strideLengthRunning,user.fullName,
        		user.encodedId,user.distanceUnit,user.displayName
        });
        System.out.println("insert completed..."+jdbcTemplate.toString());
        String badgeSQLInsert = "INSERT INTO hc_topbadges "
        		+ "(user_id,badgeGradientEndColor,badgeGradientStartColor,badgeType,category,cheers,"
        		+ "dateTime,description,earnedMessage,encodedId,image100px,image125px,"
        		+ "image300px,image50px,image75px,marketingDescription,mobileDescription,name,"
        		+ "shareImage640px,shareText,shortDescription,shortName,timesAchieved) "
        		+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        List<Object[]> list = new ArrayList<Object[]>();
        for (TopBadges badges : user.topBadges) {
        	list.add(new Object[] {
        			userId,badges.badgeGradientEndColor,badges.badgeGradientStartColor,badges.badgeType,badges.cheers,
        			badges.dateTime,badges.description,badges.earnedMessage,badges.encodedId,badges.image100px,
        			badges.image125px,badges.image300px,badges.image50px,badges.image75px,badges.image75px,badges.marketingDescription,
        			badges.mobileDescription,badges.name,badges.shareImage640px,badges.shareText,badges.shortDescription,badges.shortName,
        			badges.timesAchieved
        	});
        	
		}
        if(list.size() > 0)
        	System.out.println(jdbcTemplate.batchUpdate(badgeSQLInsert, list)); 
    }
	public User findById(String userID){
        String sql = "SELECT * FROM myhealthcare.hc_profile profile"
        		+ "LEFT OUTER JOIN myhealthcare.hc_topbadges badge ON profile.user_id = badge.user_id "
        		+ "WHERE user_id = ?";
  
        jdbcTemplate = new JdbcTemplate(dataSource);
        User user = jdbcTemplate.queryForObject(sql, new Object[] { userID }, new ProfileRowMapper());
        return user;
	}
	
	public List<WebUser> fetchAllWebUsers(){
        String sql = "SELECT * FROM hc_user WHERE STATUS=1;";
  
        jdbcTemplate = new JdbcTemplate(dataSource);
        List<WebUser> webUserList = jdbcTemplate.query(sql,new WebUserRowMapper());
        return webUserList;
	}
	
	public DataSource getDataSource() {
		return dataSource;
	}
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
}
