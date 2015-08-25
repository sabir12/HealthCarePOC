package com.synavos.dao;

import java.util.List;

import com.synavos.model.User;
import com.synavos.model.WebUser;


public interface ProfileDAO {
	public void insertORUpdate(User user, String userId);
	public User findById(String userID);
	public List<WebUser> fetchAllWebUsers();
}
