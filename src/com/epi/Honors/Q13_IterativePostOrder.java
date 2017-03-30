package com.epi.Honors;

import java.util.*;

public class Q13_IterativePostOrder {
	static class Tree{
		Tree left;
		Tree right;
		int data;
	}
	
	/**
	 * Iterative Post-Order using two stacks
	 * @param root
	 */
	public static void postOrder(Tree root){
		if(root == null) return;
		
		Deque<Tree> s1 = new LinkedList<>();
		Deque<Tree> s2 = new LinkedList<>();
		s1.push(root);
		while(!s1.isEmpty()){
			s2.push(s1.pop());
			if(s2.peek().left != null){
				s1.push(s2.peek().left);
			}
			if(s2.peek().right != null){
				s1.push(s2.peek().right);
			}
		}
		while(!s2.isEmpty()){
			System.out.print(s2.pop()+" ");
		}
	}
	
	
	/**
	 * Post Order traversal using one stack
	 * https://www.youtube.com/watch?v=xLQKdq0Ffjg&t=1s
	 * @param root
	 */
	public static void postOrderSpaceOptimized(Tree root){
		if(root == null) return;
		Tree curr = root;
		Deque<Tree> st = new LinkedList<>();
		while(curr != null || !st.isEmpty()){
			if(curr != null){
				st.push(curr);
				curr = curr.left;
			}else{
				Tree temp = st.peek().right;
				if(temp == null){
					temp = st.pop();
					System.out.print(temp.data);
					while(!st.isEmpty() && temp == st.peek().right){
						temp = st.pop();
						System.out.print(temp.data);
					}
				}
				else{
					curr = temp;
				}
			}
		}
		
	}

}
