package com.epi.Searching;

public class Q8_GetKthLargestElement {
	public static int getKLargest(int[] arr, int k){
		return getKLargest(arr, 0, arr.length-1, k);
	}
	private static int getKLargest(int[] arr, int left, int right, int k){
		if(left >= right) return left;
		int pivot = arr[(left+right)/2];
		int pos = partition(arr, left, right, pivot);
		if(pos == k-1){
			return arr[pos];
		}
		else if(pos > k-1){
			return getKLargest(arr, left, pos, k);
		}
		return getKLargest(arr, pos, right, k-pos);
	}
	
	private static int partition(int[] arr, int l, int r, int pivot){
		while(l <= r){
			while(arr[l] < arr[pivot])
				l++;
			while(arr[r] > arr[pivot])
				r--;
			if(l<= r){
				swap(arr, l, r);
				l++;
				r--;
			}
		}
		return l;
	}
	
	private static void swap(int[] arr, int l, int r){
		int t = arr[l];
		arr[l] = arr[r];
		arr[r] = t;
	}
	
	public static void main(String[] args){
		int[] arr = {3,2,1,5,4};
		System.out.println(getKLargest(arr, 2));
	}
}
