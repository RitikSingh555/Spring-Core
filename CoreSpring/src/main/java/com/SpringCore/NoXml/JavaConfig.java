package com.SpringCore.NoXml;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;


//This file is handling configuration so we are using @configuration here to let the container know about it
@Configuration
//@ComponenttScan(basePackages = "com.SpringCore.NoXml")
public class JavaConfig {
	
	@Bean
	public Samosa getSamosa() {
		
		return new Samosa();
	}
	
	@Bean(name= {"student","temp2","con"})
	public Student getStudent() {
		
		//creating a new student object
		Student student = new Student(getSamosa());
		return student;
	}

}
