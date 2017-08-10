package com.demo;

import static org.junit.Assert.*;

import java.util.Locale;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.controller.LoginController;
import com.dao.LoginDao;
import com.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:bean.xml"})
public class TestCase01_MessageSource {

	@Autowired
	MessageSource messageSource;
	
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
	public void getValidMessage(){
		String username = "mark";
		String expectedResult = "Welcome "+username;
		String actualResult = messageSource.getMessage("app.valid", new Object[]{username}, locale);
//		assertSame(expectedResult, actualResult);// says false, str1 == str2
		assertEquals("Message is not expected", expectedResult, actualResult);
	}
}
