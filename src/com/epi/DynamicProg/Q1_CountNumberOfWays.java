package com.epi.DynamicProg;

import java.util.ArrayList;
import java.util.List;

public class Q1_CountNumberOfWays {
	public static int countWays(int finalScore, List<Integer> scores){
		int[][]T = new int[scores.size()][finalScore+1];
		for(int i=0; i<T.length; i++){
			T[i][0] = 1;
		}
		for(int i=0; i<T.length; i++){
			for(int j=1; j<T[i].length; j++){
				int without = i-1 >= 0 ? T[i-1][j]:0;
				int with = j>=scores.get(i) ? T[i][j-scores.get(i)]:0;
				T[i][j] = with+without;
			}
		}
		return T[scores.size()-1][finalScore];
	}
	
	public static void main(String[] args){
		List<Integer> scores = new ArrayList<>();
		scores.add(2);
		scores.add(3);
		scores.add(7);
		System.out.println(countWays(12, scores));
		
		int[]arr = {2, 3, 5};
		System.out.println(getWays(arr, 12));
	}

	public static int getWays(int[]coins, int num){
		if(coins == null || coins.length == 0 || num <= 0) 
			return 0;
		int[][]dp = new int[coins.length+1][num+1];
		for(int i = 0; i<dp.length; i++){
			dp[i][0] = 1;
		}
		for(int i = 1; i < dp.length ; i++){
			for(int j = 1; j < dp[i].length; j++){
				if(j < coins[i-1]){
					dp[i][j] = dp[i-1][j];
					continue;
				}
				dp[i][j] = dp[i-1][j]+dp[i][j - coins[i-1]];
			}
		}
		return dp[coins.length][num];
	}
}
