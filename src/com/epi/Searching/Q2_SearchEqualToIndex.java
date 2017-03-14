package com.epi.Searching;

public class Q2_SearchEqualToIndex {
	public static int searchIndex(int[] arr){
		int i=0, j=arr.length-1;
		while(i<=j){
			int mid = i+((j-i)/2);
			if(mid==arr[mid]) return mid;
			else if(mid > arr[mid]){
				i=mid+1;
			}
			else{
				j=mid-1;
			}
		}
		return -1;
	}
	
	public static void main(String[] args){
		int[] arr = {10, -5, 0, 3, 7};
		int i = searchIndex(arr);
		if(i==-1){
			System.out.println("Not Found");
		}
		else{
			System.out.println(i);
		}
 	}

}
