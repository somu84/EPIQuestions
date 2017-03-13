package com.epi.Sorting;

public class Q2_MergeTwoSorted {
	public static void merge(int[] a1, int[] a2, int m, int n){
		int w = m+n-1;
		int i=m, j=n;
		while(i>=0 && j>= 0){
			if(a1[i] > a2[j]){
				a1[w] = a1[i];
				i--;
				w--;
			}
			else{
				a1[w] = a2[j];
				j--;
				w--;
			}
		}
		while(j>=0){
			a1[w] = a2[j];
			w--;
			j--;
		}
	}

}
