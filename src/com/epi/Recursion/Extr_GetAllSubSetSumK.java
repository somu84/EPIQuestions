package com.epi.Recursion;

import java.util.*;

public class Extr_GetAllSubSetSumK {
	/**
	 * https://www.careercup.com/question?id=5727449196265472
	 * Find all subset in an integer array, which sum to K
	 * @param arr
	 * @param target
	 * @return
	 */
	public static List<List<Integer>> getSubSetSum(int[] arr, int target){
		List<List<Integer>> res = new ArrayList<>();
		if(arr == null || arr.length == 0) return res;
		getSubSet(arr, target, 0, new ArrayList<Integer>(), res);
		
		return res;
	}
	
	private static void getSubSet(int[]arr, int t, int idx, List<Integer>temp, List<List<Integer>> res){
		if(idx == arr.length){
			if(sum(temp) == t){
				res.add(new ArrayList<Integer>(temp));
			}
			return;
		}
		
		temp.add(arr[idx]);
		getSubSet(arr, t, idx+1, temp, res);
		temp.remove(temp.size()-1);
		getSubSet(arr, t, idx+1, temp, res);
	}
	
	private static int sum(List<Integer>arr){
		int sum = 0;
		for(int a: arr){
			sum+=a;
		}
		return sum;
	}
	
	public static void main(String[] args){
		int[] arr = {1, 2 ,5, 4, 3, 6, 7, 8};
		List<List<Integer>> res = getSubSetSum(arr, 12);
		for(List<Integer> a: res){
			System.out.println(a);
		}
	}

}
