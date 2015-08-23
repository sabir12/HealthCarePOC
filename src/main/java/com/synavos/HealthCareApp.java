package com.synavos;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.synavos.dao.ProfileDAO;
import com.synavos.dao.ProfileDAOImpl;
import com.synavos.model.User;

public class HealthCareApp {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
		 ProfileDAO profileDAO = (ProfileDAO) context.getBean("profileDAOImpl");
        User user = new User();
        user.age = "12";
        user.displayName = "displayName";
        //employeeDAO.insert(user);
        User user2 = (User)profileDAO.findById(user.age);
        System.out.println("User ID : "+user2.displayName);
        context.close();
	}

}
