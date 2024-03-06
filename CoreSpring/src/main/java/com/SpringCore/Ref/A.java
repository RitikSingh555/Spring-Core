package com.SpringCore.Ref;

public class A {
	private int x;
	private B Obj;
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}

	public B getObj() {
		return Obj;
	}
	public void setObj(B obj) {
		Obj = obj;
	}
	public A() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "A [x=" + x + ", Obj=" + Obj + "]";
	}
	

}
