package com.epi.Honors;

public class Q26_RegexMatch {
	/**
	 * Recurrence Relation
	 * https://www.youtube.com/watch?v=l3hda49XcDE&t=52s
	 * 
	 * if(str[i] == patter[j] || pattern[j] == '.')
	 * 		T[i][j] = T[i-1][j-1];
	 * else if(pattern[j] == '*'){
	 * 		if(str[i] == pattern[j-1] || pattern[j-1] == '.')
	 * 			T[i][j] = T[i-1][j]
	 * `	else
	 * 			T[i][j] = T[i][j-2]
	 * }
	 * else
	 * 		T[i][j] = false; 
	 * 
	 * Time Complexity: O(mxn)
	 * Space Complexity: O(mxn)
	 */
	public static boolean regexMatch(String str, String pattern){
		boolean[][] T = new boolean[str.length()+1][pattern.length()+1];
		T[0][0] = true;
		for(int i=1; i<T.length; i++){
			T[i][0] = false;
		}
		for(int i=1; i<T[0].length; i++){
			T[0][i] = false;
		}
		for(int i = 1; i<T.length; i++){
			for(int j= 1; j<T[i].length; j++){
				if(str.charAt(i-1) == pattern.charAt(j-1)){
					T[i][j] = T[i-1][j-1];
				}
				else if(pattern.charAt(j-1) == '*'){
					T[i][j] = T[i][j-2];
					if(str.charAt(i-1) == pattern.charAt(j-2) || pattern.charAt(j-2) == '.'){
						T[i][j] = T[i][j] | T[i-1][j];
					}
				}
				else{
					T[i][j] = false;
				}
			}
		}
		return T[str.length()][pattern.length()];
	}
	
	

}
