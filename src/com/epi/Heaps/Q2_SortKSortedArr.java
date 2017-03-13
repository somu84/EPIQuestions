package com.epi.Heaps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

class ArrayElement{
	Integer value;
	Integer arrId;
	
	ArrayElement(int v, int id){
		this.value = v;
		this.arrId = id;
	}
}

public class Q2_SortKSortedArr {
	
	private enum SubArrType {INCREASING, DECREASING};
	
	public static List<Integer>sortK(List<Integer> arr){
		List<List<Integer>> sortedSub = new ArrayList<>();
		SubArrType subType = SubArrType.INCREASING;
		int startIdx = 0;
		for(int i=1; i<=arr.size(); i++){
			if(i==arr.size() ||(arr.get(i)>arr.get(i-1)&& subType == SubArrType.DECREASING)
					||(arr.get(i)<=arr.get(i+1) && subType == SubArrType.INCREASING)){
				List<Integer> subList = arr.subList(startIdx, i);
				if(subType == SubArrType.DECREASING){
					Collections.reverse(subList);
				}
				sortedSub.add(subList);
				startIdx = i;
				subType = (subType == SubArrType.DECREASING ? SubArrType.INCREASING:SubArrType.DECREASING);
			}		
		}
		return merge(sortedSub);
	}
	
	public static List<Integer> merge(List<List<Integer>> sortedSub){
		List<Iterator<Integer>>it = new ArrayList<>();
		for(List<Integer>arr:sortedSub){
			it.add(arr.iterator());
		}
		PriorityQueue<ArrayElement> minHeap = new PriorityQueue<>(sortedSub.size(), new Comparator<ArrayElement>(){
			@Override
			public int compare(ArrayElement o1, ArrayElement o2){
				return Integer.compare(o1.value, o2.value);
			}
		});
		for(int i=0; i<it.size(); i++){
			minHeap.add(new ArrayElement(it.get(i).next(), i));
		}
		List<Integer> result = new ArrayList<>();
		while(!minHeap.isEmpty()){
			ArrayElement head = minHeap.poll();
			result.add(head.value);
			if(it.get(head.value).hasNext()){
				minHeap.add(new ArrayElement(it.get(head.value).next(), head.value));
			}
		}
		return result;
	}
}
