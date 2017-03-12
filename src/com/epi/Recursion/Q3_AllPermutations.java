package com.epi.Recursion;

import java.util.ArrayList;
import java.util.List;

public class Q3_AllPermutations {
	public static List<String> getPermutations(String arr){
		List<String> result = new ArrayList<>();
		for(int i = 0; i<arr.length(); i++){
			callStack(strSwap(arr, 0, i), result, 1);
		}
		return result;
	}
	
	public static String strSwap(String arr, int i, int j){
		char[] tmp = arr.toCharArray();
		char t1 = tmp[i];
		tmp[i] = tmp[j];
		tmp[j] = t1;
		return String.valueOf(tmp);
	}
	
	public static void callStack(String str, List<String>result, int level){
		if(level == str.length()-1){
			result.add(str);
			return;
		}
		for(int i=level;i<str.length();i++){
			callStack(strSwap(str,level,i),result, level+1);
		}
	}
	
	public static void main(String[] args){
		List<String> perms = getPermutations("abcd");
		for(String p1: perms){
			System.out.println(p1);
		}
	}
}
