package com.epi.Arrays;

public class Q1_DutchFlag {
	/**
	 * The algorithm takes O(1) space and O(n) time.
	 * It maintains three pointers 
	 * 	small : for elements smaller than pivot
	 * 	equal : for elements equal to pivot
	 * 	larger : for elements larger than pivot
	 * 
	 * We increment small and equal and decrement larger 
	 * as we come across elements.
	 * @param arr
	 * @param pivot
	 */
	public static void DutchSort(int[] arr, int pivot){
		int small = 0, equal = 0, larger = arr.length -1;
		while(equal < larger){
			if(arr[equal] < pivot){
				swap(arr, small++, equal++);
			}
			else if(arr[equal] == pivot){
				equal++;
			}
			else{
				swap(arr,larger--, equal);
			}
		}
	}
	
	public static void swap(int[] arr, int i, int j){
		int t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}
	

}
