package com.epi.Recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://www.youtube.com/watch?v=AfxHGNRtFac&t=61s
 * 
 * Looking at the recursion tree solves the problem.
 * Just go level by level and swap characters
 *                     ABC
 *                    / |  \
 *                 ABC BAC  CBA 
 *               / |   / \     | \
 *            ABC ACB BAC BCA CBA CAB
 * @author Somu
 *
 */
public class Q3_StringPermutations {
	public static List<String> getPermutations(String arr){
		List<String> result = new ArrayList<>();
		//if(arr == null) return result;
		if(arr == null || arr.length() == 0) return result;
		//This is the first level, where we only swap the first character, with the rest
		//and make recursive calls for resulting string. 
		for(int i = 0; i<arr.length(); i++){
			callStack(strSwap(arr, 0, i), result, 1);
		}
		return result;
	}
	
	/**
	 * Method to swap two characters in a string
	 * @param arr
	 * @param i
	 * @param j
	 * @return
	 */
	public static String strSwap(String arr, int i, int j){
		char[] tmp = arr.toCharArray();
		char t1 = tmp[i];
		tmp[i] = tmp[j];
		tmp[j] = t1;
		return String.valueOf(tmp);
	}
	
	/**
	 * Recursive function, which first swaps the character at that index (level) with the rest of the characters
	 * and makes recursive calls to itself
	 * Base case: 
	 * When the level is the last character of the string, as no more swaps are possible.
	 * @param str
	 * @param result
	 * @param level
	 */
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
		List<String> perms = getPermutations(null);
		if(perms.isEmpty() || perms == null)
			System.out.println("Empty String");
		for(String p1: perms){
			System.out.println(p1);
		}
	}
	
	/**
	 * Slight modification, to use a hashset. In order to keep track of duplicates
	 * This is to weed out duplicates, arising due to repeated characters in the string.
	 * @param arr
	 * @return
	 */
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
