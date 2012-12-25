package com.bjsxt.dao.impl;

import javax.annotation.Resource;

import com.bjsxt.dao.AccountDAO;
import com.bjsxt.model.Account;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class AccountDAOImpl implements AccountDAO {
	
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Resource
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void save(Account account) {
		//Hibernate
		//JDBC
		//XML
		//NetWork
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(account);
		session.getTransaction().commit();
		System.out.println("account saved");
		//throw new RuntimeException("exeption!");
	}

}
