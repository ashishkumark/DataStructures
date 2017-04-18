package com.ashish.prep;

public class BuySellMaxProfit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[] = new int[]{ 10, 40, 20, 30, 50 };
//		System.out.println(getMaxProfit(arr));
//		
//		System.out.println("*************************");
//		arr = new int[]{ 40, 10, 20, 30, 50 };
//		System.out.println(getMaxProfit(arr));
//
//		System.out.println("*************************");
//		arr = new int[]{ 40, 30, 20, 10, 00 };
//		System.out.println(getMaxProfit(arr));
//
//		System.out.println("*************************");
//		arr = null;
//		System.out.println(getMaxProfit(arr));
//
//		System.out.println("*************************");
//		arr = new int[]{ 40 };
//		System.out.println(getMaxProfit(arr));
		
		System.out.println(getMaxProfitWith1(arr));

		System.out.println("*************************");
		arr = new int[]{ 40, 10, 20, 30, 50 };
		System.out.println(getMaxProfitWith1(arr));

		System.out.println("*************************");
		arr = new int[]{ 40, 30, 20, 10, 00 };
		System.out.println(getMaxProfitWith1(arr));

		System.out.println("*************************");
		arr = null;
		System.out.println(getMaxProfitWith1(arr));

		System.out.println("*************************");
		arr = new int[]{ 40 };
		System.out.println(getMaxProfitWith1(arr));
		
		System.out.println("*************************");
		arr = new int[]{ 40, 10 };
		System.out.println(getMaxProfitWith1(arr));
		
	}
	
	public static int getMaxProfit(int arr[]) {
		
		if (arr == null || arr.length <= 1)
			return 0;
		int profit = 0, buy = -1, sell = -1;
//		boolean sold = false;
//		boolean bought = true;
		int localMin = arr[0];
		
		for (int i=1; i<arr.length;i++) {
			if (arr[i-1] > arr[i]) {
				localMin = arr[i];
//				sold = true;
//				buy = i;
				sell = i-1;
			} else {
				profit += arr[i] - localMin;
				localMin = arr[i];
				if (buy == -1) {
					buy=i-1;
				}
//				bought = bought || true;
//				if (buy <= sell) {
//					
//				}
			}

			if (i == arr.length -1) {
				sell = i;
			}
			if (buy != -1 && sell != -1 && sell > buy) {
				System.out.println("buy = " + arr[buy] + " \nsell = " + arr[sell]);
				buy = sell = -1;
			}
/*			if (bought == true && sold == false) {
				System.out.println("Buy = " + arr[i-1]);
				bought = false;
				if (i == (arr.length-1)) {
					System.out.println("Sell = " + arr[i]);
				}
			} else if (bought == false && sold == true) {
				System.out.println("Sell = " + arr[i-1]);
				sold = false;
//				bought = false;
			} 
*/
		}
		
		return profit;
	}
	

	public static int getMaxProfitWith1(int arr[]) {

		
		if (arr == null || arr.length <= 1)
			return 0;
		int profit = 0;

		int localMin = arr[0];

		int maxDiff = 0;
		
		for (int i=1; i<arr.length;i++) {
			
			if (maxDiff < arr[i] - localMin) {
				maxDiff = arr[i] - localMin;
			} 
			
			if (arr[i] < localMin) {
				localMin = arr[i];
			}
			
		}
		if (maxDiff > 0) {
			profit = maxDiff;
		}
		
		return profit;
	
	}

}
