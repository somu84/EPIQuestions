package com.epi.DynamicProg;

public class Extr_SubSetSum {
	public static boolean subSetSum(int[]arr, int num){
		boolean[][]temp = new boolean[arr.length][num+1];
		for(int i=0; i<temp.length; i++){
			temp[i][0] = true;
		}
		for(int i=1; i<temp[0].length; i++){
			if(i<arr[0] || i>arr[0]){
				temp[0][i] = false;
				continue;
			}
			temp[0][i] = true;
		}
		for(int i=1;i<temp.length;i++){
			for(int j=1; j<temp[i].length; j++){
				if(j<arr[i]){
					temp[i][j] = temp[i-1][j];
					continue;
				}
				if(j == arr[i]){
					temp[i][j] = true;
					continue;
				}
				else{
					if(temp[i-1][j]){
						temp[i][j] = true;
						continue;
					}
					else{
						temp[i][j] = temp[i-1][j-arr[i]];
						continue;
					}
				}
				
			}
		}
		return temp[arr.length-1][num];
	}
	
	public static void main(String[] args){
		int[] arr = {2, 3,7,8,10};
		System.out.println(subSetSum(arr, 9));
	}

}
