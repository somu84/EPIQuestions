package com.epi.HashTables;

import java.util.HashSet;

public class Q1_CheckPalindrome {
	
	public static boolean checkPalindrome(String word){
		if(word.length() == 0)
			return false;
		HashSet<Character> c = new HashSet<>();
		for(char ch: word.toCharArray()){
			if(c.contains(ch)){
				c.remove(ch);
			}else{
				c.add(ch);
			}
		}
		if(c.isEmpty() || (c.size() == 1 && word.length() %2 != 0))
			return true;
		return false;
	}
	
	public static void main(String[] args){
		String word = "edified";
		String word2 = "rotator";
		String word3 = "";
		String word4 = "ship";
		System.out.println(word+" :"+checkPalindrome(word));
		System.out.println(word2+" :"+checkPalindrome(word2));
		System.out.println(word3+" :"+checkPalindrome(word3));
		System.out.println(word4+" :"+checkPalindrome(word4));
	}

}
