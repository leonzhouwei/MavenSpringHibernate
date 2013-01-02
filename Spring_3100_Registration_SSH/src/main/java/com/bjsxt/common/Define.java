package com.bjsxt.common;

public final class Define {

	public static final String SUCCESS = "success";
	public static final String FAIL = "fail";
	
	// spring configuration files locations
	public static final String[] SPRING_CONFIG_FILES_PATH = {
		"/spring/appconfig/applicationContext.xml",
		"/spring/dao/accountDao.xml",
	};
	
	private Define() {}
	
}
