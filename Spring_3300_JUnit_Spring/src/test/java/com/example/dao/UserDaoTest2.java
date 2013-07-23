package com.example.dao;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserDaoTest2 {

	@Test
	public void testSave() {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		UserDao userDao = context.getBean("userDao", UserDao.class);
		System.out.println(userDao);
	}
}
