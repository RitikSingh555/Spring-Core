package com.SpringCore.LifeCycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args)
	{
		
		// In this example we covered LifeCycle of bean
		// we can Implement LifeCycle of bean thorugh 3 way (A) withXMl (B) using Interface (C) using annotation
		// here we will learn use if Init and destroy method in Beans Lifecycle
		
		AbstractApplicationContext context =new ClassPathXmlApplicationContext("com/SpringCore/LifeCycle/configLC.xml");
		
		Samosa s1=(Samosa) context.getBean("s1");
		System.out.println(s1);
		
		//Registering Shutdown Hook
		context.registerShutdownHook();
		
		
		System.out.println("+++++++++++++++++++++++++++++++++");
		Pepsi p1=(Pepsi) context.getBean("p1");
		
		System.out.println(p1);
		
		
		System.out.println("+++++++++++++++++++++++++++++++++");
		Example example=(Example) context.getBean("example");
		System.out.println(example);
		
		
		
		
	}

}
