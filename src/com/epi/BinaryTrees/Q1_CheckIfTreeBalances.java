package com.epi.BinaryTrees;
class TreeBalance{
	boolean isBalanced;
	int height;
	
	TreeBalance(boolean bal, int ht){
		this.isBalanced = bal;
		this.height = ht;
	}
}
public class Q1_CheckIfTreeBalances {
	static class BinaryTreeNode<T>{
		BinaryTreeNode<T> left;
		BinaryTreeNode<T> right;
		T data;
	}
	
	public static boolean isBalanced(BinaryTreeNode<Integer> root){
		return checkBal(root).isBalanced;
	}
	
	public static TreeBalance checkBal(BinaryTreeNode<Integer> root){
		if(root == null)
			return new TreeBalance(true, -1);
		
		TreeBalance lSub = checkBal(root.left);
		if(!lSub.isBalanced){
			return lSub;
		}
		TreeBalance rSub = checkBal(root.right);
		if(!rSub.isBalanced){
			return rSub;
		}
		int ht = Math.max(lSub.height, rSub.height)+1;
		boolean isBal = false;
		if(Math.abs(lSub.height -  rSub.height) <= 1){
			isBal = true;
		}
		return new TreeBalance(isBal, ht);
	}
}
