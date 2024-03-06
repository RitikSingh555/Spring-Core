package com.Spring.SpringORM.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="student_details")
public class Student {

	@Id
	@Column(name="student_id")
	private int studentId;
	@Column(name="student_name")
	private String studentname;
	@Column(name="student_city")
	private String studentCity;
	
	
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudentname() {
		return studentname;
	}
	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}
	public String getStudentCity() {
		return studentCity;
	}
	public void setStudentCity(String studentCity) {
		this.studentCity = studentCity;
	}
	

	
	public Student(int studentId, String studentname, String studentCity) {
		super();
		this.studentId = studentId;
		this.studentname = studentname;
		this.studentCity = studentCity;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
