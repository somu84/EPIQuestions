package com.epi.Recursion;

import java.util.*;

public class Q7_GeneratePalindromicDecomp {
	/**
	 * This is a recursive approach.
	 * Time Complexity : Since there are 2^n substrings and it takes O(n) to check
	 * if they are a palindrome, 
	 * The time complexity : O(n*2^n)
	 * Space Complexity: O(2^n)
	 * @param str
	 * @return
	 */
	public static List<List<String>> getPal(String str){
		List<List<String>> res = new ArrayList<>();
		if(str == null || str.length() == 0)
			return res;
		getPal(str, 0, new ArrayList<String>(), res);
		return res;
	}
	
	private static void getPal(String str, int off, List<String> par, List<List<String>> res){
		if(off == str.length()){
			res.add(new ArrayList<String>(par));
			return;
		}
		for(int i = str.length(); i>off; i--){
			if(isPal(str.substring(off, i))){
				par.add(str.substring(off, i));
				getPal(str, i, par, res);
				par.remove(par.size()-1);
			}
		}
	}
	
	private static boolean isPal(String str){
		int l = 0;
		int r = str.length()-1;
		while(l < r){
			if(str.charAt(l) != str.charAt(r))
				return false;
			l++;
			r--;
		}
		return true;
	}

	public static void main(String[] args){
		List<List<String>> res = getPal("abaca");
		for(List<String> l: res){
			System.out.println(l);
		}
	}
}
