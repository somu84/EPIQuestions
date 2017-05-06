package com.epi.Recursion;

import java.util.*;

public class Q6_MatchedParenthesis {
	private static void getBrace(int nL, int nR, String str, List<String> res){
		if(nL == 0 && nR == 0){
			res.add(str);
			return;
		}
		if(nL > 0){
			getBrace(nL-1, nR, str+"(", res);
		}
		if(nL < nR){
			getBrace(nL, nR-1, str+")", res);
		}
	}
	
	public static List<String> getBrace(int n){
		List<String> res = new ArrayList<>();
		if(n <= 0) return res;
		getBrace(n, n, "", res);
		return res;
	}
	
	public static void main(String[] args){
		System.out.println(getBraces(3));
	}
	
	public static List<String> getBraces(int n){
		List<String> res = new ArrayList<>();
		if( n == 0) return res;
		char[] temp  = new char[2*n];
		getBraces(n, n, 0, temp, res);
		return res;
	}
	
	public static void getBraces(int lc, int rc, int idx, char[] temp, List<String> res){
		if(rc == 0 && lc == 0){
			res.add(new String(temp));
			return;
		}
		if(lc > 0){
			temp[idx] = '(';
			getBraces(lc-1, rc, idx+1, temp, res);
		}
		if(rc > lc){
			temp[idx] = ')';
			getBraces(lc, rc-1, idx+1, temp, res);
		}
	}

}
