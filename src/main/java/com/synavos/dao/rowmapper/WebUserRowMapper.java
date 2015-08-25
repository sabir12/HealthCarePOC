package com.synavos.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.synavos.model.WebUser;

public class WebUserRowMapper implements RowMapper<WebUser> {
    
	@Override
	public WebUser mapRow(ResultSet rs, int rowNum) throws SQLException {
		WebUser user = new WebUser();
        
        user.setEmailId(rs.getString("email_id"));
        user.setPassword(rs.getString("password"));
        user.setPinCode(rs.getString("fitbit_pincode"));
        user.setSecret( rs.getString("fitbit_secret"));
        user.setStatus( rs.getBoolean("status"));
        user.setToken( rs.getString("fitbit_token"));
        user.setUserId( rs.getString("user_id"));
        user.setUserName( rs.getString("user_name"));
        
        return user;
	}
}
