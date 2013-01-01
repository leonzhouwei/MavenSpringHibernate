package com.bjsxt.registration.dao;

import com.bjsxt.registration.model.Account;

public interface AccountDaoIf {
	
	void save(Account u);
	
	boolean checkUserExistsWithName(String username);  
	
}
