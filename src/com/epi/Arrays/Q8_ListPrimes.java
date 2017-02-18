package com.epi.Arrays;

import java.util.ArrayList;

public class Q8_ListPrimes {
	public static ArrayList<Integer> getPrimes(int n){
		if(n < 2)
			return null;
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(2);
		
		for(int i=2; i<=n; i++ ){
			boolean is_prime = true;
			for(Integer p: list){
				if(i%p == 0){
					is_prime=false;
					break;
				}
			}
			if(is_prime){
				list.add(i);
			}
		}
		return list;
	}
	
	public static void main(String args[]){
		int n = 100;
		ArrayList<Integer> pr = getPrimes(n);
		for(Integer p:pr)
			System.out.print(p+" ");
	}
}
