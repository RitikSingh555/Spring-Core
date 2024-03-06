package com.SpringCore.auto.wire.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Employee {
	
	@Autowired
	@Qualifier("address2")
	// we are using qualifier annotation as in configuration there are mutiple beans of same type so for avoiding exception
	// we use qualifier to give name of bean to IOC container whose object we want to create.
	private Address address;

	public Address getAddress() {
		return address;
	}



	public void setAddress(Address address) {
		this.address = address;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(Address address) {
		super();
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "Employee [address=" + address + "]";
	}
	

}
