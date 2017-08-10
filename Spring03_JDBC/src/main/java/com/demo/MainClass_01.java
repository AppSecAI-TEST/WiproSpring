package com.demo;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dto.User;

public class MainClass_01 {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("bean01.xml");
		((ConfigurableApplicationContext) context).registerShutdownHook();
		
		JdbcUserTemplate userDAO = context.getBean("UserDAO", JdbcUserTemplate.class);
		insertUser(userDAO);
//		findUserById(userDAO);
//		deleteUser(userDAO);
//		updateUser(userDAO);
		usersList(userDAO);
	}

	private static void insertUser(JdbcUserTemplate userDAO) {
		User user = new User(32, "gmail.com", "12345");
//		userDAO.insertUser(user);
		userDAO.insertUser_Template(user);
	}
	
	private static void findUserById(JdbcUserTemplate userDAO) {
		int userid = 108;
		User user = userDAO.getUser(userid);
		System.out.println(user);
	}
	
	private static void usersList(JdbcUserTemplate userDAO) {
		List<User> list = userDAO.listAllUsers();
		System.out.println(list);
	}
	
	private static void deleteUser(JdbcUserTemplate userDAO) {
		int userid = 108;
		userDAO.deleteUser(userid);
	}

	private static void updateUser(JdbcUserTemplate userDAO) {
		int userid = 109;
		int age = 33;
		userDAO.updateUser(userid, age);
	}
	
}

