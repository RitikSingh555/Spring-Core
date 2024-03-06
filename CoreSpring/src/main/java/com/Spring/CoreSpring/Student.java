package com.Spring.CoreSpring;

public class Student {
	
	private int studentid;
	private String studentName;
	private String studentAddress;
	public int getStudentid() {
		return studentid;
	}
	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentAddress() {
		return studentAddress;
	}
	public void setStudentAddress(String studentAddress) {
		this.studentAddress = studentAddress;
	}
	@Override
	public String toString() {
		return "Student [studentid=" + studentid + ", studentName=" + studentName + ", studentAddress=" + studentAddress
				+ "]";
	}
	
	

}
