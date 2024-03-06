package com.Spring.SpringORM;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.Spring.SpringORM.Dao.StudentDao;
import com.Spring.SpringORM.entities.Student;


public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        StudentDao studentDao = context.getBean("studentDao", StudentDao.class);
        Student student = new Student(2324,"Durgesh Tiwari", "Lucknow");
        int r = studentDao.insert(student);
        System.out.println("done " +r);
    }
}

