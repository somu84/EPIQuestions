package com.epi.DynamicProg;

public class Extr_MaxSumSubSeq {
	
	public static int maxSumContig(int[] arr){
		int[] T = new int[arr.length];
		for(int i=0; i<T.length; i++){
			T[i] = Integer.MIN_VALUE;
		}
		return maxSumContig(arr, arr.length-1, T);
	}
	
	public static int maxSumContig(int[] arr, int i, int[] T){
		if(T[i] == Integer.MIN_VALUE){
			if(i == 0){
				T[i] = arr[i];
			}
			else
				T[i]= Math.max(arr[i], maxSumContig(arr, i-1, T)+arr[i]);
		}
		return T[i];
	}
	
	public static int maxSumNonContig(int[] arr){
		int maxSum = 0;
		for(int i=0; i< arr.length; i++){
			if(arr[i] <= 0) continue;
			maxSum +=arr[i];
		}
		return maxSum;
	}

	public static void main(String[] args){
		int[] arr = {-6, 2, -4, 1, 3, -1, 5, -1};
		System.out.println(maxSumContig(arr));
		System.out.println(maxSumNonContig(arr));
	}
}
