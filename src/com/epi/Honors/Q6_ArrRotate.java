package com.epi.Honors;

public class Q6_ArrRotate {
	public static void rotate(int[] arr, int k){
		k = k%arr.length;
		reverse(arr, 0, arr.length-1);
		reverse(arr, 0, k-1);
		reverse(arr,k , arr.length-1 );
	}
	
	public static void reverse(int[] arr, int i, int j){
		for(int l=i, k=j; l<k; l++, k--){
			int t = arr[l];
			arr[l] = arr[k];
			arr[k] = t;
		}
	}
	
	public static void main(String[] args){
		int[] arr = {1,2,3};
		rotate(arr, 1);
		for(int num: arr){
			System.out.print(num+" ");
		}
	}

}
