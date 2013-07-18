package com.example.registration.dao;

import java.util.List;

import com.example.registration.model.Account;

public interface AccountDaoIf {
	
	void save(Account u);
	
	boolean checkUserExistsWithName(String username);
	
	List<Account> getAccounts();
	
}
