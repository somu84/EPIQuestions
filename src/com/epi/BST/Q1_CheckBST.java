package com.epi.BST;

public class Q1_CheckBST {
	static class BST{
		BST right;
		BST left;
		int data;
	}
	public static boolean isBST(BST root){
		int min = Integer.MIN_VALUE;
		int max = Integer.MAX_VALUE;
		return checkBST(root, min, max);
	}
	
	public static boolean checkBST(BST root, int min, int max){
		if(root == null)
			return true;
		
		int curr = root.data;
		if(curr > min && curr <= max){
			if(checkBST(root.left, min, curr) && checkBST(root.right, curr, max)){
				return true;
			}
		}
		return false;
	}

}
