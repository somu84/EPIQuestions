package com.epi.DynamicProg;

public class Q4_BinomialCoeff {
	public static int getBinomial(int n, int k){
		if(k==0 || k==n){
			return 1;
		}
		return getBinomial(n-1, k-1)+getBinomial(n-1,k);
	}
	
	//Optimization Memoization
	public static int getBinomial2(int n, int k){
		return binomialHelper(n, k, new int[n+1][k+1]);
	}
	
	/**
	 * https://www.youtube.com/watch?v=3D_Oj16EtD8
	 * @param n
	 * @param k
	 * @param tmp
	 * @return
	 */
	private static int binomialHelper(int n, int k, int[][]tmp){
		if(k==0 || n==k)
			return 1;
		for(int i=0; i<n;i++){
			for(int j=0; j<=Math.min(i,k);j++){
				if(j==0||j==i){
					//Base case
					tmp[i][j] = 1;
				}
				else{
					tmp[i][j] = tmp[i-1][j]+tmp[i-1][j-1];
				}
			}
		}
		return tmp[n][k];
	}
}
