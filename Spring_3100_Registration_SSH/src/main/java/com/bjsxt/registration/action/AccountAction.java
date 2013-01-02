package com.bjsxt.registration.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.bjsxt.common.Define;
import com.bjsxt.common.Message;
import com.bjsxt.registration.service.AccountServiceIf;
import com.bjsxt.registration.web.dto.AccountInfo;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Component("accountAction")
@Scope("prototype")
public class AccountAction extends ActionSupport implements ModelDriven {

	private AccountServiceIf accountService;
	private AccountInfo accountInfo = new AccountInfo();
	private List<AccountInfo> accounts;
	private String message;
	
	public AccountAction() {
		
	}
	
	public String add() {
		String result = null;
		try {
			String username = accountInfo.getUsername();
			if (username == null || !(username.trim().length() > 0)) {
				message = Message.ERROR_ACCOUNT_EMPTY_USERNAME;
				return Define.FAIL;
			}
			username = username.trim();
			String password = accountInfo.getPassword();
			if (password == null || !(password.trim().length() > 0)) {
				message = Message.ERROR_ACCOUNT_EMPTY_PASSWORD;
				return Define.FAIL;
			}
			password = password.trim();
			String password2 = accountInfo.getPassword2();
			if (password2 == null || !(password2.trim().length() > 0)) {
				message = Message.ERROR_ACCOUNT_EMPTY_PASSWORD_CONFIRM;
				return Define.FAIL;
			}
			password2 = password2.trim();
			if (password.compareTo(password2) != 0) {
				message = Message.ERROR_ACCOUNT_EMPTY_PASSWORD_INCONSISTENT;
				return Define.FAIL;
			}
			if (accountService.exists(accountInfo)) {
				message = Message.ERROR_ACCOUNT_DUPLICATE;
				return Define.FAIL;
			}
			System.out.println("username: " + username + ", password: " + password + ", password2: " + password2);
			accountService.add(accountInfo);
			result = Define.SUCCESS;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			message = e.getMessage();
			result = Define.FAIL;
		}
		
		return result;
	}
	
	public String list() {
		String result = null;
		try {			
			accounts = accountService.list();
			result = Define.LIST;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			message = e.getMessage();
			result = Define.FAIL;
		}
		
		return result;
	}
	
	public AccountServiceIf getAccountService() {
		return accountService;
	}

	@Resource(name="accountService")
	public void setAccountService(AccountServiceIf accountService) {
		this.accountService = accountService;
	}

	public Object getModel() {
		return accountInfo;
	}

	public AccountInfo getAccountInfo() {
		return accountInfo;
	}

	public void setAccountInfo(AccountInfo accountInfo) {
		this.accountInfo = accountInfo;
	}

	public List<AccountInfo> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<AccountInfo> accounts) {
		this.accounts = accounts;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
