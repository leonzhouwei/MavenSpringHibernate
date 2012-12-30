package com.bjsxt.dao.impl;

import org.springframework.stereotype.Component;

import com.bjsxt.dao.UserDAO;
import com.bjsxt.model.User;

@Component("userDAO") 
public class UserDAOImpl implements UserDAO {
	
	private static int i = 0;

	public void save(User user) {
		if (i++ == 0) {
			throw new RuntimeException("exeption when i==0!");
		} else {
			System.out.println("user saved!");
		}
	}

}
