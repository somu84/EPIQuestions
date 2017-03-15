package com.epi.Arrays;

import java.util.Random;

public class Q11_SampleOfflineData {

	public static void sample(int[] arr, int k){
		int piv = 0;
		while(piv <= k-1){
			Random r = new Random();
			int sw = r.nextInt((arr.length-1) -(piv+1))+piv;
			swap(arr, piv,sw);
			piv++;
		}
	}
	
	public static void swap(int[] arr, int i, int j){
		int t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}
}
