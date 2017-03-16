package com.epi.BinaryTrees;

public class Q2_CheckSymmetry {
	static class Tree{
		Tree left;
		Tree right;
		int data;
	}
	
	public static boolean symmCheck(Tree root){
		return symmHelper(root.left, root.right);
	}
	
	public static boolean symmHelper(Tree left, Tree right){
		if(left == null && right == null)
			return true;
		if(left.data == right.data){
			return symmHelper(left.left,right.right) && symmHelper(left.right, right.left);
		}
		return false;
	}

}
