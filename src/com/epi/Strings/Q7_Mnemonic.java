package com.epi.Strings;

import java.util.*;

public class Q7_Mnemonic {
	public static List<String> phoneMnemonic(String num){
		char[] partial= new char[num.length()];
		List<String> res = new ArrayList<>();
		getMnemonic(num, 0, partial, res);
		return res;
	}
	
	private static final String[] MAPPING =
	{"0", "1", "ABC", "DEF"};
	private static void getMnemonic(String num, int digit, char[] partial, List<String> res){
		//Base case
		if(digit == num.length()){
			res.add(new String(partial));
		}
		else{
			//Try all chars
			for(int i=0; i<MAPPING[num.charAt(digit)-'0'].length();++i){
				char c = MAPPING[num.charAt(digit)-'0'].charAt(i);
				partial[digit] = c;
				getMnemonic(num, digit+1, partial, res);
			}
		}
	}

}
