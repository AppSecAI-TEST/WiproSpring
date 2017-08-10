package com.wipro.main;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wipro.DummyDb;
import com.wipro.model.Employee;

public class StartApp {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		DummyDb bean = context.getBean("dummyDb", DummyDb.class);
		System.out.println(bean.getDbMap());
		
		Scanner scanner = new Scanner(System.in);

		for(int i=0;i<2;i++){
			Employee emp = context.getBean("emp", Employee.class);
			System.out.println("Enter your id");
			emp.setId(scanner.nextInt());
			System.out.println("Enter your name");
			emp.setName(scanner.next());
			bean.getDbMap().put(emp.getId(), emp);
		}
		
		System.out.println(bean.getDbMap());
		
		
	}
}
