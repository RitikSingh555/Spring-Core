package com.Spring.SpringJDBC;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.Spring.SpringJDBC.dao.StudentDao;
import com.Spring.SpringJDBC.entities.Student;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "My program started..........." );
        
        //spring jdbc=> JdbcTemplate
        
        // we will use this when we use xml for configuration
        //ApplicationContext context = new ClassPathXmlApplicationContext("com/Spring/SpringJDBC/config.xml");
        
        
        
        // we will use when we make java file for configuration instead of xml
        ApplicationContext context = new AnnotationConfigApplicationContext(JDBCconfig.class);
        
        
        
       /* 
        * ---------------->Not a Good Way<-------------- 
        * JdbcTemplate template = context.getBean("jdbcTemplate", JdbcTemplate.class);
        
        
        //insert query
        String query="insert student(id,name,city) values(?,?,?)";
        
        //fire query
        int result=template.update(query,456,"Uttam Singh", "Kanpur");
        System.out.println("number of record inserted.."+result);
        *
        */
        

        StudentDao studentDao = context.getBean("studentDao", StudentDao.class);
        
         
        //*---------------------->This is a new Way<--------------------------- 
        //INSERT*******
        Student student = new Student();
        student.setId(690);
        student.setName("Suryabhan");
        student.setCity("Banaras");
        
        int result = studentDao.insert(student);
        
        System.out.println("Student added" + result);
        
		/*
		 //UPDATE******
		 * Student student = new Student(); student.setId(456);
		 * student.setName("Raj Kumar"); student.setCity("Lucknow"); int result =
		 * studentDao.change(student); System.out.println("data changes "+result);
		 */
        
        //DELETE*****
		/*
		 * int result= studentDao.delete(666); System.out.println("Student deleted" +
		 * result);
		 */
        
		/*
		 * Student student = studentDao.getStudent(123); System.out.println(student);
		 */
        
		/*
		 * List<Student> students = studentDao.getAllStudents(); for(Student s:
		 * students) { System.out.println(s); }
		 */
        
        
        
        
    }
}
