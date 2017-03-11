package com.epi.Strings;

public class Q1_IToAandAToI {
	
	public static int strToInt(String num){
		int l = 0;
		int len = num.length()-1;
		for(int i=num.length()-1; i>0;i--){
			int temp = num.charAt(i) - '0';
			l = l+temp*(int)Math.pow(10, len-i);
		}
		if(num.charAt(0) == '-'){
			l *= -1;
		}
		else{
			int temp = num.charAt(0) - '0';
			l = l +temp*(int)Math.pow(10, len);
		}
		return l;
	}
	
	public static String intToStr(int num){
		StringBuilder temp = new StringBuilder();
		boolean isNegative = false;
		if(num < 0)
			isNegative = true;
		num = Math.abs(num);
		while(num > 0){
			temp.append((char)('0'+num%10));
			num = num / 10;
		}
		if(isNegative)
			temp.append("-");
		return temp.reverse().toString();
	}
	public static void main(String [] args){
		System.out.println(strToInt("-123"));
		System.out.println(intToStr(9263));
	}

}
