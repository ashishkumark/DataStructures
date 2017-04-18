package com.ashish.prep;

public class SingletonUser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinarySearchTree bst = Singleton.INSTANCE.getBST();
		bst.main(args);
		bst = Singleton.getInstance().getBST();
		bst.main(args);
//		System.out.println(Singleton.INSTANCE);
	}
	

}
