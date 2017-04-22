package com.epi.Recursion;

import java.util.*;

public class Q4_GeneratePowerSet {
	/**
	 * Time Complexity: O(2^n)
	 * Space Complexity: O(2^n)
	 * @param input
	 * @return
	 */
	public static List<List<Integer>> generatePowerSet(List<Integer> input){
		List<List<Integer>> powerSet = new ArrayList<>();
		getPowerSet(input, 0, new ArrayList<Integer>(), powerSet);
		return powerSet;
	}
	
	private static void getPowerSet(List<Integer>input, int toBeSelected, List<Integer> selectedSoFar, List<List<Integer>> powerSet){
		if(toBeSelected == input.size()){
			powerSet.add(new ArrayList<>(selectedSoFar));
			return;
		}
		//Consider the to be selected
		selectedSoFar.add(input.get(toBeSelected));
		getPowerSet(input, toBeSelected+1, selectedSoFar, powerSet);
		//Remove the to be considered
		selectedSoFar.remove(selectedSoFar.size()-1);
		getPowerSet(input, toBeSelected+1, selectedSoFar, powerSet);
	}

	public static void main(String[] args){
		List<Integer> arr = new ArrayList<>();
		arr.add(1);
		arr.add(2);
		arr.add(3);
		arr.add(4);
		System.out.println(generatePowerSet(arr));
		System.out.println(getSetOfSizeK(arr, 2));
	}
	
	public static List<Set<Integer>> getSetOfSizeK(List<Integer> arr, int k){
		if(arr == null || arr.size() == 0){
			return null;
		}
		List<Set<Integer>> res = new ArrayList<>();
		getSubset(arr, k, new HashSet<Integer>(), res, 0);
		return res;
	}
	
	private static void getSubset(List<Integer> arr, int k, HashSet<Integer> set, List<Set<Integer>> res, int idx){
		if(set.size() == k){
			res.add(new HashSet<>(set));
			return;
		}
		if(idx == arr.size()) return;
		set.add(arr.get(idx));
		getSubset(arr, k, set, res, idx+1);
		set.remove(arr.get(idx));
		getSubset(arr, k, set, res, idx+1);
	}
}
