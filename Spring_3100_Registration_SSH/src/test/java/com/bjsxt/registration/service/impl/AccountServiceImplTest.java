package com.bjsxt.registration.service.impl;

import java.util.List;

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
	public void testAdd() throws Exception {
		ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext(Define.SPRING_CONFIG_FILES_PATH);
		final String username = "admin";
		final String password = "admin";
		final String password2 = "admin";
		AccountServiceIf accountService = (AccountServiceIf) appContext.getBean("accountService");
		
		AccountInfo accountInfo = new AccountInfo();
		accountInfo.setUsername(username);
		accountInfo.setPassword(password);
		accountInfo.setPassword2(password2);
		
		accountService.add(accountInfo);
	}
	
	//@Test
	public void testList() throws Exception {
		ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext(Define.SPRING_CONFIG_FILES_PATH);
		AccountServiceIf accountService = (AccountServiceIf) appContext.getBean("accountService");
		List<AccountInfo> accountInfoList = accountService.list();
		final int size = accountInfoList.size();
		for (int i = 0; i < size; ++i) {
			System.out.println(accountInfoList.get(i).toString());
		}
	}

}
