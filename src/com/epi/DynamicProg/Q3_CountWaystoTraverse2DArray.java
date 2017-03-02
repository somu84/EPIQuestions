package com.epi.DynamicProg;

public class Q3_CountWaystoTraverse2DArray {
	public static int countWays(int[][] arr){
		int[][]temp = new int[arr.length][arr[0].length];
		for(int i=0; i<temp[0].length; i++){
			temp[0][i] = 1;
		}
		for(int i=0; i<temp.length; i++){
			temp[i][0] = 1;
		}
		
		for(int i=1; i<temp.length; i++){
			for(int j=1; j<temp[0].length; j++){
				temp[i][j] = temp[i-1][j]+temp[i][j-1];
			}
		}
		return temp[temp.length-1][temp[0].length-1];
	}
	
	public static void main(String[] args){
		int[][] arr = {{0,0,0,0,0},
					   {0,0,0,0,0},
					   {0,0,0,0,0},
					   {0,0,0,0,0},
					   {0,0,0,0,0}};
		System.out.println("Number of Ways: "+countWays(arr));
	}

}
