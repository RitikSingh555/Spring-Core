package com.SpringCore.Ref;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.SpringCore.Collections.Emp;

public class Test {
	
	public static void main (String args[]) {
    ApplicationContext context = new ClassPathXmlApplicationContext("com/SpringCore/Ref/RefConfig.xml");
    A temp= (A) context.getBean("aref");
    
    System.out.println(temp.getX());
    
    System.out.println(temp.getObj().getY());
    System.out.println(temp);
    

}
}
