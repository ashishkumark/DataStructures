package com.ashish.prep;

import java.util.Arrays;

public class CheckAnagram {

	public static void main(String[] args) {
		System.out.println(isAnagram("Ashish", "gsiisA"));

	}
	public static boolean isAnagram(String s1 , String s2) {
	    return s1.length() == s2.length()
//	    	&& hashCode(s1) == hashCode(s2);
	        && checkSum(s1) == checkSum(s2);
//	        && Arrays.equals(lettersSorted(s1), lettersSorted(s2));
	}

	static int checkSum(String s) {
	    int sqrSum = 0;
	    for(int i = 0; i < s.length(); i++) {
	       char ch = s.charAt(i);
//	       System.out.println(Long.toBinaryString(1L) + " " + Integer.toBinaryString((int) ch) + " " + (int)ch + " " + Long.toBinaryString(1L << ch));
	       sqrSum += ch + (1 << ch);
	       System.out.println("sqrsum = " + sqrSum + " ch =" + (int) ch + " 1L<<ch = " + (1 << ch));
	    }
//	    System.out.println(1L<<66);
	    return sqrSum;
	}
	
	
	static long hashCode(String s) {
		long result = 1L;
		int prime = 31;
		
		for(int i=0; i< s.length(); i++) {
			char ch = s.charAt(i);
			result += prime * result + new Character(ch).hashCode();
		}

		return result;
	}

	static char[] lettersSorted(String s) {
	    char[] chars = s.toCharArray();
	    Arrays.sort(chars);
	    return chars;
	}
}
