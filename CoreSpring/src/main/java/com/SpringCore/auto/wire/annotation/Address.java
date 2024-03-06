package com.SpringCore.auto.wire.annotation;

public class Address {
	
	private String City;
	private String street;
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	
	@Override
	public String toString() {
		return "Address [City=" + City + ", street=" + street + "]";
	}
	
	
}
