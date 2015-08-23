package com.synavos.dao;

import com.synavos.model.User;


public interface ProfileDAO {
	public void insert(User user);
	public User findById(String userID);
}
