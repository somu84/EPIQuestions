package com.epi.Heaps;

import java.util.*;

public class Q5_RunningMedian {
	public static double[] getMedian(List<Integer>arr){
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		
		double[] median = new double[arr.size()];
		int i=0;
		for(int num: arr){
			addNumber(num, maxHeap, minHeap);
			rebalance(maxHeap, minHeap );
			median[i] = getMedian(maxHeap, minHeap);
			i++;
		}
		return median;
	}

	public static void addNumber(int num, PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers){
		if(lowers.isEmpty() || num < lowers.peek()){
			lowers.add(num);
		}
		else{
			highers.add(num);
		}
	}
	
	public static void rebalance(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers){
		PriorityQueue<Integer> biggerHeap = lowers.size() > highers.size()?lowers:highers;
		PriorityQueue<Integer> smallerHeap = lowers.size() < highers.size()?highers:lowers;
		
		if(biggerHeap == null || smallerHeap == null) return;
		else if(biggerHeap.size() - smallerHeap.size() == 1) return;
		else{
			smallerHeap.add(biggerHeap.remove());
		}
		return;
	}
	
	public static double getMedian(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers){
		PriorityQueue<Integer> biggerHeap = lowers.size() > highers.size() ? lowers:highers;
		if(biggerHeap.size() == 0){
			return (double)(lowers.peek()+highers.peek())/2;
		}
		else{
			return biggerHeap.peek();
		}
	}
}
