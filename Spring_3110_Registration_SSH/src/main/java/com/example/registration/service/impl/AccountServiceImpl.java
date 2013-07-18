package com.example.registration.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.example.registration.dao.AccountDaoIf;
import com.example.registration.model.Account;
import com.example.registration.service.AccountServiceIf;
import com.example.registration.web.dto.AccountInfo;

@Component("accountService")
public class AccountServiceImpl implements AccountServiceIf {

	private AccountDaoIf accountDao;

	public boolean exists(AccountInfo accountInfo) throws Exception {
		Account account = new Account(accountInfo);
		return accountDao.checkUserExistsWithName(account.getUsername());
	}

	public void add(AccountInfo accountInfo) throws Exception {
		Account account = new Account(accountInfo);
		accountDao.save(account);
	}
	
	public List<AccountInfo> list() throws Exception {
		List<Account> accountList = accountDao.getAccounts();
		final int size = accountList.size();
		List<AccountInfo> accountInfoList = new ArrayList<AccountInfo>(size);
		for (int i = 0; i < size; ++i) {
			accountInfoList.add(new AccountInfo(accountList.get(i)));
		}
		
		return accountInfoList;
	}
	
	public AccountDaoIf getAccountDao() {
		return accountDao;
	}

	@Resource(name="accountDao")
	public void setAccountDao(AccountDaoIf accountDao) {
		this.accountDao = accountDao;
	}
}
