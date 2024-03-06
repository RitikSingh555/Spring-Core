package com.SpringCore.Stereotype;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


// Hero @component will tell the IOC you need to make bean of this class
@Component("")
//@Scope("prototype")
public class Student {
	
	//@value is uses here to assign value
	@Value("Ritik Singh")
	private String studentName;
	
	@Value("Delhi")
	private String city;
	
	//below is a list type so will create stand allone collection of it in config file, we can't pass direct value inside it
	@Value("#{temp}")
	private List<String> address;
	

	public List<String> getAddress() {
		return address;
	}

	public void setAddress(List<String> address) {
		this.address = address;
	}


	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	@Override
	public String toString() {
		return "Student [studentName=" + studentName + ", city=" + city + "]";
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
