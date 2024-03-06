package com.SpringCore.spel;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Demo {
	
	//("{}") this is a Spring expression Language
	@Value("#{32}")
	private int x;
	
	@Value("#{55}")
	private int y;
	
	//we are calling static method here T(class).method(argms)
	@Value("#{ T(java.lang.Math).sqrt(144) }")
	private double z;
	
	//we are calling static method here T(class).method(argms)
	@Value("#{ T(java.lang.Math).E }")
	private double e;
	
	//we are passing object here T(class).method(argms)
	@Value("#{new java.lang.String('Ritik Singh')}")
	private String name;
	
	@Value("#{8-4>3}")
	private boolean isActive;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public double getZ() {
		return z;
	}
	public void setZ(double z) {
		this.z = z;
	}


	public double getE() {
		return e;
	}
	public void setE(double e) {
		this.e = e;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	@Override
	public String toString() {
		return "Demo [x=" + x + ", y=" + y + ", z=" + z + ", e=" + e + ", name=" + name + ", isActive=" + isActive
				+ "]";
	}


	

}
