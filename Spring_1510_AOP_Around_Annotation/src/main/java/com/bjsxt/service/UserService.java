package com.bjsxt.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.bjsxt.dao.UserDAO;
import com.bjsxt.model.User;

@Component("userService")
public class UserService {

	private UserDAO userDAO;

	public void init() {
		System.out.println("init");
	}

	public void add(User user) {
		userDAO.save(user);
	}
	
	public void delete(User user) {
		userDAO.delete(user);
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	@Resource(name="userDAO")
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public void destroy() {
		System.out.println("destroy");
	}
	
}
