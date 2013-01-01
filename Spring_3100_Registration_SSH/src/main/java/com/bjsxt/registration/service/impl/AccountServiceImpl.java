package com.bjsxt.registration.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.bjsxt.registration.dao.AccountDaoIf;
import com.bjsxt.registration.model.Account;
import com.bjsxt.registration.service.AccountServiceIf;
import com.bjsxt.registration.web.dto.AccountInfo;

@Component("accountService")
public class AccountServiceImpl implements AccountServiceIf {

	private AccountDaoIf accountDao;

	public AccountDaoIf getAccountDao() {
		return accountDao;
	}

	@Resource(name="accountDao")
	public void setAccountDao(AccountDaoIf accountDao) {
		this.accountDao = accountDao;
	}

	public boolean exists(AccountInfo accountInfo) throws Exception {
		Account account = new Account(accountInfo);
		return accountDao.checkUserExistsWithName(account.getUsername());
	}

	public void add(AccountInfo accountInfo) throws Exception {
		Account account = new Account(accountInfo);
		accountDao.save(account);
	}
}
