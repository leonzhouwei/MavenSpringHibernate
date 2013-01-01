package com.bjsxt.registration.service;

import com.bjsxt.registration.web.dto.AccountInfo;

public interface AccountServiceIf {

	boolean exists(AccountInfo accountInfo) throws Exception;

	void add(AccountInfo accountInfo) throws Exception;

}