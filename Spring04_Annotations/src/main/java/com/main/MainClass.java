package com.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.config.AppConfig;
import com.dto.Address;
import com.dto.Student;
import com.dto.Teacher;

public class MainClass {

		public static void main(String[] args) {
			ApplicationContext context = new AnnotationConfigApplicationContext();
			((AnnotationConfigApplicationContext)context).register(AppConfig.class);
//			((AnnotationConfigApplicationContext) context).register(AppConfig.class);
			((ConfigurableApplicationContext) context).refresh();

			Student student = context.getBean(Student.class);
			Address studentAddress = context.getBean(Address.class);
			studentAddress.setCity("Pune");
			student.setAddress(studentAddress);
			
			Teacher teacher = context.getBean(Teacher.class);
			Address teacherAddress = context.getBean(Address.class);
			teacherAddress.setCity("Delhi");
			teacher.setAddress(teacherAddress);
			
			System.out.println(student);

	}
}


