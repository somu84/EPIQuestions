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
		System.out.println(getBrace(3));
	}

}
