package com.example.dao.impl;

import org.springframework.stereotype.Component;

import com.example.dao.UserDao;
import com.example.model.User;

@Component("userDao")
public class UserDaoImpl implements UserDao {

	@Override
	public void save(User user) {
		System.out.println("(" + user.getUsername() + ", " + user.getPassword() + ") saved");
	}

}
