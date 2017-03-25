package com.epi.PrimitiveDataTypes;

public class Q3_ReverseBitOrder {
	
	public static long swap(long n, int i, int j){
		if(((n>>i) & 1) == ((n>>j)&1)){
			return n;
		}
		long mask = (1L<<i)|(1L<<j);
		return n^mask;
	}
	
	public static long reverse(long n){
		int i=0, j=63;
		long res = n;
		for(i=0,j=63;i<j;i++,j--){
			res = swap(res,i,j);
		}
		return res;
	}
	

}
