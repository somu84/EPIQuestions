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

}
