package com.ashish.prep;

import java.util.ArrayList;
import java.util.List;

public class PassByValue {

	public static void main(String[] args) {
		
		List<Integer> intList = new ArrayList<Integer>();
		intList.add(1);
		intList.add(2);
		intList.add(4);

		add(3, intList);
		System.out.println(intList);
		add(7, intList);
		System.out.println(intList);

	}

	private static void add(int i, List<Integer> intList) {
		intList.add(i);
		intList.remove(1);
	}

}
