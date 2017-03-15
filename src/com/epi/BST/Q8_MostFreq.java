package com.epi.BST;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;


public class Q8_MostFreq {
	
	static class Pair{
		String word;
		int count;
		
		Pair(String w, int c){
			this.word = w;
			this.count = c;
		}
	}
	
	public List<String> topKFreq(List<String> words, int k){
		Map<String, Integer> wC = new HashMap<>();
		for(String word: words){
			if(wC.containsKey(word)){
				wC.put(word, wC.get(word)+1);
			}
			else{
				wC.put(word, 1);
			}
		}
		
		PriorityQueue<Pair> p = new PriorityQueue<>(k, new Comparator<Pair>(){
			public int compare(Pair p1, Pair p2){
				return Integer.compare(p1.count, p2.count);
			}
		});
		
		for(Map.Entry<String, Integer> e: wC.entrySet()){
			p.add(new Pair(e.getKey(), e.getValue()));
			if(p.size() > k){
				p.poll();
			}
		}
		
		List<String> res = new ArrayList<>();
		while(!p.isEmpty()){
			res.add(p.poll().word);
		}
		
		return res;
	}
}
