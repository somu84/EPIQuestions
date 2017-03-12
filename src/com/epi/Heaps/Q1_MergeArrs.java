package com.epi.Heaps;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

class ArrayEntry{
	Integer value;
	Integer arrId;
	
	ArrayEntry(int v, int id){
		this.value = v;
		this.arrId = id;
	}
}
public class Q1_MergeArrs {

	public static List<Integer> mergeArrs(List<List<Integer>> sortedArrs){
		List<Iterator<Integer>> it = new ArrayList<>(sortedArrs.size());
		for(List<Integer> arr: sortedArrs){
			it.add(arr.iterator());
		}
		PriorityQueue<ArrayEntry> minHeap = new PriorityQueue<>(sortedArrs.size(), new Comparator<ArrayEntry>() {
			@Override
			public int compare(ArrayEntry o1, ArrayEntry o2){
				return Integer.compare(o1.value,o2.value);
			}
		});
		
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
}
