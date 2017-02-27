package com.epi.Greedy;

import java.util.ArrayList;
import java.util.List;

class Res{
	int st;
	int ed;
	Res(int i, int j){
		this.st = i;
		this.ed = j;
	}
}
public class q6_WaterTrap {
	public static Res maxWater(List<Integer> arr){
		int i = 0;
		int j = arr.size()-1;
		int maxWater = Math.min(arr.get(i), arr.get(j))*arr.size();
		Res result = new Res(i,j);
		while(i<j){
			int currWater = Math.min(arr.get(i), arr.get(j))*(j-i);
			if(arr.get(i) < arr.get(j)){
				if(currWater>maxWater){
					maxWater = currWater;
					result.st = i;
					result.ed = j;
				}
				i++;
			}
			else if(arr.get(i) == arr.get(j)){
				if(currWater>maxWater){
					maxWater = currWater;
					result.st = i;
					result.ed = j;
				}
				i++;
				j--;
			}
			else{
				if(currWater>maxWater){
					maxWater = currWater;
					result.st = i;
					result.ed = j;
				}
				j--;
			}
		}
		return result;
	}
	
	public static void main(String[] args){
		List<Integer> arr = new ArrayList<>();
		arr.add(1);
		arr.add(2);
		arr.add(1);
		arr.add(3);
		arr.add(4);
		arr.add(4);
		arr.add(5);
		arr.add(6);
		arr.add(2);
		arr.add(1);
		arr.add(3);
		arr.add(1);
		arr.add(3);
		arr.add(2);
		arr.add(1);
		arr.add(2);
		arr.add(4);
		arr.add(1);
		
		Res res = maxWater(arr);
		System.out.println("Start pos "+res.st+" End pos "+res.ed);
	}

} 
