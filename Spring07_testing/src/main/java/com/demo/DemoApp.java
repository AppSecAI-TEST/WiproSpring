package com.demo;

import java.util.Locale;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.controller.LoginController;
import com.model.User;


public class DemoApp {
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
		LoginController controller = context.getBean("controller", LoginController.class);
		User user = context.getBean("user", User.class);
		Scanner scanner = new Scanner(System.in);
		Locale 	locale = new Locale("en", "US");
				locale = new Locale("hi", "IN");
		System.out.println(context.getMessage("app.user", null, "Enter userid", locale));
		user.setUserid(scanner.next());
		System.out.println(context.getMessage("app.pass", null, "Enter password", locale));
		user.setPassword(scanner.next());
		
		user = controller.getLogin(user);
		
		user.showStatus(locale);
	}
	
}