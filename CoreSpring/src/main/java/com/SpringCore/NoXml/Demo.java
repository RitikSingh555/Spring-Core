package com.SpringCore.NoXml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Demo {
	
	public static void main(String[] args) {
		
		
		ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
		Student student = context.getBean("temp2", Student.class);
		System.out.println(student);
		student.study();
	};

}
