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
		
		int arr[] = {1,2,2,5,5,5,5,6,6,6,7,7,8};
		System.out.println("Max Lenght: "+variance(arr));
	}
	
	public static int variance(int[] arr){
		int maxL = 1;
		int currL = 1;
		if(arr.length == 0)
			return 0;
		for(int i=1; i<arr.length; i++){
			
			if(arr[i] == arr[i-1]){
				currL +=1;
			}
			else{
				currL = 1;
			}
			if(maxL < currL){
				maxL = currL;
			}
		}
		return maxL;
	}
}
