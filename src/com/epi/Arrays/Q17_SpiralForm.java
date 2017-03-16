package com.epi.Arrays;

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
}
