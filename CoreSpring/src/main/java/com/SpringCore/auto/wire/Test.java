package com.SpringCore.auto.wire;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// we can perform auto wiring by two way through XML and Annotation
		// In XML we perform autowiring by 3 way (a) byName (b) byType  (C)ByConstructor
		// And in annotation we wiil use @annotation
		// In this package package com.SpringCore.auto.wire we covered autowiring through  XML
		
		ApplicationContext context=new ClassPathXmlApplicationContext("com/SpringCore/auto/wire/autoconfig.xml");
		Employee emp1=context.getBean("emp1",Employee.class);
		System.out.println(emp1);

	}

}
