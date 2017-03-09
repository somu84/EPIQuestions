package com.epi.DynamicProg;

import java.util.ArrayList;
import java.util.List;

public class Extr_CoinChangeProblem {
	public static List<Integer> minChange(List<Integer> coins, int num){
		int[] c = new int[num+1];
		int[] s = new int[num+1];
		c[0] = 0;
		s[0] = -1;
		for(int i=1; i<=num; i++){
			c[i] = 10000;
			s[i] = -1;
		}
		
		for(int coin:coins){
			for(int i=1; i<=num; i++){
				if(coin>i) continue;
				if(c[i]>c[i-coin]+1 ){
					s[i] = coin;
					c[i] = c[i-coin]+1;
				}
			}
		}
		if(c[num] < 10000)
			System.out.println("Min number of coins to get "+num+" :"+ c[num]);
		
		//Build the result
		List<Integer> result = new ArrayList<>();
		int i = num;
		while(i>0){
			if(s[i] == -1) break;
			result.add(s[i]);
			i = i-s[i];
		}
		return result;
	}
	
	public static void main(String[] args){
		List<Integer> coins = new ArrayList<>();
		coins.add(7);
		coins.add(2);
		coins.add(3);
		coins.add(6);
		
		List<Integer> res = minChange(coins, 1000);
		if(res.isEmpty()){
			System.out.println("Not possible");
			return;
		}
		for(int coin: res){
			System.out.print(coin+" ");
		}
	}
}
