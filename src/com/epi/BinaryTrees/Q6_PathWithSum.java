package com.epi.BinaryTrees;

import java.util.*;

public class Q6_PathWithSum {
	static class Tree{
		int data;
		Tree left, right;
		
		Tree(int d){
			data = d;
		}
	}
	
	/**
	 * T: O(n) where n is number of nodes
	 * S: O(h) where h is the height
	 * @param root
	 * @param k
	 * @return
	 */
	public static boolean hasSum(Tree root, int k){
		if(root == null) return false;
		return getSum(root.left, k, root.data) || getSum(root.right, k, root.data);
 	}
	
	public static boolean getSum(Tree root, int k, int sum){
		if(root == null){
			if(k == sum) return true;
			return false;
		}
		return getSum(root.left, k, sum+root.data) || getSum(root.right, k, sum+root.data);
	}
	
	public static void main(String[] args){
		Tree root = new Tree(2);
		root.left = new Tree(3);
		root.right = new Tree(1);
		root.left.left = new Tree(0);
		root.left.right = new Tree(2);
		root.right.left = new Tree(2);
		root.right.right = new Tree(5);
		root.right.right.left = new Tree(6);
		root.right.right.right = new Tree(7);
		
		//System.out.println(hasSum(root, 13));
		List<List<Integer>> res = getPath(root, 5);
		System.out.println(res);
	}
	/**
	 * Variant to return all the paths having the sum from root to leaf
	 * T:O(n)
	 * S:O(h)
	 * @param root
	 * @param k
	 * @return
	 */
	static List<List<Integer>> getPath(Tree root, int k){
		List<List<Integer>> res = new ArrayList<>();
		if(root == null) return res;
		getPath(root, new ArrayList<Integer>(), 0, k, res);
		return res;
	}
	
	static void getPath(Tree root, List<Integer> temp, int sum, int k, List<List<Integer>> res){
		if(root == null) return;
		sum += root.data;
		temp.add(root.data);
		if(root.left == null && root.right == null){
			if(sum == k){
				res.add(new ArrayList<Integer>(temp));
			}
			temp.remove(temp.size()-1);
			return;
		}
		else{
			getPath(root.left, temp, sum, k, res);
			getPath(root.right, temp, sum, k, res);
		}
		temp.remove(temp.size()-1);
	}
}
