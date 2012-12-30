package com.bjsxt.dao;

import com.bjsxt.model.User;

public interface UserDAO {
	
	void save(User user);

	void delete(User user);
	
}
