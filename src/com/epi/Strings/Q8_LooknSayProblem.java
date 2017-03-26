package com.epi.Strings;

public class Q8_LooknSayProblem {
	public static String looknSay(int n){
		String s = "1";
		for(int i = 1; i<n; i++){
			s = nextNumber(s);
		}
		return s;
	}
	
	private static String nextNumber(String s){
		StringBuilder sT = new StringBuilder();
		int l = s.length();
		for(int i=0; i<l;i++){
			int count = 1;
			while(i+1<s.length() && s.charAt(i) == s.charAt(i+1)){
				count++;
				i++;
			}
			sT.append(count);
			sT.append(s.charAt(i));
		}
		return sT.toString();
		
	}

}
