package com.bjsxt.dao.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.bjsxt.dao.AccountDao;
import com.bjsxt.model.Account;

public class AccountDaoImpl implements AccountDao {
	
	private HibernateTemplate hibernateTemplate;
	private Map<String, String> hqls = new HashMap<String, String>();

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public void save(Account account) {
		hibernateTemplate.save(account);
		//throw new RuntimeException("exeption!");
	}

	public Map<String, String> getHqls() {
		return hqls;
	}

	public void setHqls(Map<String, String> hqls) {
		this.hqls = hqls;
	}

}
