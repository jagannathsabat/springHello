package com.spring.hello.service;

import java.util.List;

import com.spring.hello.model.User;

public interface UserService {
	
	User save(User user);
	void delete(User user);
	User update(User user);
	User getById(int id);
	User getByUsername(String username);
	List<User> list();
}
