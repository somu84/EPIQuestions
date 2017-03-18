package com.epi.DynamicProg;

public class Extr_LongestCommonSubsequence {
	public static String longestCommonSubSeq(String a, String b){
		int[][]  temp = new int[a.length()+1][b.length()+1];
		
		for(int i=1; i<temp.length;i++){
			for(int j=1; j<temp[i].length; j++){
				if(a.charAt(i-1) == b.charAt(j-1)){
					temp[i][j] = 1+temp[i-1][j-1];
				}
				else{
					temp[i][j] = Math.max(temp[i-1][j], temp[i][j-1]);
				}
			}
		}
		System.out.println("Max Length of Sub Sequence: "+temp[a.length()][b.length()]);
		
		//Return the subSequence
		StringBuilder tempStr = new StringBuilder();
		int i=a.length();
		int j = b.length();
		while(temp[i][j] != 0){
			if(a.charAt(i-1) == b.charAt(j-1)){
				tempStr.append(a.charAt(i-1));
				i--;
				j--;
			}
			else{
				if(temp[i-1][j] >temp[i][j-1]){
					i = i-1;
				}
				else{
					j = j-1;
				}
			}
		}
		return tempStr.toString();
	}
	
	public static void main(String[] args){
		String res = longestCommonSubSeq("abcdaf", "acbcf");
		System.out.println(res);
	}

}
