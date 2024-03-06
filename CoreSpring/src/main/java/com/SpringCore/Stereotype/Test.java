package com.SpringCore.Stereotype;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		
		ApplicationContext con= new ClassPathXmlApplicationContext("com/SpringCore/Stereotype/sterotypeconfig.xml");
		
		Student student=con.getBean("student",Student.class);
		System.out.println(student);
		System.out.println(student.getAddress());
		System.out.println(student.getAddress().getClass().getName());
		
		System.out.println("------------------------------------------------");
		System.out.println("Using Scope singleton");
		System.out.println(student.hashCode());
		
		
		
		Student student2=con.getBean("student",Student.class);
		System.out.println(student2.hashCode());
		
		
		System.out.println("------------------------------------------------");
		System.out.println("Using Scope Prototype");
		
		Teacher t1=con.getBean("teacher",Teacher.class);
		Teacher t2=con.getBean("teacher",Teacher.class);
		
		System.out.println(t1.hashCode());
		System.out.println(t2.hashCode());
				
		
		
		
	}

}
