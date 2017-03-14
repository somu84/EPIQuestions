package com.epi.BST;

public class Q4_LCA {
	static class Tree{
		Tree left;
		Tree right;
		int data;
	}
	
	public static Tree findLCA(Tree root, Tree n1, Tree n2){
		if(root.data > Math.min(n1.data, n2.data) && root.data < Math.max(n1.data, n2.data))
			return root;
		else if(root.data > Math.max(n1.data, n2.data)){
			return findLCA(root.left, n1, n2);
		}
		else if(root.data < Math.min(n1.data, n2.data)){
			return findLCA(root.right, n1, n2);
		}
		return root;
	}
	
	//Non-recursive : n1 < n2
	public static Tree findLCA1(Tree root, Tree n1, Tree n2){
		Tree p = root;
		while(p.data < n1.data || p.data > n2.data){
			while(p.data < n1.data){
				p = p.right;
			}
			while(p.data > n2.data){
				p = p.left;
			}
		}
		return p;
	}
}
