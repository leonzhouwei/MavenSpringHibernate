package com.example.registration.action;

import java.util.List;

import junit.framework.Assert;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.common.Define;
import com.example.registration.service.AccountServiceIf;
import com.example.registration.web.dto.AccountInfo;

public class AccountActionTest {

	//@Test
	public void testAdd() throws Exception {
		ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext(Define.SPRING_CONFIG_FILES_PATH);
		final String username = "b";
		final String password = "b";
		final String password2 = "b";
		AccountAction accountAction = (AccountAction) appContext.getBean("accountAction");
		AccountServiceIf accountService = (AccountServiceIf) appContext.getBean("accountService");

		AccountInfo accountInfo = new AccountInfo();
		accountAction.setAccountInfo(accountInfo);
		accountInfo.setUsername(username);
		accountInfo.setPassword(password);
		accountInfo.setPassword2(password2);

		boolean exists = accountService.exists(accountInfo);
		String result = accountAction.add();
		if (exists) {
			Assert.assertEquals(Define.FAIL, result);
		} else {
			Assert.assertEquals(Define.SUCCESS, result);
		}
	}

	//@Test
	public void testList() throws Exception {
		ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext(Define.SPRING_CONFIG_FILES_PATH);
		AccountAction accountAction = (AccountAction) appContext.getBean("accountAction");
		
		accountAction.list();
		List<AccountInfo> accountInfoList = accountAction.getAccounts();
		final int size = accountInfoList.size();
		for (int i = 0; i < size; ++i) {
			System.out.println(accountInfoList.get(i).toString());
		}
	}

}
