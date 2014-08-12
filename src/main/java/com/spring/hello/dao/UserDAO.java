package com.spring.hello.dao;

import java.util.List;

import com.spring.hello.model.User;

public interface UserDAO {
	
	User save(User user);
	void delete(User user);
	User update(User user);
	User getById(int id);
	List<User> list();

}
