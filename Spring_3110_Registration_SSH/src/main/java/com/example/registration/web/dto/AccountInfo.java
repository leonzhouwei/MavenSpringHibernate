package com.example.registration.web.dto;

import com.example.registration.model.Account;

public class AccountInfo {
	
	private String username;
	private String password;
	private String password2;
	
	public AccountInfo() {
		
	}
	
	public AccountInfo(Account account) {
		username = account.getUsername();
		password = account.getPassword();
		password2 = null;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(AccountInfo.class.getName());
		sb.append(":");
		sb.append("(");
		sb.append(username);
		sb.append(", ");
		sb.append(password);
		sb.append(", ");
		sb.append(password2);
		sb.append(")");
		
		return sb.toString();
	}
	
}
