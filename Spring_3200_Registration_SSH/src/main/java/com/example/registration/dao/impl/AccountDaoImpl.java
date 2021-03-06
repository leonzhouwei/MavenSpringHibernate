package com.example.registration.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.example.registration.dao.AccountDaoIf;
import com.example.registration.model.Account;

public class AccountDaoImpl implements AccountDaoIf {

	private HibernateTemplate hibernateTemplate;
	private Map<String, String> hqls = new HashMap<String, String>();
	
	@SuppressWarnings("unchecked")
	public List<Account> getAccounts() {
		return (List<Account>) hibernateTemplate.find(hqls.get("HQL_GET_ACCOUNTS"));
	}

	public void save(Account account) {
		hibernateTemplate.save(account);
	}

	@SuppressWarnings("unchecked")
	public boolean checkUserExistsWithName(String username) {
		List<Account> accounts = (List<Account>)
			hibernateTemplate
			.findByNamedParam(
				hqls.get("HQL_GET_ACCOUNTS_BY_USERNAME"),
				"username",
				username
			);
		
		if (accounts != null && accounts.size() > 0) {
			return true;
		}
		return false;
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public Map<String, String> getHqls() {
		return hqls;
	}

	public void setHqls(Map<String, String> hqls) {
		this.hqls = hqls;
	}

}
