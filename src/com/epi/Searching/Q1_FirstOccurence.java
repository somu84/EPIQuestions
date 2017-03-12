package com.epi.Searching;

import java.util.List;

public class Q1_FirstOccurence {
	
	public static int firstOccurence(List<Integer> arr, int num){
		int left = 0, right = arr.size()-1, result = -1;
		while(left <= right){
			int mid = left + ((right-left)/2);
			if(arr.get(mid) > num){
				right = mid -1;
			}
			else if(arr.get(mid) == num){
				result = mid;
				right = mid -1;
			}
			else{
				left = mid +1;
			}
		}
		return result;
	}

}
