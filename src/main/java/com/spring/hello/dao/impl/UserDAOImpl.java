package com.spring.hello.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.impl.CriteriaImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.hello.dao.UserDAO;
import com.spring.hello.model.User;

@Repository
public class UserDAOImpl implements UserDAO {

	private final Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession(){
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public User save(User user) {
		logger.debug("new user going to save: {}", user);
		Integer newId = (Integer)getCurrentSession().save(user);
		logger.debug("user inserted successfully with id: {}", newId);
		user.setId(newId);
		return user;
	}

	@Override
	public void delete(User user) {
		getCurrentSession().delete(user);
	}

	@Override
	public User update(User user) {
		getCurrentSession().update(user);
		return user;
	}

	@Override
	public User getById(int id) {
		return (User) getCurrentSession().load(User.class, new Integer(id));
	}

	@Override
	public List<User> list() {
		return getCurrentSession().createQuery("from User").list();
	}

	@Override
	public User getByUsername(String username) {
		logger.debug("Going to retrive user by username: {}", username);
		Criteria criteria = getCurrentSession().createCriteria(User.class);
		criteria.add(Restrictions.eq("username", username));
		User user = (User) criteria.uniqueResult();
		
		logger.debug("user found: {}", user);
		return user;
	}

}
