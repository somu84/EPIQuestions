package com.epi.DynamicProg;

public class Extr_StringInterleaving {
	public static int isInterleave(String a, String b, String c) {
	    return check(a, 0, b, 0, c, 0);
	}
	
	public static int check(String s1, int i1, String s2, int i2, String s3, int i3){
	    if(i3 == s3.length() && i1 == s1.length() && i2 == s2.length())
	        return 1;
	    else if(i3 < s3.length() && i1 == s1.length() && i2 == s2.length())
			return 0;
	   if(i1 < s1.length() && i2 < s2.length()){
		   if(s1.charAt(i1) == s3.charAt(i3) && s2.charAt(i2) == s3.charAt(i3)){
			   return check(s1, i1+1, s2, i2, s3, i3+1) | check(s1, i1, s2, i2+1, s3, i3+1);
		   }else if(s1.charAt(i1) == s3.charAt(i3)){
			   return check(s1, i1+1, s2, i2, s3, i3+1);
		   }else if(s2.charAt(i2) == s3.charAt(i3)){
			   return check(s1, i1, s2, i2+1, s3, i3+1);
		   }else
			   return 0;
	   }else if(i1 < s1.length()){
		   if(s1.charAt(i1) == s3.charAt(i3)){
			   return check(s1, i1+1, s2, i2, s3, i3+1);
		   }
	   }
	   else if(i2 < s2.length()){
		   if(s2.charAt(i2) == s3.charAt(i3)){
			   return check(s1, i1, s2, i2+1, s3, i3+1);
		   }
	   }
	   return 0;
	}
	
	public static void main(String[] args){
		System.out.println(isInterleave("B", "e", "Be"));
	}

}
