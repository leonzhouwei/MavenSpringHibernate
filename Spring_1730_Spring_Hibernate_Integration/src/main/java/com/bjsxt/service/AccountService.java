package com.bjsxt.service;

import javax.annotation.Resource;

import com.bjsxt.dao.AccountDAO;
import com.bjsxt.model.Account;

import org.springframework.stereotype.Component;

@Component
public class AccountService {
	
	private AccountDAO accountDAO;  
	
	public void add(Account account) {
		accountDAO.save(account);
	}
	
	public AccountDAO getAccountDAO() {
		return accountDAO;
	}

	@Resource(name="accountDAOImpl")
	public void setAccountDAO(AccountDAO accountDAO) {
		this.accountDAO = accountDAO;
	}

	public void init() {
		System.out.println("init");
	}

	public void destroy() {
		System.out.println("destroy");
	}
	
}
