package com.epi.BinaryTrees;

import java.util.*;

public class Extr_TreeToListandBack {
	//Given a Binary Tree generate a List and then write a fucntion to get the tree back from the list.
	
	static class Tree{
		int data;
		Tree left, right;
		
		Tree(int d){
			data = d;
		}
		Tree (int d, Tree l, Tree r){
			this.data = d;
			this.left = l;
			this.right = r;
		}
	}
	
	public static List<Integer> getList(Tree root){
		List<Integer> res = new ArrayList<>();
		if(root == null) return res;
		preOrder(root, res);
		return res;
	}
	
	public static void preOrder(Tree root, List<Integer> res){
		if(root == null){
			res.add(null);
			return;
		}
		res.add(root.data);
		//if(root.left == null && root.right == null) return;
		preOrder(root.left, res);
		preOrder(root.right, res);
	}
	
	public static Tree getTree(List<Integer> res){
		Tree t = getTreeHelp(res);
		return t;
	}
	
	
	private static Tree getTreeHelp(List<Integer> res){
		if(res.size() == 0) return null;
		Integer key = res.remove(0);
		if(key == null) return null;
		Tree root = new Tree(key);
		root.left = getTreeHelp(res);
		root.right = getTreeHelp(res);
		return root;
	}
	
	public static void main(String[] args){
		Tree root = new Tree(5);
		root.left = new Tree(3);
		root.right = new Tree(2);
		root.left.left = new Tree(1);
		root.left.right = new Tree(0);
		root.right.left = new Tree(6);
		root.right.right = new Tree(1);
		List<Integer> res = getList(root);
		
		for(Integer i : res){
			if(i == null){
				System.out.print("null ");
			}else{
				System.out.print(i+" ");
			}
		}
		Tree t = getTree(res);
		System.out.println();
		System.out.println(isSame(t, root));
		
	}

	public static boolean isSame(Tree t1, Tree t2){
		if(t1 == null && t2 == null) return true;
		if(t1.data == t2.data){
			return isSame(t1.left, t2.left) && isSame(t1.right, t2.right);
		}
		return false;
	}
}
