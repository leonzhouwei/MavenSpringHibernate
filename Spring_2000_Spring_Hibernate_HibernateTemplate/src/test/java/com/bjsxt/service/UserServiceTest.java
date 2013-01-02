package com.bjsxt.service;

import java.util.Date;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bjsxt.model.Account;

//Dependency Injection
//Inverse of Control
public class UserServiceTest {

	@Test
	public void testAdd() throws Exception {
		String[] configLocations = {
			"/spring/appconfig/applicationContext.xml"
		};
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(configLocations);
		
		AccountService service = (AccountService)ctx.getBean("accountService");
		System.out.println(service.getClass());
		Account account = new Account();
		String username = "admin";
		String password = username;
		account.setUsername(username);
		account.setPassword(password);
		System.out.println("new account to create is " + account.getUsername());
		service.add(account);
	}

}
