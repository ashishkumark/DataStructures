package com.ashish.prep;

class InheritancePC2 extends InheritancePrivateConstructor {
	private final static InheritancePC2 instance = new InheritancePC2(new Object());

	private InheritancePC2(Object o) {
		super(o);
	}

	public static InheritancePC2 getInstance() {
		return instance;
	}
	
	public void print() {
		System.out.println("This is a test");
	}
}

