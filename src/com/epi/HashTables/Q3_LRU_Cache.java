package com.epi.HashTables;

import java.util.LinkedHashMap;
import java.util.Map;

public class Q3_LRU_Cache {

	static class LRU{
		LinkedHashMap<Integer, Integer> isBN;
		LRU(final int cap){
			this.isBN = new LinkedHashMap<Integer, Integer>(cap, 1.0f, true ){
				@Override
				protected boolean removeEldestEntry(Map.Entry<Integer, Integer> e){
					return this.size() > cap;
				}
			};
			
		}
		
		public int lookup(int key){
			return isBN.get(key);
		}
		
		public int insert(int key, int value){
			if(isBN.containsKey(key))
				return isBN.get(key);
			isBN.put(key, value);
			return value;
		}
		
		public int erase(Object key){
			return isBN.remove(key);
		}
	}
}