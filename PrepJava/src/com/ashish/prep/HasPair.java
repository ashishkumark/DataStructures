package com.ashish.prep;

import java.util.HashSet;
import java.util.Set;

public class HasPair {

	
	public static void main(String[] args) {
		int[] arr = new int[] {1, 2, 3, 9};
		hasPairMatchingSum(arr, 10);
		arr = new int[] {1, 2, 4, 4};
		hasPairMatchingSum(arr, 8);
		arr = new int[] {1};
		hasPairMatchingSum(arr, 10);
		arr = null;
		hasPairMatchingSum(arr, 10);
		arr = new int[] {9, 1, 2, 3};
		hasPairMatchingSumUnordered(arr, 10);
		arr = new int[] {2, 1, 4, 4};
		hasPairMatchingSumUnordered(arr, 9);
	}

	private static void hasPairMatchingSum(int[] arr, int sum) {
		if (arr == null || arr.length == 1) { System.out.println("Not a good sample"); return; }
		int l = 0;
		int h = arr.length -1;
		while (l < h) {
			if (arr[l] + arr[h] == sum) {
				System.out.println("YES = " + l + "," + h);
				break;
			} else if (arr[l] + arr[h] < sum) {
				l++;
			} else {
				h--;
			}
		}
		if (l==h) { System.out.println("NO"); }
		return;
	}

	private static void hasPairMatchingSumUnordered(int[] arr, int sum) {
		if (arr == null || arr.length == 1) { System.out.println("Not a good sample"); return; }
		Set<Integer> comp = new HashSet<Integer>(); 
		for (int i = 0; i < arr.length; i++) {
			if (comp.contains(arr[i])) {
				System.out.println("Its a match");
				return;
			}
			comp.add(sum - arr[i]);
		}
		System.out.println("No match found");
		return;
	}
}
