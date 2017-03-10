package com.epi.DynamicProg;

public class Extr_LongestPalindromicSeq {
	
	public static int getLen(String str){
		int[][] T = new int[str.length()][str.length()];
		return getLen(str, 0, str.length()-1, T);
	}
	
	private static int getLen(String str, int i, int j, int[][]T){
		if(T[i][j] == 0){
			if(i==j){
				T[i][j] = 1;
				return T[i][j];
			}
			if(str.charAt(i) == str.charAt(j)){
				if(i+1 == j){
					T[i][j] = 2;
					return T[i][j];
				}
				else{
					T[i][j] = 2+getLen(str, i+1, j-1,T);
					return T[i][j];
				}
			}
			else{
				T[i][j] = Math.max(getLen(str, i+1, j,T), getLen(str, i, j-1,T));
				return T[i][j];
			}
		}
		return T[i][j];
	}
	
	
	public static void main(String[] args){
		String str = "ventilator";
		System.out.println(getLen(str));
	}

}
