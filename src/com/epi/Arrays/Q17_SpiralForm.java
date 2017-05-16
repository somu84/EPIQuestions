package com.epi.Arrays;

import java.util.*;

public class Q17_SpiralForm {
	public static void sprialPrint(int m, int n, int[][] arr){
		int k = 0, l=0;
		while( k < m && l < n){
			for(int i = l; i < n; i++){
				System.out.print(arr[k][i]);
			}
			k++;
			for(int i=k; i<m; i++){
				System.out.print(arr[i][n-1]);
			}
			n--;
			if(k<m){
				for(int i=n-1; i>=l;  i--){
					System.out.print(arr[m-1][i]);
				}
				m--;
			}
			if(l < n){
				for(int i=m-1; i>=k; i--){
					System.out.print(arr[i][l]);
				}
				l++;
			}
		}
	}
	
	/**
	 * Sprial Printing
	 * @param arr
	 * @return
	 */
	public static List<Integer> spiralForm(int[][]arr){
		List<Integer> res = new ArrayList<>();
		if(arr.length == 0 || arr[0].length == 0) return res;
		int top = 0, bottom = arr.length-1;
		int left = 0, right = arr[0].length-1;
		while(res.size() < arr.length*arr[0].length){
			for(int j = left; j<= right; j++){
				res.add(arr[top][j]);
			}
			top++;
			for(int j = top; j<= bottom; j++){
				res.add(arr[j][right]);
			}
			right--;
			for(int j = right; j>=left; j--){
				res.add(arr[bottom][j]);
			}
			bottom--;
			for(int j = bottom; j>=top; j--){
				res.add(arr[j][left]);
			}
			left++;
		}
		return res;
	}
	
	public static void main(String[]args){
		int[][]arr = {{1,2,3,4},
				      {5,6,7,8},
				      {9,10,11,12},
				      {13,14,15,16},
				      {17,18,19,20},
				      {21,22,23,24}};
		System.out.println(spiralForm(arr));
	}
}
