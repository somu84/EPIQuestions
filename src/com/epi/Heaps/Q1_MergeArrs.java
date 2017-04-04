package com.epi.Heaps;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

class ArrayEntry implements Comparable<ArrayEntry>{
	Integer value;
	Integer arrId;
	
	ArrayEntry(int v, int id){
		this.value = v;
		this.arrId = id;
	}
	
	public int compareTo(ArrayEntry e){
		return Integer.compare(this.value, e.value);
	}
}
public class Q1_MergeArrs {

	public static List<Integer> mergeArrs(List<List<Integer>> sortedArrs){
		List<Iterator<Integer>> it = new ArrayList<>(sortedArrs.size());
		for(List<Integer> arr: sortedArrs){
			it.add(arr.iterator());
		}
		PriorityQueue<ArrayEntry> minHeap = new PriorityQueue<>(sortedArrs.size());
		
		for(int i=0; i< it.size(); i++){
			if(it.get(i).hasNext()){
				minHeap.add(new ArrayEntry(it.get(i).next(), i));
			}
		}
		List<Integer> result = new ArrayList<>();
		while(!minHeap.isEmpty()){
			ArrayEntry head = minHeap.poll();
			result.add(head.value);
			if(it.get(head.arrId).hasNext()){
				minHeap.add(new ArrayEntry(it.get(head.arrId).next(),head.arrId));
			}
		}
		return result;
	}
	
	
	public static void main(String[] args){
		int [] a = {6,9, 10, 12, 17};
		int [] b = {1, 4, 7, 8, 11, 18};
		List<List<Integer>> arr = new ArrayList<>();
		List<Integer> l1 = new ArrayList<>();
		for(int n: a ){
			l1.add(n);
		}
		List<Integer> l2 = new ArrayList<>();
		for(int n: b ){
			l2.add(n);
		}
		arr.add(l1);
		arr.add(l2);
		
		List<Integer> merged = mergeArrs(arr);
		System.out.println(merged);
	}
}
