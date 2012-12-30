package com.bjsxt.registration.action;

import static org.junit.Assert.*;

import org.junit.Test;

public class UserActionTest {

	@Test
	public void testExecute() throws Exception {
		UserAction ua = new UserAction();
		ua.setUsername("h");
		ua.setPassword("h");
		String ret = ua.execute();
		assertEquals("success", ret);
	}

}
