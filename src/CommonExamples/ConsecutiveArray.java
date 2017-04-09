package CommonExamples;

import java.util.HashSet;

public class ConsecutiveArray {
	public static int consecutive(int[] arr){
		HashSet<Integer> set = new HashSet<>();
		for(int i:arr){
			set.add(i);
		}
		int maxLen = 0;
		for(int i=0; i<arr.length; i++){
			if(set.contains(arr[i]-1)) continue;
			//set.add(arr[i]);
			int len = 1;
			for(int j=i+1; j<arr.length; j++){
				if(set.contains(arr[j]-1)){
					//set.add(arr[j]);
					len++;
				}else{
					break;
				}
			}
			if(maxLen < len){
				maxLen = len;
			}
		}
		return maxLen;
	}
	
	public static void main(String[] args){
		int[] arr= {4, 2, 1, 6, 5};
		int[] arr2 = {5, 5, 3 ,1};
		System.out.println(consecutive(arr));
		System.out.println(consecutive(arr2));
	}
}
