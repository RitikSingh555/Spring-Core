package com.SpringCore.LifeCycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

//This code is about Implementing bean life cycle using interfaces
public class Pepsi implements InitializingBean, DisposableBean{
	private double price;
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price=price;
		}
	
	public Pepsi() {
		super();
		//TODO Auto generated constructor stub
	}

	@Override
	public String toString() {
		return "Pepsi [price=" + price + "]";
	}
	
	// it is running after Propertiest Set so its a init method
	// init method runs after property set in bean Life Cycle
	public void afterPropertiesSet() throws Exception{
		// TODO Auto-generated method stub
		//init
		System.out.println("Taking Pepsi: init");
	}

	@Override
	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		//Destroy
		System.out.println("Going to put bottle back to shop: destroy ");
		
	}
	

	
	
	

}
