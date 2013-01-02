package com.bjsxt.registration.service.impl;

import static org.junit.Assert.fail;
import junit.framework.Assert;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bjsxt.common.Define;
import com.bjsxt.registration.service.AccountServiceIf;
import com.bjsxt.registration.web.dto.AccountInfo;

public class AccountServiceImplTest {

	//@Test
	public void testExists() throws Exception {
		ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext(Define.SPRING_CONFIG_FILES_PATH);
		final String username = "admin";
		final String password = "admin";
		final String password2 = "admin";
		AccountServiceIf accountService = (AccountServiceIf) appContext.getBean("accountService");
		
		AccountInfo accountInfo = new AccountInfo();
		accountInfo.setUsername(username);
		accountInfo.setPassword(password);
		accountInfo.setPassword2(password2);
		
		boolean condition = accountService.exists(accountInfo);
		Assert.assertTrue(condition);
	}

	//@Test
	public void testAdd() {
		ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("/beans.xml");
		final String username = "admin";
		final String password = "admin";
		final String password2 = "admin";
		AccountServiceIf accountService = (AccountServiceIf) appContext.getBean("accountService");
		
		AccountInfo accountInfo = new AccountInfo();
		accountInfo.setUsername(username);
		accountInfo.setPassword(password);
		accountInfo.setPassword2(password2);
		
		try {
			accountService.add(accountInfo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		}
	}

}
