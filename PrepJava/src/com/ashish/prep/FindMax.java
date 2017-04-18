package com.ashish.prep;

public class FindMax {

	public static void main(String[] args) {
		System.out.println(findMax(2, 4));
		System.out.println(findMax1(2, 4));
//		System.out.println((4 >> 31) & 0x1);

		
//		System.out.println(1 << 31);
//		System.out.println(Integer.MIN_VALUE);
	}
	public static int findMax( int x, int y)
	{
	   int z = x - y;
	   int i  = (z  >>  31)  ; //&  0x1;
	   int  max  =  x + i  *  z;
	   return max;
	}

	public static int findMax1( int x, int y)
	{
	   int z = x - y;
	   int i  = (z  >>  31)  &  0x1;
	   int  max  =  x - i  *  z;
	   return max;
	}


}
