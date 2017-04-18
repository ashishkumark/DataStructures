package com.ashish.prep;

public class ChildClass implements ParentInterface {

	public void show() {
		System.out.println("Child");

	}

	public String toString()
	{
		//System.out.println("toString");
		return "toString2";
	}

	public static void main(String[] args) {
		ParentInterface p=new ChildClass();
		p.show();
		System.out.println(p.toString());
	}

}
