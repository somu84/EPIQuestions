package com.epi.DynamicProg;

import java.util.*;

public class Q6_KnapSackProblem {
/**
 * The basic principle is 
 * 1. If the KnapSack capacity is 0 or the total items are 0, we return 0.
 * 2. If the weight of the item is greater than the KnapSack capacity, we return 0.
 * 3. Else we get the max of (total value if we consider the item , total value without considering the item).
 * 
 * The above three steps call for a recursive solution.
 * We use a 2D matrix as an optimization to the recursive function to store the previously calculated values.
 */
	
	/**
	 * Naive recursive approach
	 * Time Complexity: O(2^n)
	 * Space Complexity: O(1)
	 * @param wt
	 * @param val
	 * @param W
	 * @param n
	 * @return
	 */
	public static int knapSack1(int[] wt, int[] val, int W, int n){
		if(n == 0 || W==0)
			return 0;
		if(wt[n=1] > W )
			return knapSack1(wt,val, W, n-1);
		else
			return Math.max(val[n-1]+knapSack1(wt,val,W-wt[n-1],n-1),
					knapSack1(wt,val,W,n-1));
	}
	
	/**
	 * This is the optimized DP solution to the KS problem.
	 * Time Complexity : O(n*W)
	 * Space Complexity: O(n*W) 
	 * @param wt
	 * @param val
	 * @param W
	 * @param n
	 * @return  
	 */
	public static int knapSackDP(int[]wt, int[]val, int W, int n){
		int[][]K = new int[n+1][W+1];//Used for memoization
		for(int i=0; i<=n; i++){
			for(int j=0;j<=W;j++){
				if(j==0||i==0)
					K[i][j] = 0;
				else if(wt[i-1]<=j){
					K[i][j] = Math.max(val[j-1]+K[i-1][j-wt[i-1]],K[i-1][j]);
				}
				else
					K[i][j] = K[i-1][j];
			}
		}
		return K[n][W];
	}
	
	/**
	 * This is a space optimized DP solution to the above DP function.
	 * Time Complexity: O(n*W)
	 * Space Complexity: O(W)
	 * @param wt
	 * @param val
	 * @param W
	 * @param n
	 * @return
	 */
	public static int knapSackDPOpt(int[]wt, int[]val, int W, int n){
		int[] K = new int [W+1];
		for(int i=0; i<n; i++){
			for(int j=W; j>=wt[i];j--){
				K[j] = Math.max(val[i]+K[j-wt[i]], K[j]);
			}
		}
		return K[W];
	}
	
	static class Item{
		int totalW;
		int remI;
		Item(int w, int i){
			totalW = w;
			remI = i;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + remI;
			result = prime * result + totalW;
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Item other = (Item) obj;
			if (remI != other.remI)
				return false;
			if (totalW != other.totalW)
				return false;
			return true;
		}
		
	}
	
	public static int KS(int[] c, int[] w, int TW){
		if(c == null || w == null || c.length == 0 || w.length == 0)
			return 0;
		HashMap<Item, Integer> map = new HashMap<>();
		return KS(c, w, TW, map, c.length - 1);
	}
	
	private static int KS(int[] c, int[] w, int TW, HashMap<Item, Integer> map, int iR){
		if(iR < 0 || TW <= 0) return 0;
		Item i = new Item(TW, iR);
		if(!map.containsKey(i)){
			int num = c.length - 1 - iR;
			int v;
			if(w[num] <= TW){
				v  = Math.max(c[num]+KS(c, w, TW-w[num], map, iR-1), 
						KS(c, w, TW, map, iR-1));
			}
			else{
				v = KS(c, w, TW, map, iR-1);
			}
			map.put(i, v);
		}
		return map.get(i);
	}
	
	public static void main(String[] args){
		int[]w = {2, 2, 4, 5};
		int[]c = {2, 4, 6, 9};
		System.out.println(KS(c, w, 8));
	}
}
