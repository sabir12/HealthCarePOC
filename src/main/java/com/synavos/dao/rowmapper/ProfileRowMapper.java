package com.synavos.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.synavos.model.User;

public class ProfileRowMapper implements RowMapper<User> {
    
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        
        user.age = rs.getString("age");
        user.avatar = rs.getString("avatar");
        user.avatar150 = rs.getString("avatar150");
        user.averageDailySteps = rs.getString("averageDailySteps");
        user.dateOfBirth = rs.getString("date_of_birth");
        user.displayName = rs.getString("displayName");
        user.distanceUnit = rs.getString("distanceUnit");
        user.encodedId = rs.getString("encodedId");
        user.foodsLocale = rs.getString("foodsLocale");
        user.gender = rs.getString("gender");
        user.glucoseUnit = rs.getString("glucoseUnit");
        user.height = rs.getString("height");
        user.heightUnit = rs.getString("heightUnit");
        user.locale = rs.getString("locale");
        user.memberSince = rs.getString("memberSince");
        user.offsetFromUTCMillis = rs.getString("offsetFromUTCMillis");
        user.startDayOfWeek = rs.getString("startDayOfWeek");
        user.strideLengthRunning = rs.getString("strideLengthRunning");
        user.strideLengthWalking = rs.getString("strideLengthWalking");
        user.timezone = rs.getString("timezone");
        //user.topBadges = rs.getString("fullName");
        user.waterUnit = rs.getString("waterUnit");
        user.waterUnitName = rs.getString("waterUnitName");
        user.weight = rs.getString("weight");
        user.weightUnit = rs.getString("weightUnit");
        
        return user;
	}
}
