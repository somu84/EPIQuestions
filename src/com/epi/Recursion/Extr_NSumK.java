package com.epi.Recursion;

import java.util.*;

/**
 * https://www.careercup.com/question?id=4917596202729472
 * @author Somu
 *
 */
public class Extr_NSumK {
	public static List<List<Integer>> getSums(int sum, int n){
		List<List<Integer>> res = new ArrayList<>();
		if(n == 0 || sum < 0) return res;
		getSum(sum, n, new ArrayList<Integer>(), res);
		return res;
	}
	
	private static void getSum(int sum, int n, List<Integer> temp, List<List<Integer>> res){
		if(n == 0){
			if(sum == 0)
				res.add(new ArrayList<Integer>(temp));
			return;
		}
		for(int i = sum; i>= 0; i--){
			temp.add(i);
			getSum(sum - i, n-1, temp, res);
			temp.remove(temp.size() -1);
		}
	}
	
	public static void main(String[] args){
		List<List<Integer>> res = getSums(4, 2);
		for(List<Integer> l : res){
			System.out.println(l);
		}
	}

}
