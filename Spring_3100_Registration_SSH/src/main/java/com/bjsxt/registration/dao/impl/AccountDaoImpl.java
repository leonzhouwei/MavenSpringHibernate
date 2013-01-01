package com.bjsxt.registration.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.bjsxt.registration.dao.AccountDaoIf;
import com.bjsxt.registration.model.Account;

@Component("accountDao")
public class AccountDaoImpl implements AccountDaoIf {

	private HibernateTemplate hibernateTemplate;

	public void save(Account account) {
		hibernateTemplate.save(account);

	}

	public boolean checkUserExistsWithName(String username) {
		List<Account> accounts = hibernateTemplate.find("from Account account where account.username = '" + username + "'");

		if (accounts != null && accounts.size() > 0) {
			return true;
		}
		return false;
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

}
