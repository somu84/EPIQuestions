package com.epi.StacksNQs;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

class MaxCount{
	int max;
	int count;
	MaxCount(int m, int c){
		this.max = m;
		this.count = c;
	}
}
public class Q1_MaxAPI {
	Deque<Integer> stack = new LinkedList<>();
	Deque<MaxCount> maxCache = new LinkedList<>();
	
	public boolean empty(){
		return stack.isEmpty();
	}
	
	public Integer max() throws Exception{
		if(empty()) 
			throw new Exception("Stack is empty");
		return maxCache.peekFirst().max;
	}
	
	public Integer pop() throws Exception{
		if(empty()){
			throw new Exception("Stack is empty");
		}
		Integer popE = stack.removeFirst();
		if(popE.equals(maxCache.peekFirst().max)){
			maxCache.peekFirst().count -=1;
			if(maxCache.peekFirst().count == 0){
				maxCache.removeFirst();
			}
		}
		return popE;
	}
	
	public void push(Integer e){
		stack.addLast(e);
		if(maxCache.isEmpty()){
			maxCache.addFirst(new MaxCount(e, 1));
			return;
		}
		if(e.compareTo(maxCache.peekFirst().max) == 0){
			maxCache.peekFirst().count +=1;
		}
		else if(e.compareTo(maxCache.peekFirst().max) > 0){
			maxCache.addFirst(new MaxCount(e, 1));
		}
	}

}
