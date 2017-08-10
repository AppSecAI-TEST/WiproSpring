package com.demo;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Locale;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dao.LoginDao;
import com.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:bean.xml"})
public class TestCase02_Dao {

	@Autowired
	LoginDao dao;
	@Autowired
	User user;
	
	Locale locale;
	
	@Before
	public void beforeEachTest(){
		this.locale = new Locale("en","US");
	}
	
	@After
	public void afterEachTest(){
		this.locale = null;
	}
	
	@Test
	public void shouldBeFalse(){
		user.setUserid("Arun");
		user.setPassword("Kumar");
		User newUser = dao.getLogin(user);
		assertFalse(user.isLoggedIn());
	}
	
	@Test
	public void shouldBeTrue(){
		user.setUserid("Arun");
		user.setPassword("Arun");
		User newUser = dao.getLogin(user);
		assertTrue(user.isLoggedIn());
	}
}
