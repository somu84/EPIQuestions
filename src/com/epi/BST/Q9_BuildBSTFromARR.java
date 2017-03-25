package com.epi.BST;

public class Q9_BuildBSTFromARR {
	static class BST{
		BST left;
		BST right;
		int data;
		
		BST(BST left, BST right, int d){
			this.left = left;
			this.right = right;
			this.data = d;
		}
	}
	
	public static BST buildBST(int[] arr){
		return buildBSTHelper(arr, 0, arr.length-1);
	}
	
	private static BST buildBSTHelper(int[] arr, int i, int j){
		if(i>=j){
			return null;
		}
		int mid = i+(j-i)/2;
		return new BST(buildBSTHelper(arr, i, mid-1), buildBSTHelper(arr,mid, j), arr[mid]);
	}
	
	

}
