package com.epi.StacksNQs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q7_PrintDepthTree {
	static class Tree{
		Tree left;
		Tree right;
		int data;
		
		Tree(int data){
			this.data = data;
		}
	}
	
	public static List<List<Integer>> getDepthTree(Tree root){
		Queue<Tree> currDepthNode = new LinkedList<>();
		currDepthNode.add(root);
		List<List<Integer>> result = new ArrayList<>();
		while(!currDepthNode.isEmpty()){
			Queue<Tree> nextDepthNode = new LinkedList<>();
			List<Integer> currLevel= new ArrayList<>();
			while(!currDepthNode.isEmpty()){
				Tree curr = currDepthNode.poll();
				if(curr != null){
					currLevel.add(curr.data);
					nextDepthNode.add(curr.left);
					nextDepthNode.add(curr.right);
				}
			}
			if(!currLevel.isEmpty())
				result.add(currLevel);
			currDepthNode = nextDepthNode;
		}
		return result;
	}

	public static List<Integer> levelOrder(Tree root){
		Queue<Tree> q = new LinkedList<>();
		q.offer(root);
		List<Integer> res = new ArrayList<>();
		while(!q.isEmpty()){
			Tree curr = q.poll();
			if(curr == null){
				continue;
			}
			res.add(curr.data);
			if(curr.left != null) q.offer(curr.left);
			if(curr.right != null) q.offer(curr.right);
		}
		return res;
	}
	
	public static void main(String[] args){
		Tree root = new Tree(5);
		root.left = new Tree(4);
		root.right = new Tree(3);
		root.left.left = new Tree(2);
		root.left.right = new Tree(1);
		root.right.left = new Tree(7);
		root.right.right = new Tree(8);
		
		List<Integer> res = levelOrder(root);
		System.out.println(res);
	}
}
