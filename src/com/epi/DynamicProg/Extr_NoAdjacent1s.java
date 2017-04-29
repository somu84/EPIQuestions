package com.epi.DynamicProg;
/**
 * https://www.careercup.com/question?id=4836228449959936
 * Given m 0s and n 1s count total permutations such that two 1s can't be adjacent
 * @author Somu
 *
 */
public class Extr_NoAdjacent1s {
	public static int DP(int m, int n){
		if(m == 0 && n == 0) return 1;
		if(m == n-1) return 1;
		int[][]T = new int[m+1][n+1];
		for(int i = 0; i<T.length; i++){
			T[i][0] = 1;
		}
		//T[0][1] = 1;
		for(int i = 0; i < T.length; i++){
			for(int j = 1; j< T[i].length; j++){
				if(j == i+1){
					T[i][j] = 1;
				}
				else if( j > i+1) break;
				else if(j == i){
					T[i][j] = T[i-1][j]+T[i-1][j-1];
				}else{
					T[i][j] = T[i][j-1]+T[i-1][j];
				}
			}
		}
		return T[m][n];
	}
	
	public static void main(String[] args){
		System.out.println(DP(3, 2));
	}

}
