package com.epi.Searching;

public class Q6_Srch2DMatrix {
	
	public static boolean search2D(int[][] arr, int x){
		int i=0, j = arr[0].length-1;
		while(i < arr.length && j >= 0){
			if(arr[i][j] == x) return true;
			else if(arr[i][j] < x) i++;
			else j--;
		}
		return false;
	}

}
