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
		if(arr[ind] == 0)
		if( arr[ind]*10 + arr[ind+1] <= 26 && arr[ind]*10 + arr[ind+1] >= 10)
			return 1+getCnt(arr, ind-1);
		return getCnt(arr, ind-1);
	}
	
	private static int getCnt(int[] input) {
	    int[] A = new int[input.length + 1];
	    A[0] = 1;

	    for(int i=1; i<input.length+1; i++) {
	      A[i] = 0;
	      if(input[i-1] > 0) {
	        A[i] += A[i-1];
	      }
	      if (i > 1 && (10*input[i-2] + input[i-1]) <= 26) {
	        A[i] += A[i-2];
	      }
	    }
	    return A[input.length];
	}
	
	public static void main(String[] args){
		int[] arr = {1, 3, 0};
		System.out.println(count(arr));
		System.out.println(getCnt(arr));
	}

}
