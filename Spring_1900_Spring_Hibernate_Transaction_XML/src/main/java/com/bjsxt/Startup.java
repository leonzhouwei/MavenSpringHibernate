package com.bjsxt;

import java.util.Date;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bjsxt.model.Account;
import com.bjsxt.service.AccountService;

public class Startup {

	public static void main(String[] args) {
		String[] configLocations = {
			"/beans.xml"
		};
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(configLocations);

		AccountService service = (AccountService) ctx.getBean("accountService");
		System.out.println(service.getClass());
		Account account = new Account();
		Date date = new Date();
		String name = date.toString();
		String password = name;
		account.setName(name);
		account.setPassword(password);
		System.out.println("new account to create is " + account.getName());
		service.add(account);
	}

}
