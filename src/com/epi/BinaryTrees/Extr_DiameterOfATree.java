package com.epi.BinaryTrees;

public class Extr_DiameterOfATree {
	static class Tree{
		Tree left;
		Tree right;
		int data;
	}
	
	public static int getDiameter(Tree root){
		if(root == null) return 0;
		
		int lH = getHeight(root.left);
		int rH = getHeight(root.right);
		
		int lD = getDiameter(root.left);
		int rD = getDiameter(root.right);
		
		return Math.max(lH+rH+1, Math.max(lD, rD));
	}
	
	public static int getHeight(Tree root){
		if(root == null) return 0;
		return Math.max(getHeight(root.left), getHeight(root.right))+1;
	}

}
