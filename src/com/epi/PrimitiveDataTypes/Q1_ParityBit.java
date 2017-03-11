package com.epi.PrimitiveDataTypes;

public class Q1_ParityBit {
	/**
	 * Time Complexity is O(n); where N is the size of the word
	 * @param x
	 * @return
	 */
	public static int parityBit_1(long x){
		short res = 0;
		while(x > 0){
			res ^=(x & 1);
			x >>= 1;
			
		}
		return res;
	}
	
	/**
	 * Time complexity O(k), if there are k set bits in the word
	 * @param x
	 * @return
	 */
	public static int parityBit_2(long x){
		short res = 0;
		while(x > 0){
			res ^=1;
			//Drops the right-most set bit in X
			x &=(x-1);
		}
		return res;
	}
	
	public static int parityBit_3(long x){
		x ^=x>>32;
		x^=x>>16;
		x^=x>>8;
		x^=x>>4;
		x^=x>>2;
		x^=x>>1;
		return (int)(x&1);
	}
	
	public static void main(String[] args){
		if(parityBit_2(7) == 0){
			System.out.println("Even Bits");
			return;
		}
		System.out.println("Odd Bits");
	}

}
