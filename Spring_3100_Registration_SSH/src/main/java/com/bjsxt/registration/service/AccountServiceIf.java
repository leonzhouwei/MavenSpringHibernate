package com.bjsxt.registration.service;

import java.util.List;

import com.bjsxt.registration.web.dto.AccountInfo;

public interface AccountServiceIf {

	boolean exists(AccountInfo accountInfo) throws Exception;

	void add(AccountInfo accountInfo) throws Exception;
	
	List<AccountInfo> list() throws Exception;

}