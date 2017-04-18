package com.ashish.prep;


public class NoArithmatic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(add_no_arithm(399, 744));
	}

	static int add_no_arithm(int a, int b) {
		if (b == 0)
			return a;
		int sum = a ^ b; // add without carrying
		
		System.out.println(
				//"Sum = " + sum + 
				", binary = " + Integer.toBinaryString(sum));
		
		int carry = (a & b) << 1; // carry, but don’t add
		
		System.out.println(
				"(a & b) = " + (a & b) + 
				", binary = " + Integer.toBinaryString((a & b)));
		System.out.println(
				//"carry = " + carry + 
				", binary = " + Integer.toBinaryString(carry));
		System.out.println();
		return add_no_arithm(sum, carry); // recurse
	}
}
