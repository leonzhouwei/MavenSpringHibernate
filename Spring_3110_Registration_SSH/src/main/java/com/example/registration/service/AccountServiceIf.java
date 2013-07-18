package com.example.registration.service;

import java.util.List;

import com.example.registration.web.dto.AccountInfo;

public interface AccountServiceIf {

	boolean exists(AccountInfo accountInfo) throws Exception;

	void add(AccountInfo accountInfo) throws Exception;
	
	List<AccountInfo> list() throws Exception;

}