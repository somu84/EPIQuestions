package com.epi.Recursion;

public class Extr_NumberOfValidCombinations {
	static int count(int[]arr){
		if(arr.length == 0) return 0;
		return getCnt(arr, arr.length -1);
	}
	
	static int getCnt(int[]arr, int ind){
		if(ind < 0) return 0;
		if(ind == arr.length-1){
			if(arr[ind] > 0){
				return 1+getCnt(arr, ind-1);
			}else{
				return getCnt(arr, ind-1);
			}
		}
		if(arr[ind] > 0 && arr[ind]*10 + arr[ind+1] <= 26)
			return 1+getCnt(arr, ind-1);
		return getCnt(arr, ind-1);
	}
	
	public static void main(String[] args){
		int[] arr = {4, 3, 0};
		System.out.println(count(arr));
	}

}
