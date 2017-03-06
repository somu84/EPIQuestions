package com.epi.DynamicProg;

import java.util.List;

/**
 * The Recurrence formula is; let R(a,b) is the max revenue for a player for coins a & b.
 * Then R(a,b) = max (C[a]+min(R(a+1,b-1),R(a+2,b)), C[b]+min(R(a,b-2),R(a+1,b-1)))
 * @author Somu
 *
 */
public class Q9_MaxCoinPickupGame {
	public static int getMaxRevene(List<Integer> coins){
		return computeMaxRev(coins, 0, coins.size()-1, new int[coins.size()][coins.size()]);
	}
	/**
	 * For recurrence optimization, we use memoization in a 2D matrix
	 * Time Complexity : O(n^2)
	 * Space Complexity: O(n^2)
	 * @param coins
	 * @param a
	 * @param b
	 * @param temp
	 * @return
	 */
	private static int computeMaxRev(List<Integer>coins, int a, int b, int[][]temp){
		if(a < b)
			return 0;
		if(temp[a][b] == 0){
			int maxPickA = coins.get(a)+Math.min(computeMaxRev(coins,a+2,b,temp), computeMaxRev(coins,a+1,b-1,temp));
			int maxPickB = coins.get(b)+Math.min(computeMaxRev(coins,a,b-2,temp), computeMaxRev(coins,a+1,b-1,temp));
			temp[a][b] = Math.max(maxPickA, maxPickB);
		}
		return temp[a][b];
	}
}
