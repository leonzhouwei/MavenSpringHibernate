package com.bjsxt.registration.dao;

import java.util.List;

import com.bjsxt.registration.model.Account;

public interface AccountDaoIf {
	
	void save(Account u);
	
	boolean checkUserExistsWithName(String username);
	
	List<Account> getAccounts();
	
}
