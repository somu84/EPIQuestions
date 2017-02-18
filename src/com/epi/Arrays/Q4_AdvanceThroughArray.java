package com.epi.Arrays;

public class Q4_AdvanceThroughArray {
	static int steps = 0;
	public static boolean isSolvable(int arr[]){
		if(arr.length == 0 || arr[0] == 0 || arr[arr.length -1] == 0)
			return false;
		return isSolRec(arr, 0);
	}
	
	public static boolean isSolRec(int a[], int i){
		if(i >= a.length -1)
			return true;
		int j = a[i];
		if(j == 0){
			return false;
		}
		boolean res = false;
		while(j >= 1){
			res = isSolRec(a, i+j);
			steps +=1;
			if(res)
				return res;
			if(res == false){
				steps -=1;
				j--;
			}
		}
		return res;
	}
	
	public static void main(String args[]){
		int arr1[] = {3,3,1,0,2,0,1};
		int arr2[] = {3,2,0,0,2,0,1};
		if(isSolvable(arr1)){
			System.out.println("arr1: Solvable");
			System.out.println("Min Steps = "+steps);
		}
		else{
			System.out.println("arr1:Nope");
		}
		if(isSolvable(arr2)){
			System.out.println("arr2 : Solvable");
		}
		else{
			System.out.println("arr2: Nope");
		}
	}
}
