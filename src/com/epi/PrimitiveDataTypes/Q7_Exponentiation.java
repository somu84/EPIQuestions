package com.epi.PrimitiveDataTypes;

public class Q7_Exponentiation {
	public static double pow(double x, int y){
		long pow = y;
		double res = 1.0;
		if(y < 0){
			pow *= -1;
			x = 1.0/x;
		}
		while(pow != 0){
			if((pow&1)!=0){
				res *= x;
			}
			x *= x;
			pow >>=1;
		}
		return res;
	}
	
	public static void main(String[] args){
		int i = 6;
		System.out.println((i&1));
	}
	
}
