package com.SpringCore.CI;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.*;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("com/SpringCore/CI/CIconfig.xml");
		Person p=(Person) context.getBean("person");
		System.out.println(p);
		
		Adition add=(Adition) context.getBean("add");
		add.doSum();
		
	}
}
