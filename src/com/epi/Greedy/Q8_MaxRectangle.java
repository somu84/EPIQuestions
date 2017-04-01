package com.epi.Greedy;

import java.util.Deque;
import java.util.LinkedList;

public class Q8_MaxRectangle {
	public static int maxRectangle(int[] arr){
		Deque<Integer> stack = new LinkedList<>();
		int area = 0;
		int maxArea = 0;
		int i= 0;
		for(i=0; i<arr.length;){
			if(arr[i] >= arr[stack.peekFirst()] || stack.isEmpty()){
				stack.offerFirst(i++);
			}
			else{
				int top = stack.pollFirst();
				if(stack.isEmpty()){
					area = arr[top] * i;
				}
				else{
					area = arr[top] * (i - stack.peekFirst() - 1);
				}
				if(area > maxArea){
					maxArea = area;
				}
			}
		}
		while(!stack.isEmpty()){
			int j = stack.pollFirst();
			if(stack.isEmpty()){
				area = arr[j] * i;
			}
			else{
				area = arr[j]* (i - stack.peekFirst() - 1);
			}
			if(area > maxArea){
				maxArea = area;
			}
		}
		return maxArea;
	}

}
