package com.epi.Arrays;

import java.util.*;

public class Q5_DuplicatesInSortedArr {
	public static void filterDups(List<Integer> arr){
		int w =1;
		for(int i=1; i<arr.size(); i++){
			if(!arr.get(w-1).equals(arr.get(i))){
				arr.set(w++, arr.get(i));
			}
		}
		while(w != arr.size()){
			arr.set(w, 0);
			w++;
		}
		return;
	}
	
	public static void main(String[] args){
		int[] arr = {2,3,5,5,7,11,11,11,13};
		List<Integer> l = new ArrayList<>();
		for(int i:arr){
			l.add(i);
		}
		filterDups(l);
		for(int i: l ){
			System.out.print(i+" ");
		}
		
	}

}
