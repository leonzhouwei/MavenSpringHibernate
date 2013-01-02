package com.bjsxt.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import com.bjsxt.dao.AccountDao;
import com.bjsxt.model.Account;

@Component
public class AccountService {

	private AccountDao accountDao;

	public void add(Account account) {
		accountDao.save(account);
		// e.g. write into database table logger a record to record the save()
		// method upper
	}

	public AccountDao getAccountDao() {
		return accountDao;
	}

	@Resource(name = "accountDao")
	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	public void init() {
		System.out.println("init");
	}

	public void destroy() {
		System.out.println("destroy");
	}

}
