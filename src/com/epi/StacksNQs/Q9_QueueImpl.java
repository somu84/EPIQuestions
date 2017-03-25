package com.epi.StacksNQs;

import java.util.*;

public class Q9_QueueImpl {
	static class QueueImpl{
		Deque<Integer> st1 = new LinkedList<>();
		Deque<Integer> st2 = new LinkedList<>();
		
		public void enqueue(int n){
			st2.push(n);
		}
		
		public int dequeue(){
			if(!st1.isEmpty()){
				return st1.pop();
			}
			else{
				if(st2.isEmpty()){
					throw new NoSuchElementException("Queue is empty!!!");
				}
				else{
					while(!st2.isEmpty()){
						st1.push(st2.pop());
					}
					return st1.pop();
				}
			}
		}
	}

}
