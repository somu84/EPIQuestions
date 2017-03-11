package com.epi.Recursion;

import java.util.ArrayList;
import java.util.List;

public class Q2_NQueenProblem {
	
	public static List<List<Integer>> nQueen(int n){
		List<List<Integer>> res = new ArrayList<>();
		solveNQueen(n, 0, new ArrayList<Integer>(), res);
		return res;
	}
	
	public static void solveNQueen(int n, int row, List<Integer> colP, List<List<Integer>> res){
		//Base case
		if(n == row){
			res.add(new ArrayList<>(colP));
			return;
		}
		for(int i=0; i<n; i++){
			colP.add(i);
			if(isValid(colP)){
				//Recurse on the next row
				solveNQueen(n, row+1, colP, res);
			}
			colP.remove(colP.size()-1);
		}
	}
	
	public static boolean isValid(List<Integer> colP){
		int row = colP.size()-1;
		for(int i = 0; i<row; i++){
			int diff = Math.abs(colP.get(row) - colP.get(i));
			if(diff == 0 || diff == row - i){
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args){
		int n = 4;
		List<List<Integer>> res = nQueen(n);
		for(List<Integer> l1: res){
			System.out.println(l1);
		}
	}

}
