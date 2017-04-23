package com.epi.Strings;

public class Q6_ReverseWords {
	public static String reverse(String str){
		char[] arr = str.toCharArray();
		reverse(arr, 0, arr.length-1);
		int i = 0, j = 0;
		while(j < arr.length){
			if(arr[j] == ' '){
				reverse(arr, i, j-1);
				i = j+1;
				j++;
			}else{
				j++;
			}
		}
		reverse(arr, i, j-1);
		return String.valueOf(arr);
	}
	
	private static void reverse(char[] arr, int i, int j){
		int l = i;
		int r = j;
		while(l < r){
			char t = arr[l];
			arr[l] = arr[r];
			arr[r] = t;
			l++;
			r--;
		}
	}
	
	public static void main(String[] args){
		System.out.println(reverse("sky is blue"));
	}

}
