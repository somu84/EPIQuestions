package com.epi.Arrays;

public class RotateArray {
	public static void rotate(int[] arr, int k){
		if(k <= 0) return;
		int idx = k % arr.length;
		reverse(arr, 0, idx);
		reverse(arr, idx + 1, arr.length -1);
		reverse(arr, 0, arr.length-1);
	}
	private static void reverse(int[] arr, int st, int end){
		int i = st;
		int j = end;
		while(i < j){
			int t = arr[i];
			arr[i] = arr[j];
			arr[j] = t;
			i++;
			j--;
		}
	}
	
	public static void main(String[] args){
		int[] arr = {1, 2, 3, 4, 5};
		rotate(arr, 2);
		for(int a : arr)
			System.out.print(a+" ");
	}
}
