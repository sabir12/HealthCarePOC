package com.synavos.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.synavos.dao.rowmapper.ProfileRowMapper;
import com.synavos.model.User;

public class ProfileDAOImpl implements ProfileDAO{
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	
	public void insert(User user){
        String sql = "INSERT INTO hc_user " +
            "(age, displayName,heightUnit,gender,waterUnit,date_of_birth) VALUES (?, ?,?,?,?,?)";
  
        jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update(sql, new Object[] { user.age, user.displayName,user.heightUnit,user.gender,user.waterUnit,user.dateOfBirth  
        });
    }
	public User findById(String userID){
        String sql = "SELECT * FROM hc_user WHERE " +
            "age = ?";
  
        jdbcTemplate = new JdbcTemplate(dataSource);
        User user = jdbcTemplate.queryForObject(sql, new Object[] { userID }, new ProfileRowMapper());
        return user;
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
