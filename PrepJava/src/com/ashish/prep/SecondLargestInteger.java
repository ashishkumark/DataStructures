package com.ashish.prep;

public class SecondLargestInteger {

	/**
	 * Find and Returns the second largest integer from the int array.
	 * 
	 * Returns 0 if it found a null array or empty array
	 * 
	 * @param array
	 * @return
	 */
	public static int secondLargest(int[] array) {
		
		if (array == null || array.length == 0) return 0;
		
		if (array.length == 1) return array[0];
		
		int largest = array[0];
		int secondLargest = Integer.MIN_VALUE;
		
		for (int i=1; i< array.length; i++) {
			if (array[i] > largest) {
				secondLargest = largest;
				largest = array[i];
			} else {
				if (array[i] > secondLargest) {
					secondLargest = array[i];
				}
			}
		}
		
//		for (int i=Integer.MIN_VALUE; i<Integer.MAX_VALUE; i++) { System.out.println(i);  }
		return secondLargest;
	}
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		System.out.println("Second Largest in " + buildArrayString(arr) + " is :" + secondLargest(arr));
		arr = new int[]{5, 4, 3, 2, 1};
		System.out.println("Second Largest in " + buildArrayString(arr) + " is :" + secondLargest(arr));
		arr = new int[]{5, 0, Integer.MIN_VALUE };
		System.out.println("Second Largest in " + buildArrayString(arr) + " is :" + secondLargest(arr));
		arr = new int[]{5 , 5};
		System.out.println("Second Largest in " + buildArrayString(arr) + " is :" + secondLargest(arr));
		arr = new int[]{5 };
		System.out.println("Second Largest in " + buildArrayString(arr) + " is :" + secondLargest(arr));
		arr = new int[] {};
		System.out.println("Second Largest in " + buildArrayString(arr) + " is :" + secondLargest(arr));
		arr = null;
		System.out.println("Second Largest in " + buildArrayString(arr) + " is :" + secondLargest(arr));
		arr = new int[]{5, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE -1 };
		System.out.println("Second Largest in " + buildArrayString(arr) + " is :" + secondLargest(arr));
		
//		int result = secondLargest(arr);
//		System.out.println(result);
	}

	/*
	 * Builds a comma separated string of the integer array
	 */
	private static String buildArrayString(int[] arr) {
		if (arr == null) return null; 
		if (arr.length == 0) return " ";
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < arr.length-1; i++) {
			sb.append(arr[i]);
			sb.append(",");
		}
		sb.append(arr[arr.length-1]);
		return sb.toString();
	}

}
