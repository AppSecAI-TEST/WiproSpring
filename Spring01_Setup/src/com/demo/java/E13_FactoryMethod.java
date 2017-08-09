package com.demo.java;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dto.Item;

public class E13_FactoryMethod {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-13-factoryMethod.xml");
		 
        Item laptop = context.getBean("laptop", Item.class);
        System.out.println(laptop);
         
        Item mobile = context.getBean("mobile", Item.class);
        System.out.println(mobile);
         
	}
}
