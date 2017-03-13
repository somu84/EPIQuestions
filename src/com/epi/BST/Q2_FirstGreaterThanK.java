package com.epi.BST;

public class Q2_FirstGreaterThanK {
	static class BST{
		BST left;
		BST right;
		int data;
	}
	
	public static BST getFirstGreat(BST root, int k){
		BST curr = root, first = null;
		while(curr!= null){
			if(curr.data > k){
				first = curr;
				curr = curr.left;
			}
			else{
				curr = curr.right;
			}
		}
		return first;
	}

}
