package com.example.registration.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.registration.web.dto.AccountInfo;

@Entity
@Table(name="account")
public class Account {
	
	private long id;
	private String username;
	private String password;
	
	public Account() {
		
	}
	
	public Account(AccountInfo accountInfo) {
		username = accountInfo.getUsername();
		password = accountInfo.getPassword();
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
