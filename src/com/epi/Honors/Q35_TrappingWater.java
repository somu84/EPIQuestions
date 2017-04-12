package com.epi.Honors;

public class Q35_TrappingWater {
	public static int calculateWaterTrap(int[] arr){
		int maxH = getMaxIndex(arr);
		int sum = 0;
		int left = arr[0];
		for(int i = 1; i<maxH; i++){
			if(arr[i] >= left){
				left = arr[i];
			}else{
				sum += left - arr[i];
			}
		}
		int right = arr[arr.length - 1];
		for(int i = arr.length - 2; i> maxH; i--){
			if(arr[i] >= right){
				right = arr[i];
			}else{
				sum += right - arr[i];
			}
		}
		return sum;
	}
	
	public static int getMaxIndex(int[] arr){
		int max = 0;
		int maxI = -1;
		for(int i = 0; i < arr.length; i++){
			if(arr[i] > max){
				max = arr[i];
				maxI = i;
			}
		}
		return maxI;
	}
}
