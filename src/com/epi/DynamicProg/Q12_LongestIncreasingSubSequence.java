package com.epi.DynamicProg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * https://www.youtube.com/watch?v=CE2b_-XfVDk&list=PLrmLmBdmIlpsHaNTPP_jHHDx_os9ItYXr&index=6
 * Space Complexity : O(n)
 * Time Complexity : O(n^2)
 * @author Somu
 *
 */
public class Q12_LongestIncreasingSubSequence {
	public static int longestSub(int[]arr){
		int[] temp = new int[arr.length];
		Arrays.fill(temp, 1);
		int max = 1;
		int maxIndex = 0;
		for(int i=1; i<arr.length; i++){
			for(int j=0;j<i;j++){
				if(arr[j]<arr[i]){
					temp[i] = Math.max(temp[i], temp[j]+1);
					if(max < temp[i]){
						max = temp[i];
						maxIndex = i;
					}
				}
			}
		}
		printSeq(arr, maxIndex, temp);
		return max;
	}
	
	public static void printSeq(int[]arr, int index, int[] T){
		List<Integer> res = new ArrayList<>();
		res.add(0,arr[index]);
		int max = T[index];
		for(int i=index; i>=0; i--){
			if(arr[i]<res.get(0) && T[i] == max -1){
				res.add(0,arr[i]);
				max -= 1;
			}
		}
		for(int k:res){
			System.out.print(k+",");
		}
		System.out.println();
	}
	
	public static void main(String[] args){
		int[] arr = {0, 8, 4, 12, 2,  10, 6, 14, 1, 9};
		System.out.println(longestSub(arr));
	}

}
