package com.epi.HashTables;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Q10_KMostFrequent {
	static class WCount implements Comparable<WCount>{
		String w;
		Integer c;
		
		WCount(String w, int c){
			this.w = w;
			this.c = c;
		}
		@Override
		public int compareTo(WCount o){
			return this.c.compareTo(o.c);
		}
	}
	
	public static List<String> getKMostFreq(String[] arr, int k){
		Map<String, Integer> wC = new HashMap<String, Integer>();
		for(String str: arr){
			if(wC.containsKey(str)){
				wC.put(str, wC.get(str)+1);
			}
			else{
				wC.put(str,1);
			}
		}
		PriorityQueue<WCount> heap = new PriorityQueue<>(k);
		for(Map.Entry<String, Integer> e: wC.entrySet()){
			heap.add(new WCount(e.getKey(), e.getValue()));
		}
		
		List<String> res = new ArrayList<>();
		for(int i=0; i<k; i++){
			res.add(heap.remove().w);
		}
		return res;
	}

}
