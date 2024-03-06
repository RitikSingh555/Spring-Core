package com.SpringCore.auto.wire.annotation;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// In this package package com.SpringCore.auto.wire.annotation we covered autowiring through @annotation 
		ApplicationContext context=new ClassPathXmlApplicationContext("com/SpringCore/auto/wire/annotation/autoconfig.xml");
		Employee emp1=context.getBean("emp1",Employee.class);
		System.out.println(emp1);

	}

}
