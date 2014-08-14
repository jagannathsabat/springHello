package com.spring.hello.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.hello.dao.UserDAO;
import com.spring.hello.model.User;
import com.spring.hello.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;
	
	@Override
	@Transactional
	public User save(User user) {
		return userDAO.save(user);
	}

	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User update(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(readOnly=true)
	public List<User> list() {
		return userDAO.list();
	}

	@Override
	@Transactional(readOnly=true)
	public User getByUsername(String username) {
		return userDAO.getByUsername(username);
	}

}
