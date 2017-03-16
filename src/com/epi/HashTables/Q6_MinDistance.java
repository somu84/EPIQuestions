package com.epi.HashTables;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q6_MinDistance {
	public static int getMin(List<String> words){
		Map<String, Integer> wP = new HashMap<>();
		int minD = Integer.MAX_VALUE;
		int i= 0;
		for(String word:words){
			if(!wP.containsKey(word)){
				wP.put(word, i);
			}
			else{
				int currD = wP.get(word) - i;
				wP.put(word, i);
				if(minD > currD){
					minD = currD;
				}
			}
			i++;
		}
		return minD;
	}

}
