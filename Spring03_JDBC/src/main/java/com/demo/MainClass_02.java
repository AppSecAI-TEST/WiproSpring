package com.demo;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dto.User;

public class MainClass_02 {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("bean02.xml");
		((ConfigurableApplicationContext) context).registerShutdownHook();
		
		JdbcUserTemplate userDAO = context.getBean("UserDAO", JdbcUserTemplate.class);
		usersList(userDAO);
	}

	private static void usersList(JdbcUserTemplate userDAO) {
		List<User> list = userDAO.listAllUsers();
		System.out.println(list);
	}
}

