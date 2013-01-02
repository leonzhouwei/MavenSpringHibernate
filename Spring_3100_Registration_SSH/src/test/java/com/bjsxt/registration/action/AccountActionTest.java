package com.bjsxt.registration.action;

import static org.junit.Assert.fail;
import junit.framework.Assert;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bjsxt.common.Define;
import com.bjsxt.registration.service.AccountServiceIf;
import com.bjsxt.registration.web.dto.AccountInfo;

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

	// @Test
	public void testList() {
		fail("Not yet implemented");
	}

}
