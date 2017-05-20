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
		return b.substring(maxJ-max, maxJ);
	}
	
	public static void main(String[] args){
		String res = longestCommonSubString("abcdaf", "aaaaaaadaffdfdsfsdf");
		System.out.println(res);
		System.out.println(getCommon("abcdaf", "aaaaaaadaffdfdsfsdf"));
	}
	
	static int getCommon(String a, String b){
		if(a == null || b == null || a.length() == 0
				||b.length()==0)
			return 0;
		int[][]dp = new int[a.length()][b.length()];
		for(int i = 0; i<dp.length; i++){
			for(int j = 0; j<dp[i].length; j++){
				dp[i][j] = Integer.MIN_VALUE;
			}
		}
		return getComm(a, b, 0, 0, dp, false);
	}
	
	static int getComm(String a, String b, int p1, int p2, int[][]dp, boolean isEqual){
		if(p1 == a.length() || p2 == b.length()) return 0;
		if(dp[p1][p2] == Integer.MIN_VALUE){
			if(isEqual){
				if(a.charAt(p1) == b.charAt(p2))
					dp[p1][p2] =  1 + getComm(a, b, p1+1, p2+1, dp, isEqual);
				dp[p1][p2] = 0;
			}else{
				int r1 = 0;
				if(a.charAt(p1) == b.charAt(p2))
					r1 = 1 + getComm(a, b, p1+1, p2+1, dp, true);
					
				dp[p1][p2] = Math.max(r1, Math.max(getComm(a, b, p1+1, p2, dp, false), getComm(a, b, p1, p2+1, dp, false)));
			}
		}
		return dp[p1][p2];
	}
	
}
