package com.demo;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.dao.PersonDaoImpl;
import com.demo.entity.Person;
import com.demo.exceptions.CommitException;

public class PersonDaoTest {

	@Before
	public void setUp() throws Exception {}

	@Test
	public void test() {

		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
		PersonDaoImpl dao = context.getBean("personDao", PersonDaoImpl.class);

		Person puneet = new Person("Puneet", "Vashisht");
		Person amit = new Person("Amit", "Srivastava");

		dao.save(puneet);
		dao.save(amit);
		
		/*
		 * List<Person> persons = dao.getAll(); 
		 * for (Person person : persons) {
		 * 	System.out.println(person); 
		 * }
		 */
		// throw new RuntimeException();
		// context.close();
	}

}
