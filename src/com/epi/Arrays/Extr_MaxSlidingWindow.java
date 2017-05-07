package com.epi.Arrays;

import java.util.*;

/**
 * Given an array and a window size.
 * Write a function to print all the max elements in the window
 * as it slides down the length of the array.
 * @author Somu
 *
 */
public class Extr_MaxSlidingWindow {
	/**
	 * Function without using a queue
	 * if the array length is n and window size is k
	 * then Time Complexity : O(k * (n-k+1))
	 * @param arr
	 * @param len
	 * @return
	 */
	static List<Integer> getMax(int[] arr, int len){
		List<Integer> res = new ArrayList<>();
		if(arr == null || arr.length == 0 || len == 0){
			return res;
		}
		if(arr.length <= len){
			res.add(getMax(arr, 0, arr.length-1));
			return res;
		}
		int i =0, j = len-1, max = 0;
		while(j < arr.length){
			if(max == 0){
				max = getMax(arr, i, j);
				res.add(max);
			}
			else if(arr[j] > max){
				max = arr[j];
				res.add(max);
			}
			else if(arr[i] == max){
				res.add(max);
				max = 0;
			}else{
				res.add(max);
			}
			i++;
			j++;
		}
		return res;
	}
	
	static int getMax(int[]arr, int i, int j){
		int max = arr[i];
		for(int t = i+1; t<=j; t++){
			if(max < arr[t]){
				max = arr[t];
			}
		}
		return max;
	}
	
	public static void main(String[] args){
		int[] arr = {2, 3, 4, 2, 6, 2, 5, 1};
		System.out.println(getMax(arr, 3));
	}

}
