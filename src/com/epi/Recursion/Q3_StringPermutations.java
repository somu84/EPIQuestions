package com.epi.Recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q3_StringPermutations {
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
		List<String> perms = getPermutations1("aba");
		for(String p1: perms){
			System.out.println(p1);
		}
	}
	
	public static List<String> getPermutations1(String arr){
		List<String> result = new ArrayList<>();
		HashSet<String> temp = new HashSet<>();
		for(int i = 0; i<arr.length(); i++){
			//if(arr.charAt(0) == arr.charAt(i)) continue;
			if(!temp.contains(strSwap(arr, 0, i))){
				callStack1(strSwap(arr, 0, i), result, 1, temp);
				temp.add(strSwap(arr, 0, i));
			}
		}
		return result;
	}
	
	public static void callStack1(String str, List<String>result, int level, Set<String> temp){
		if(level == str.length()-1){
			result.add(str);
			return;
		}
		for(int i=level;i<str.length();i++){
			if(!temp.contains(strSwap(str, level, i))){
				callStack1(strSwap(str,level,i),result, level+1, temp);
				temp.add(strSwap(str, level, i));
			}
		}
	}
}
