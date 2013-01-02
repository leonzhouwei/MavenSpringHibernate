package com.bjsxt;

import java.util.Map;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bjsxt.dao.AccountDao;
import com.bjsxt.dao.impl.AccountDaoImpl;
import com.bjsxt.model.Account;
import com.bjsxt.service.AccountService;

public class Startup {

	public static void main(String[] args) {
		String[] configLocations = {
				"/spring/appconfig/applicationContext.xml",
				"/spring/dao/accountDao.xml" };
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				configLocations);

		AccountDao accountDao = (AccountDao) ctx.getBean("accountDao");
		AccountDaoImpl accountDaoImpl = (AccountDaoImpl) accountDao;
		Map<String, String> hqls = accountDaoImpl.getHqls();
		System.out.println(hqls.get("HQL_GET_ACCOUNT_ALL"));

		AccountService service = (AccountService) ctx.getBean("accountService");
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
