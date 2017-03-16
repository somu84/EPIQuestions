package com.epi.BinaryTrees;

public class Q4_BinaryTree {
	static class Tree{
		Tree parent;
		Tree left;
		Tree right;
		int data;
	}

	public static Tree getLCA(Tree n1, Tree n2){
		int d1 = getDepth(n1);
		int d2 = getDepth(n2);
		if(d1 < d2){
			Tree temp = n1;
			n1 = n2;
			n2 = temp;
		}
		traverse(n1, Math.abs(d1-d2));
		while(n1 != n2){
			n1 = n1.parent;
			n2 = n2.parent;
		}
		return n1;
	}
	
	public static int getDepth(Tree node){
		int depth = 0;
		while(node != null){
			depth++;
			node = node.parent;
		}
		return depth;
	}
	
	public static void traverse(Tree node, int diff){
		while(diff-- > 0){
			node = node.parent;
		}
	}
}
