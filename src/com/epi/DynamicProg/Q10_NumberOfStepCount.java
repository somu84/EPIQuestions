package com.epi.DynamicProg;

public class Q10_NumberOfStepCount {
	/**
	 * Time Complexity: O(n*k)
	 * Space Complexity: O(n)
	 * @param n
	 * @param step
	 * @return
	 */
	public static int getWays(int n, int k){
		int[]memo = new int[n+1];
		return ways(n, k, memo);
	}
	
	private static int ways(int n, int k, int[] memo){
		if(n <= 0) return 1;
		if(memo[n] == 0){
			for(int i = 1; i<= k && n - i >= 0; i++){
				memo[n] += ways(n-i, k, memo);
			}
		}
		return memo[n];
	}

}
