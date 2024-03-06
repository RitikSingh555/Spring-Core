package com.SpringCore.Collections;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.*;

import com.Spring.CoreSpring.Student;

public class Test {
	
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("com/SpringCore/Collections/CollectionsConfig.xml");
        Emp emp1 = (Emp) context.getBean("emp1");
        System.out.println(emp1.getName());
        System.out.println(emp1.getPhones());
        System.out.println(emp1.getAddresses());
        System.out.println(emp1.getCourses());
    }

}
