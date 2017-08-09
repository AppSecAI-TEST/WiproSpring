package com.wipro.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wipro.Employee;
import com.wipro.GreetUser;

public class Test {
	public static void main(String[] args) {
//		GreetUser user = new GreetUser();
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		GreetUser bean = (GreetUser) context.getBean("beanName");
		
//		bean.sayHelloUser("Bhagya");
		
		Employee emp1 = (Employee) context.getBean("emp");
//		emp1.setName("Miley");
		System.out.println(emp1);
		
		Employee emp2 = (Employee) context.getBean("emp");
		emp2.setName("Mark");
		System.out.println(emp2);
		System.out.println(emp1);

	}
}
