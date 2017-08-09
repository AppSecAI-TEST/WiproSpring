package com.demo;

import java.util.Locale;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo_01_MainClass {
	
	public static void main(String[] args) {
		getMessage();
//		getLogin();
	}
	
	private static void getMessage(){
		ApplicationContext context = new ClassPathXmlApplicationContext("bean_01.xml");
		String key = "greeting";
		Object[] params = null;
		String defaultMessage = "Default message";
		Locale locale = null;
		
		String msg = context.getMessage(key, params, defaultMessage, locale);
		System.out.println(msg);
	}
	
	private static void getLogin() {
		ApplicationContext context = new ClassPathXmlApplicationContext("bean_02_login.xml");
		String key = "greeting";
		Object[] params = new Object[]{"Jyoti"};
		String defaultMessage = "Default message";
		Locale locale = null;
		
		String msg = context.getMessage(key, params, defaultMessage, locale);
		System.out.println(msg);
	}
	
}

