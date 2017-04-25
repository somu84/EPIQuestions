package com.epi.BST;

import java.util.*;

public class Q6_MinDiffThreeSortedArrs {
	
	/**
	 * Time Complexity : if A is of length i
	 *                      B is of length j
	 *                      C is of length k
	 *            O(i+j+k)
	 * Space Complexity: O(1)
	 * @param A
	 * @param B
	 * @param C
	 * @return
	 */
	public static List<Integer> getDiff(int[]A, int[]B, int[]C){
		int res_a = 0, res_b = 0, res_c = 0;
		int i=0, j=0, k=0;
		int mDiff = Integer.MAX_VALUE;
		while(i<A.length && j<B.length && k<C.length){
			int min = Math.min(A[i], Math.min(B[j], C[k]));
			int max = Math.max(A[i], Math.max(B[j], C[k]));
			if(mDiff > max - min){
				mDiff = max - min;
				res_a = A[i];
				res_b = B[j];
				res_c = C[k];
			}
			if(A[i] == min)
				i++;
			else if(B[j] == min)
				j++;
			else
				k++;
		}
		List<Integer> res = new ArrayList<>();
		res.add(res_a);
		res.add(res_b);
		res.add(res_c);
		return res;
	}
	
	public static void main(String[] args){
		int[] A = {20, 24, 100};
		int[] B = {2, 19, 22, 79, 800};
		int[] C = {10, 12, 23, 24, 119};
		System.out.println(getDiff(A, B, C));
	}

}
