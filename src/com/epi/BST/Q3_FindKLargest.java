package com.epi.BST;

import java.util.ArrayList;
import java.util.List;

public class Q3_FindKLargest {
	static class Tree<T> {
		Tree right;
		Tree left;
		T data;
		
		Tree(){
			this.right = null;
			this.left = null;
			this.data = null;
		}
	}
	
	public static List<Integer> findKL(Tree<Integer> tree, int k){
		List<Integer> res = new ArrayList<Integer>();
		findR(tree, k, res);
		return res;
	}
	
	public static void findR(Tree<Integer> tree, int k, List<Integer> res){
		if(res.size() < k && tree != null){
			findR(tree.right, k, res);
			if(res.size() < k){
				res.add(tree.data);
				findR(tree.left,k, res);
			}
		}
	}

}
