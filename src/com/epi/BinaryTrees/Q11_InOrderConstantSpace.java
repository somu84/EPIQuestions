package com.epi.BinaryTrees;
import java.util.*;
public class Q11_InOrderConstantSpace {
	static class Tree{
		Tree left;
		Tree right;
		Tree parent;
		int data;
	}
	
	public static List<Integer> inorder(Tree root){
		Tree prev = null, curr = root;
		List<Integer> res = new ArrayList<>();
		while(curr != null){
			Tree next;
			if(prev == curr.parent){
				if(curr.left != null){
					next = curr.left;
				}else{
					res.add(curr.data);
					next = curr.right != null?curr.right:curr.parent;
				}
			}else if(curr.left == prev){
				res.add(curr.data);
				next = curr.right != null?curr.right:curr.parent;
			}else{
				next = curr.parent;
			}
			prev = curr;
			curr = next;
		}
		return res;
	}

}
