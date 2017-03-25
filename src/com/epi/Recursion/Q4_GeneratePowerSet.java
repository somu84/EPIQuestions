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
			powerSet.add(selectedSoFar);
			return;
		}
		//Consider the to be selected
		selectedSoFar.add(input.get(toBeSelected));
		getPowerSet(input, toBeSelected+1, selectedSoFar, powerSet);
		//Remove the to be considered
		selectedSoFar.remove(selectedSoFar.size()-1);
		getPowerSet(input, toBeSelected+1, selectedSoFar, powerSet);
	}

}
