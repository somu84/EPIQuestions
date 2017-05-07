package com.epi.DynamicProg;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Q7_WordBreakProblem {

	//Solution using DP. Time Complexity O(len * dict.size)
	//http://www.programcreek.com/2012/12/leetcode-solution-word-break/
	public boolean wordBreak(String s, Set<String> dict){
		boolean[]t = new boolean[s.length() +1];
		t[0] = true;
		
		for(int i=0; i<s.length(); i++){
			if(!t[i])
				continue;
			for(String a:dict){
				int len = a.length();
				int end = i+len;
				if(end > s.length())
					continue;
				if(t[end]) continue;
				if(s.substring(i,end).equals(a))
					t[end] = true;
			}
		}
		return t[s.length()];
	}
	
	/**
	 * The following solution is taken from following
	 * https://www.youtube.com/watch?v=WepWFGxiwRs
	 * @param s
	 * @param dict
	 * @return
	 */
	//Easier Solution
	public boolean wordBreakBottomUpDP(String s, Set<String> dict){
		boolean[]T = new boolean[s.length() + 1];
		T[0] = true;
		for(int i=1; i<s.length();i++){
			for(int j=0; j<i; j++){
				if(T[j] && dict.contains(s.substring(j,i))){
					T[i] = true;
					break;
				}
			}
		}
		return T[s.length()];
	}
	
	//DP Solution if we have to return the actual words.
	public String breakWordDP(String word, Set<String> dict){
		int T[][] = new int[word.length()][word.length()];
		
		for(int i=0;i<T.length;i++){
			for(int j=0; j<T[i].length;j++){
				T[i][j] = -1;
			}
		}
		
		for(int l = 1; l<=word.length();l++){
			for(int i=0; i<word.length()-l+1;i++){
				int j= i+l-1;
				
				String str = word.substring(i, j+1);
				if(dict.contains(str)){
					T[i][j] = i;
					continue;
				}
				
				for(int k=i+1; k<j;k++){
					if(T[i][k-1] != -1 && T[k][j] != -1){
						T[i][j] = k;
						break;
						
					}
				}
			}
		}
		
		if(T[0][word.length()-1]==-1)
			return null;
		
		//Build the word list
		StringBuffer buff = new StringBuffer();
		int i=0, j=word.length()-1;
		while(i<j){
			int k=T[i][j];
			if(i==k){
				buff.append(word.substring(i,j+1));
				break;
			}
			buff.append(word.substring(i,k)+" ");
			i=k;
		}
		return buff.toString();
	}
	
	/**
	 * http://thenoisychannel.com/2011/08/08/retiring-a-great-interview-problem
	 * Word break problem using DP
	 * Time Complexity: O(n^2) 
	 * @param str
	 * @param dict
	 * @param map
	 * @return
	 */
	public static String getWords(String str, Set<String> dict, HashMap<String, String> map){
		if(str == null || str.length() == 0)
			return str;
		if(dict.contains(str))
			return str;
		if(map.containsKey(str)){
			return map.get(str);
		}
		int len = str.length();
		for(int i = 1; i<len; i++){
			String pref = str.substring(0, i);
			if(dict.contains(pref)){
				String suff = getWords(str.substring(i, len), dict, map);
				if(suff != null){
					map.put(str, pref+" "+suff);
					return pref+" "+suff;
				}
			}
		}
		return null;
	}
	
	
	public static void main(String[] args){
		Set<String> dict = new HashSet<>();
		dict.add("geek");
		dict.add("geeks");
		dict.add("for");
		dict.add("god");
		dict.add("is");
		HashMap<String, String> map = new HashMap<>();
		System.out.println(getWords("godisgeek", dict, map));
	}
}
