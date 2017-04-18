package com.ashish.prep;

public class Fibonnaci {
	public static void main(String[] args) {
		System.out.println(fibonnaci(7));
		System.out.println(fibonnaciRecurrsion(7));
	}

	private static int fibonnaci(int n) {

		int[] fab = new int[n+1];
		fab[0] = 0;
		fab[1] = 1;
		for (int i=2; i<=n; i++) {
			fab[i] = fab[i-1] + fab[i-2];
		}
		return fab[n];
		
	}
	
	private static int fibonnaciRecurrsion(int n) {
		if (n == 1) return 1;
		if (n == 0) return 0;
		return fibonnaciRecurrsion(n -1) + fibonnaciRecurrsion(n -2);
	}
}
