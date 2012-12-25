package com.bjsxt.service;

import com.bjsxt.model.Account;
import com.bjsxt.service.AccountService;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//Dependency Injection
//Inverse of Control
public class UserServiceTest {

	@Test
	public void testAdd() throws Exception {
		String[] configLocations = {
			"/spring/appconfig/beans.xml"
		};
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(configLocations);
		
		AccountService service = (AccountService)ctx.getBean("accountService");
		System.out.println(service.getClass());
		Account account = new Account();
		String name = "lisi";
		String password = name;
		account.setName(name);
		account.setPassword(password);
		service.add(account);
	}

}
