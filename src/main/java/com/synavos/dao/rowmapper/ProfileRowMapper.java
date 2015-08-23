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
        user.fullName = rs.getString("fullName");
        
        return user;
	}
}
