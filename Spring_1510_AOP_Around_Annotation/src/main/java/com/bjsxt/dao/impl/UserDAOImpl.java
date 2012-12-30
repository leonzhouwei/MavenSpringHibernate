package com.bjsxt.dao.impl;

import org.springframework.stereotype.Component;

import com.bjsxt.dao.UserDAO;
import com.bjsxt.model.User;

@Component("userDAO") 
public class UserDAOImpl implements UserDAO {
	
	private static int i = 0;

	public void save(User user) {
		System.out.println("UserDAOImpl.save() start, i==" + i);
		if (i == 0) {
			throw new RuntimeException("exeption! i==" + i++);
		} else {
			System.out.println("UserDAOImpl.save() end, i==" + i++);
		}
	}

	public void delete(User user) {
		System.out.println("user deleted!");
	}

}
