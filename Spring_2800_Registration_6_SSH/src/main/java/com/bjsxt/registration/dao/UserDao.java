package com.bjsxt.registration.dao;

import com.bjsxt.registration.model.User;

public interface UserDao {
	public void save(User u);
	public boolean checkUserExistsWithName(String username);  
}
