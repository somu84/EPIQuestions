package com.epi.Recursion;

import java.util.*;

public class Q8_GenerateAllBinaryTree {
	static class Tree{
		int data;
		Tree left, right;
		
		Tree(int d, Tree l, Tree r){
			this.data = d;
			this.left = l;
			this.right = r;
		}
		
		Tree(){ data = 0;}
	}
	
	public static List<Tree> getTree(int num){
		List<Tree> res = new ArrayList<>();
		if(num <= 0) return res;
		
		for(int nL = 0; nL < num; nL++){
			int nR = num - 1 - nL;
			List<Tree> l = getTree(nL);
			List<Tree> r = getTree(nR);
			for(Tree left : l){
				for(Tree right: r){
					res.add(new Tree(0, left, right));
				}
			}
		}
		return res;
	}
}
