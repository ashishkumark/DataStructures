package com.ashish.prep;

import java.util.Random;

public class CustomRand {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		for(int i=0; i<10; i++)
			System.out.println(getRand7Test());
//			getRand7();
//		System.out.println(((getRand1to5()-1) * 5 + getRand1to5())%7 + 1);
//		System.out.println(getRand1to5() + getRand1to5()%3);	
	}


	static int getRand7Test() {
		return (getRand5()+getRand5()+getRand5()+getRand5()+getRand5()+getRand5()+getRand5())%7 +1;
	}
	
	static int getRand5() {
		return (new Random().nextInt(5-1)+1);
	}
	
	static int getRand7() {
		int sum = 0;
		do {
			sum = 5 * (getRand5()-1) + getRand5();
		} while (sum > 21);
		System.out.println("Sum = " + sum + " , sum%7+1 = " + ((sum%7)+1));
		return sum%7 +1;
	}
}
