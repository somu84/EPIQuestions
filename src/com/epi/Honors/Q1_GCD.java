package com.epi.Honors;

public class Q1_GCD {
	public static long GCD(long x, long y){
		if(x == y){
			return x;
		}
		else if((x & 1) == 0 && (y & 1) == 0){
			return GCD(x >> 1, y>>1)<<1;
		}
		else if((x & 1) == 0 && (y&1) != 0){
			return GCD(x>>1, y);
		}
		else if((x & 1)!= 0 && (y & 1) == 0){
			return GCD(x, y>>1);
		}
		else if(x > y){
			return GCD(x-y, y);
		}
		else{
			return GCD(x, y-x);
		}
	}

	//Basic GCD TimeComplexity: O(log min(x, y))
	public static int GCD(int x, int y){
		if(x == 0)
			return y;
		return GCD(y%x, x);
	}
	
	//Without Recursion
	public static int GCD_2(int x, int y){
		if(x == 0){
			return y;
		}
		while(x > 0 && y > 0){
			int t = x;
			x = y%x;
			y = t;
			
		}
		return y;
	}
	public static void main(String[] args){
		System.out.println(GCD(16, 24));
		System.out.println(GCD_2(16, 24));
	}
}
