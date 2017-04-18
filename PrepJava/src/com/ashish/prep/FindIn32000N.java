package com.ashish.prep;

public class FindIn32000N {

	public static void main(String args[]) {
		int input[] = new int[10];
		input[0] = 0;
		input[1] = 2;
		input[2] = 5;
		input[3] = 7;
		input[4] = 33;
		input[5] = 3;
		input[6] = 2;
		input[7] = 63;
		input[8] = 4;
		input[9] = 31;
		
		printDuplicates(input);
		//findNumber(input, 2);
	}
	
	private static void findNumber(int[] input, int findNum) {
		int[] inputBitArray = new int[32000 >> 5]; // divide by 32
		int wordNumber, mask;

		for (int i = 0; i < input.length; i++) {
			mask = 1 << (input[i] % 32);
			wordNumber = input[i] / 32;
//			if ((mask & isDuplicate[wordNumber]) != 0) {
//				System.out.println(input[i]);
//			} else {
			if ((mask & inputBitArray[wordNumber]) == 0) {
				inputBitArray[wordNumber] |= mask;
			}
		}

		mask = 1 << (findNum % 32);
		wordNumber = findNum / 32;
		if ((mask & inputBitArray[wordNumber]) != 0) {
			System.out.println("Number " + findNum + " is found at " + (wordNumber * 32) + (findNum %32));
		} else {
			System.out.println("Number " + findNum + " is not found ");
		}
		
//		for (int i = 0; i < inputBitArray.length; i++) {
//			System.out.println(Integer.toBinaryString(inputBitArray[i]));
//		}
		System.out.println(Integer.toBinaryString(inputBitArray[0]));
		System.out.println(Integer.toBinaryString(inputBitArray[1]));
	}

	public static void printDuplicates(int[] input) {
		int[] isDuplicate = new int[32000 >> 5]; // divide by 32
		int wordNumber, mask;

		for (int i = 0; i < input.length; i++) {
			mask = 1 << (input[i] % 32);
			wordNumber = input[i] / 32;
			if ((mask & isDuplicate[wordNumber]) != 0) {
				System.out.println(input[i]);
			} else {
				isDuplicate[wordNumber] |= mask;
			}
		}

	}
}
