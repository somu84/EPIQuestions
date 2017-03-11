package com.epi.Arrays;

import java.util.Collections;

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
	
	public static void main(String[] args){
		int[] arr = {0,1,2,3,0,2,1,4,2};
		dutchFlag(arr, 2);
		for(int i: arr){
			System.out.print(i+",");
		}
	}
	
	public static void dutchFlag(int[] arr, int index){
		int sm = 0;	
		int c = arr[index];
		for(int i=0; i<arr.length; i++){
			if(arr[i]<c){
				swap(arr, sm++, i);
			}
		}
		int l = arr.length - 1;
		for(int i=arr.length-1; i>=0; i--){
			if(arr[i]>c){
				swap(arr, l--, i);
			}
		}
	}
	
	

}
