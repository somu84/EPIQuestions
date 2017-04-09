package CommonExamples;

import java.util.*;

public class FindTwoMissingNumbers {
	
	public static List<Integer> findTwoMissing(int[] arr){
		int totalSum = (arr.length+2)*(arr.length+3)/2;
		int arrSum = 0;
		for(int i: arr)
			arrSum += i;
		int twoDiff = totalSum - arrSum;
		List<Integer> temp = new ArrayList<>();
		for(int i=0; i<arr.length; i++){
			if(arr[i] <= twoDiff/2){
				temp.add(arr[i]);
			}
		}
		int oneNum = findOneMissing(temp);
		List<Integer> res = new ArrayList<>();
		res.add(oneNum);
		res.add(twoDiff-oneNum);
		return res;
	}
	
	public static int findOneMissing(List<Integer> arr){
		int totalXor = 0;
		int arrXor = 0;
		for(int i=1; i<=arr.size()+1; i++)
			totalXor ^= i;
		for(int i: arr)
			arrXor ^= i;
		return totalXor^arrXor;
	}
	
	public static void main(String[] args){
		int [] arr= {3,4,5,1,2};
		System.out.println(findTwoMissing(arr));
	}

}
