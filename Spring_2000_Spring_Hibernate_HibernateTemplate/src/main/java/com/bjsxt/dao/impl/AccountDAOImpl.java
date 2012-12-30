package com.bjsxt.dao.impl;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.bjsxt.dao.AccountDAO;
import com.bjsxt.model.Account;

@Component("accountDAO")
public class AccountDAOImpl implements AccountDAO {
	
	private HibernateTemplate hibernateTemplate;

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

}
