package com.epi.StacksNQs;

import java.util.Arrays;
import java.util.Collections;

public class Q8_CircularQueue {
	static class Queue{
		int head=0, tail = 0, SCALE_FACTOR = 2;
		int numEntries = 0;
		int[] entries;
		
		Queue(int cap){
			this.entries = new int[cap]; 
		}
		
		public void enqueue(int a){
			if(numEntries == entries.length){
				Collections.rotate(Arrays.asList(entries), -head);
				head = 0;
				tail = numEntries;
				entries = Arrays.copyOf(entries, numEntries * SCALE_FACTOR);
			}
			entries[tail] = a;
			tail = tail+1 % entries.length;
			numEntries++;
		}
		
		public int dequeue(){
			if(numEntries != 0){
				numEntries--;
				int ret = entries[head];
				head = head+1%entries.length;
				return ret;
			}
			else{
				throw new IllegalStateException("Queue is already empyt");
			}
		}
		
	}

}
