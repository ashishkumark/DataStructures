package com.ashish.prep;

public class PrintBinary {

	public static void main(String[] args) {
		printBinary(-5);
		System.out.println("\n");
		System.out.println("************");
		printBinary(5);
	}
	public static void printBinary(int x) {
//		int j;
//		while (x != 0) {
//			j = (x >>> 1) & 0xFF ;
//			System.out.print(j);
//			x = x >>> 1;
//		}
		
		// Debug mode
		/*for (int i=31; i>=0; i--) {
			System.out.print(Integer.toBinaryString(1<<i));
			if (((1<<i) & x) != 0) {
				System.out.println("- 1");
			} else {
				System.out.println("- 0");
			}
		}*/
		StringBuilder sb = new StringBuilder();
		for (int i=31; i>=0; i--) {
			if (((1<<i) & x) != 0) {
				sb.append(1);
			} else {
				sb.append(0);
			}
		}
		System.out.println(sb.toString());
//		System.out.println(Integer.toBinaryString(Integer.parseInt(sb.toString(), 2)));
		System.out.println(Integer.toBinaryString(x));
		System.out.println(Integer.toString(x, 2));
		
		int mask = 1 << 31;
		for (int i=1; i<=32; i++) {
//			System.out.println(Integer.toBinaryString(mask));
			if ((mask & x) != 0) {
				System.out.print(1);
			} else {
				System.out.print(0);
			}
			mask = mask >>> 1;
		}
	}
}
