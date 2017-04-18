package com.ashish.prep;

import java.util.ArrayList;
import java.util.Date;

public class PermuteString {

	public static char[] permute (char[] str, int l, int r) {
		if (l==r || str == null) {//System.out.println(str); 
			return str;}
		
		//int len = str.length;
		for (int i=l; i<=r; i++) {
			str = swap(str, l, i);
			str = permute(str, l+1, r);
			str = swap(str, l, i);
		}
		return str;
	}
	
	
	private static char[] swap(char[] str, int l, int i) {
		
		if (str == null) return str;
		char c = str[l];
		str[l] = str[i];
		str[i] = c;
		return str;
	}


	public static void permute(char[] str) {
		if (str == null) return;
		if (str.length == 1) {System.out.println(str);return; }
		permute(str, 0, str.length-1);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//String str = "ABC";
		//permute(str.toCharArray(), 0, str.length()-1);
		
		long startMilli;
		long endMilli;
		
//		permute("ABCDEFGHIJ".toCharArray());
		
//		permute(null);
//		permute("A".toCharArray());
//		permute("AAA".toCharArray());
//
//		permuteFixedPrefix(new StringBuilder("ABC"), new StringBuilder(), new StringBuilder());

		
		startMilli = System.currentTimeMillis();
		permutateString("ABCDEFGHIJ");
		endMilli = System.currentTimeMillis();
		System.out.println(endMilli - startMilli);
		
		startMilli = System.currentTimeMillis();
		permute("ABCDEFGHIJ".toCharArray());
		endMilli = System.currentTimeMillis();
		System.out.println(endMilli - startMilli);

	}

	
	public static String permuteFixedPrefix(StringBuilder remaining, StringBuilder prefix, StringBuilder result) {
		//if (remaining == null) return;
		if (remaining.length() == 0)  result.append(prefix);//{ System.out.println(result.toString()); return result.toString(); }
		
		for (int i = 0; i < remaining.length(); i++) {
			prefix.append(remaining.charAt(i));
			//result.append(prefix);
			StringBuilder _remaining = new StringBuilder(remaining.toString());
			_remaining.deleteCharAt(i);
			System.out.println("Before :: remaining = " + _remaining + " prefix = " + prefix + " result = " + result);
			permuteFixedPrefix(_remaining, prefix, result);
			//prefix = new StringBuilder();	
			//System.out.println("After :: remaining = " + remaining + " prefix = " + prefix + " result = " + result);
		}
		
//		System.out.println(result);
		return result.toString();
	}
	
	public static void permutateString(String str) {
		if (str == null) System.out.println(" ");
//		else permutateString(new StringBuilder(), new StringBuilder(str));
		else permutateString("", str);
		
	}
//	private static void permutateString(StringBuilder prefix, StringBuilder str) {
	private static void permutateString(String prefix, String str) {
		int n = str.length();
//		if (n==1) { System.out.println(prefix.toString() + str.toString()); prefix = new StringBuilder(); }
		if (n==1) { //System.out.println(prefix + str); 
			return;}
		
		else 
			for (int i = 0; i < n; i++) {
//				StringBuilder newStr = new StringBuilder(str);
//				newStr.deleteCharAt(i);
//				System.out.println(str);
//				System.out.println(newStr);

//				permutateString(prefix.append(str.charAt(i)), newStr);
				permutateString(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1));
			} 
		
		Date d = new Date(); d.getTime();
		
		ArrayList<String> list = new ArrayList<String>();
		new ArrayList<String>(list);
	}

/*	private static ArrayList getPermutes(String s) {
		ArrayList permutes = new ArrayList();
		for (char c : s) {
			String[] words = getPermutes(s.replace(c, ''));
			
		}
	}*/
}
