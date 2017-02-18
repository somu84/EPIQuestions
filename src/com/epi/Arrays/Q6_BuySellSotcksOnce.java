package com.epi.Arrays;

public class Q6_BuySellSotcksOnce {
	/**
	 * Space Complexity O(1) && Time Complexity O(n)
	 * @param arr
	 * @return
	 */
	public static double maxProfit(double arr[]){
		double max = 0;
		double minpr = arr[0];
		for(int i =1; i<arr.length; i++){
			double curr = arr[i] - minpr;
			if(curr > max){
				max = curr;
			}
			if(minpr > arr[i]){
				minpr = arr[i];
			}
		}
		return max;
	}
	
	public static void main(String args[]){
		double pr[] = {310,315,275,295,260,270,290,230,255,250};
		System.out.println("Max profile "+maxProfit(pr));
	}
}
