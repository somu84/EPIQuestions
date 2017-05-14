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
		int[] arr = {5000, 5000, 5000};
		List<Integer> l = new ArrayList<>();
		for(int i:arr){
			l.add(i);
		}
		//filterDups(l);
		int a = removeDuplicates(l);
		for(int i: l ){
			System.out.print(i+" ");
		}
		
	}
	
	public static int removeDuplicates(List<Integer> a) {
	    int p = 0;
	    for(int i = 1; i<a.size(); i++){
	        if(!a.get(p).equals(a.get(i))){
	            a.set(p+1, a.get(i));
	            p++;
	        }
	    }
	    int n = p+1;
	    int len = a.size();
	    while(n < len){
	        a.remove(a.size()-1);
	        n++;
	    }
	    return a.size();
	}

}
