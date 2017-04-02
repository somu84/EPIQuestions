package com.epi.DynamicProg;

public class ExtrLongestCommonSubString {
	public static String longestCommonSubString(String a, String b){
		int[][] temp = new int[a.length()+1][b.length()+1];
		//Start from the second row and second column
		int max = 0, maxI = 0, maxJ=0;
		for(int i=1; i<temp.length; i++){
			for(int j=1; j<temp[i].length;j++){
				if(a.charAt(i-1) != b.charAt(j-1)){
					temp[i][j] = 0;
					continue;
				}
				temp[i][j] = 1 + temp[i-1][j-1];
				if(max < temp[i][j]){
					max = temp[i][j];
					maxI = i;
					maxJ = j;
				}
			}
		}
		return a.substring(maxI-max, maxI);
	}
	
	public static void main(String[] args){
		String res = longestCommonSubString("abcdaf", "aaaaaaadaffdfdsfsdf");
		System.out.println(res);
	}
}
