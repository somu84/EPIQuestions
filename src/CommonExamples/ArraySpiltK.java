package CommonExamples;

import java.util.*;

public class ArraySpiltK {
	
	public static List<List<Integer>> getSubLists(int[] arr, int k){
		List<List<Integer>> results = new ArrayList<>();
		int i= 0;
		for(i = arr.length -1; i>arr.length-1 - k; i--){
			List<Integer> t = new ArrayList<>();
			t.add(arr[i]);
			results.add(t);
		}
		while(i>=0){
			int c = getMinListIndex(results);
			results.get(c).add(arr[i]);
			i--;
		}
		return results;
	}
	
	private static int getMinListIndex(List<List<Integer>> arr){
		int minIndex = -1;
		int minSum = Integer.MAX_VALUE;
		int i= 0;
		for(List<Integer> l : arr){
			int currSum = getSum(l);
			if(currSum < minSum){
				minSum = currSum;
				minIndex = i;
			}
			i++;
		}
		return minIndex;
	}
	
	private static int getSum(List<Integer> arr){
		int sum = 0;
		for(int n:arr){
			sum += n;
		}
		return sum;
	}
	
	public static void main(String[] args){
		int[] arr = {1, 3, 6, 9, 10, 12};
		List<List<Integer>> res = getSubLists(arr, 2);
		System.out.println(res);
	}
}
