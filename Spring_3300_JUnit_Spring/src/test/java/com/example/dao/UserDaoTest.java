package com.example.dao;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.example.model.User;

@ContextConfiguration("classpath:beans.xml")
public class UserDaoTest extends AbstractJUnit4SpringContextTests {

	@Resource(name="userDao")
	private UserDao userDao;
	
	@Test
	public void testSave() {
		User user = new User();
		user.setUsername("alice");
		user.setPassword("alice");
		this.userDao.save(user);
	}
}
