package com.epi.Arrays;

import java.util.*;

public class Extr_FindDuplicatedBetweenTwoArr {
	public static List<Integer> getDuplicates(int[] arr1, int[] arr2){
		List<Integer> res = new ArrayList<>();
		if(arr1.length == 0 || arr2.length == 0) return res;
		BitSet b = new BitSet();
		for(int a: arr1){
			b.set(a);
		}
		for(int a: arr2){
			if(b.get(a))
				res.add(a);
		}
		return res;
	}

	public static void main(String[] args){
		int[] a1 = {1, 8, 4, 5};
		int[] a2 = {8, 5, 6, 1};
		System.out.println(getDuplicates(a1, a2));
	}
}
