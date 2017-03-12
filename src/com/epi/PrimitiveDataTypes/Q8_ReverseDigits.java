package com.epi.PrimitiveDataTypes;

public class Q8_ReverseDigits {
	
	public static int rev(int x){
		int num = Math.abs(x);
		int res = 0;
		while(num != 0){
			res = res*10+num%10;
			num = num/10;
		}
		return x<0?-res:res;
	}
	
	public static void main(String [] args){
		int x = -1234;
		System.out.println(rev(x));
	}

}
