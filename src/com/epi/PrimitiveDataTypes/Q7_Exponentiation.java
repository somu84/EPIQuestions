package com.epi.PrimitiveDataTypes;

public class Q7_Exponentiation {
	
	/**
	 * Shitty approach
	 * @param x
	 * @param y
	 * @return
	 */
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
		System.out.println(fastExpo(i, 2));
		
	}
	
	/**
	 * https://www.youtube.com/watch?v=-3Lt-EwR_Hw&t=289s
	 * Time Complexity O(log n)
	 * @param a
	 * @param k
	 * @return
	 */
	public static int fastExpo(int a, int k){
		if(k == 0) return 1;
		if(k == 1) return a;
		int r = 0;
		if(k%2 == 0){
			r = fastExpo(a, k/2);
			return r*r;
		}
		else{
			r = fastExpo(a, k/2);
			return r*r*a;
		}
	}
}
