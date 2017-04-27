package com.epi.BST;

import java.util.*;

public class Q12_RangeSearch {
	static class BST{
		int data;
		BST left, right;
	}
	
	public static List<Integer> getNodes(BST root, int p, int q){
		List<Integer> res = new ArrayList<>();
		if(root == null) return res;
		getNodes(root, p, q, res);
		return res;
	}
	
	private static void getNodes(BST root, int p, int q, List<Integer> res){
		if(root == null) return;
		
		if(root.data >= p && root.data <= q){
			res.add(root.data);
			getNodes(root.left, p, q, res);
			getNodes(root.right, p, q, res);
		}
		else if(root.data < p){
			getNodes(root.right, p, q, res);
		}else if(root.data > q){
			getNodes(root.left, p, q, res);
		}
	}

}
