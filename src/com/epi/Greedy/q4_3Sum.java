package com.epi.Greedy;

import java.util.HashSet;
import java.util.Set;

public class q4_3Sum {
	
	public static boolean hasThreeSum(int[] A, int sum){
		for(Integer a: A){
			if(hasTwoSum(A, sum-a))
				return true;
		}
		return false;
	}
	
	public static boolean hasTwoSum(int[] A, int sum){
		Set<Integer> k = new HashSet<>();
		for(int i: A){
			if(k.contains(sum-i)){
				return true;
			}
			else{
				k.add(i);
			}
		}
		return false;
	}
	
	public static boolean hasKSum(int[] A, int sum, int k){
		if(k==3){
			return hasThreeSum(A, sum);
		}
		for(int a: A){
			if(hasKSum(A, sum-a, k-1))
				return true;
		}
		return false;
	}
	
	public static void main(String[] args){
		int[] arr = {11,2,5,7,3};
		System.out.println(hasThreeSum(arr, 50));
		System.out.println(hasKSum(arr, 17,4));
	}

}
