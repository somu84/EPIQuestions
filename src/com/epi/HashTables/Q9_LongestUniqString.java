package com.epi.HashTables;
import java.util.*;

public class Q9_LongestUniqString {
	public static List<Character> longest(char[] arr){
		List<Character> res = new ArrayList<>();
		if(arr == null || arr.length == 0) return res;
		
		int maxC = 1, maxI = 0;
		HashMap<Character, Integer> map = new HashMap<>();
		map.put(arr[0], 0);
		int currC = 1;
		for(int i = 1; i<arr.length; i++){
			if(!map.containsKey(arr[i])){
				map.put(arr[i], i);
				currC += 1;
			}else{
				currC = i - map.get(arr[i]);
				map.put(arr[i], i);
			}
			if(currC > maxC){
				maxC = currC;
				maxI = i;
			}
		}
		int j = maxC;
		while(j > 0){
			res.add(0, arr[maxI]);
			maxI--;
			j--;
		}
		return res;
	}
	
	public static String longestStr(char[]arr){
		if(arr.length <= 1){
			return new String(arr);
		}
		HashSet<Character> set = new HashSet<>();
		int maxi = 0;
		int maxl = 0;
		int currl = 0;
		for(int i = 0; i<arr.length; i++){
			currl = 1;
			set.add(arr[i]);
			for(int j = i+1; j<arr.length; j++){
				if(!set.contains(arr[j])){
					currl +=1;
					set.add(arr[j]);
					if(currl > maxl){
						maxl = currl;
						maxi = i;
					}
				}
				else{
					break;
				}
			}
			set.clear();
		}
		String temp = new String(arr);
		return temp.substring(maxi, maxl+maxi);
	}
	
	public static void main(String[] args){
		//char[] arr = {'f','s','f','e','t','w','e','n','w','e',};
		//char[] arr = {'f','s'};
		//System.out.println(longest(arr));
		char[]arr = {};
		System.out.println(longestStr(arr));
	}

}
