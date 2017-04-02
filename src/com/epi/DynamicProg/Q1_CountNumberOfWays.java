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
	}

}
