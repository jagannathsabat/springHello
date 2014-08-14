package com.spring.hello.test;

import java.util.List;

import javax.transaction.TransactionManager;

import junit.framework.Assert;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import com.spring.hello.model.User;
import com.spring.hello.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
@TransactionConfiguration(transactionManager="transactionManager")
@Transactional
public class UserServiceTest {

	@Autowired
	private SessionFactory sessionFactory;
		
	@Autowired
	private PlatformTransactionManager transactionManager;
	
	@Test
	public void insertTest(){
	
		final User newUser = new User(null, "Tulu", "123");
		
		TransactionTemplate transactionTemplate = new TransactionTemplate(transactionManager);
		Integer newUserId = transactionTemplate.execute(new TransactionCallback<Integer>() {
			@Override
			public Integer doInTransaction(TransactionStatus status) {		
				sessionFactory.getCurrentSession().save(newUser);
				return newUser.getId();
			}
		});
		
		Assert.assertNotNull(newUserId);
	}
	
	@After
	@Test
	public void selectTest(){
		TransactionTemplate transactionTemplate = new TransactionTemplate(transactionManager);
		List<User> users = transactionTemplate.execute(new TransactionCallback<List<User>>() {
			@Override
			public List<User> doInTransaction(TransactionStatus status) {
				List<User> userList = sessionFactory.getCurrentSession().createCriteria(User.class).list();
				return userList;
			}
		});
		Assert.assertNotNull(users);		
	}
	
	@After
	@Test
	public void getByUserNameTest(){
		final String username = "Tulu";
		TransactionTemplate transactionTemplate = new TransactionTemplate(transactionManager);
		User user = transactionTemplate.execute(new TransactionCallback<User>() {
			@Override
			public User doInTransaction(TransactionStatus status) {			
				User retrivedUser = (User) sessionFactory.getCurrentSession().createCriteria(User.class).add(Restrictions.eq("username", username)).uniqueResult();
				return retrivedUser;
			}
		});
		Assert.assertNotNull(user);		
	}
}
