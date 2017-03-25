package com.epi.BinaryTrees;
import java.util.*;
public class Q12_IterativeInOrder {
	static class Tree{
		Tree left;
		Tree right;
		int data;
	}
	
	public static void inorder(Tree root){
		Deque <Tree> stack = new LinkedList<>();
		while(true){
			if(root != null){
				stack.offer(root);
				root = root.left;
			}
			else{
				if(stack.isEmpty()) break;
				root = stack.pop();
				System.out.println(root.data);
				root = root.right;
			}
			
		}
	}

}
