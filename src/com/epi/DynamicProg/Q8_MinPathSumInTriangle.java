package com.epi.DynamicProg;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q8_MinPathSumInTriangle {
	/**
	 * Time Complexity: O(n^2)
	 * Space Complexity: O(n)
	 * @param triangle
	 * @return
	 */
	public static int minPathSum(List<List<Integer>> triangle){
		if(triangle.isEmpty())
			return 0;
		
		List<Integer>prevRow = new ArrayList<>(triangle.get(0));
		//Prints the actual path
		printMinPath(prevRow,prevRow);
		for(int i=1; i< triangle.size();i++){
			List<Integer> currRow = new ArrayList<>(triangle.get(i));
			currRow.set(0, currRow.get(0)+prevRow.get(0));
			for(int j=1; j<currRow.size()-1;j++){
				currRow.set(j, currRow.get(j)+Math.min(prevRow.get(j-1), prevRow.get(j)));
			}
			currRow.set(currRow.size()-1, currRow.get(currRow.size()-1)+prevRow.get(prevRow.size()-1));
			prevRow = currRow;
			//prints the actual path
			printMinPath(prevRow, triangle.get(i));
		}
		
		return Collections.min(prevRow);
	}
	
	public static void printMinPath(List<Integer> arr, List<Integer>l){
		int i = 0, minIndex = 0;
		int min = arr.get(i);
		for(int j:arr){
			if(min>j){
				min=j;
				minIndex = i;
			}
			i++;
		}
		System.out.print(l.get(minIndex)+" ");
	}
	public static void main(String[] args){
		List<Integer> row1 = new ArrayList<>();
		row1.add(2);
		List<Integer> row2 = new ArrayList<>();
		row2.add(4);
		row2.add(4);
		List<Integer> row3 = new ArrayList<>();
		row3.add(8);
		row3.add(5);
		row3.add(6);
		List<Integer> row4 = new ArrayList<>();
		row4.add(4);
		row4.add(2);
		row4.add(6);
		row4.add(2);
		List<Integer> row5 = new ArrayList<>();
		row5.add(1);
		row5.add(5);
		row5.add(2);
		row5.add(3);
		row5.add(4);
		
		List<List<Integer>> triangle = new ArrayList<>();
		triangle.add(row1);
		triangle.add(row2);
		triangle.add(row3);
		triangle.add(row4);
		triangle.add(row5);
		
		//Call Function
		int sum = minPathSum(triangle);
		System.out.println();
		System.out.println("Min Sum: "+sum);
		
	}

}
