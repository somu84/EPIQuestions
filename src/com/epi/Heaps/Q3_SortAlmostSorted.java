package com.epi.Heaps;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Q3_SortAlmostSorted {
	
	public static List<Integer> sortK(List<Integer> seq, int k){
		PriorityQueue<Integer> minH = new PriorityQueue<>();
		for(int i=0; i<k; i++){
			minH.add(seq.get(i));
		}
		int i=k;
		List<Integer> res = new ArrayList<>();
		while(i<seq.size()){
			minH.add(seq.get(i));
			res.add(minH.remove());
		}
		while(!minH.isEmpty()){
			res.add(minH.remove());
		}
		return res;
	}

}
