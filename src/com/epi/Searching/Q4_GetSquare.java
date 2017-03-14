package com.epi.Searching;

public class Q4_GetSquare {
	public static int getNum(int num){
		int i=1;
		int j = num;
		int mid = 0;
		while(i<=j){
			mid = i+(j-i)/2;
			if(mid*mid == num){
				return mid;
			}
			else if(mid * mid < num){
				i=mid+1;
			}
			else{
				j=mid-1;
			}
		}
		return mid;
	}
	
	public static void main(String[] args){
		System.out.println(getNum(300));
	}

}
