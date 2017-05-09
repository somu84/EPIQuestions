package CommonExamples;

import java.util.*;

public class Extr_JobTime {
	/**
	 * https://www.careercup.com/question?id=5708190613241856
	 */
	public static int getJob(char[] arr, int k){
		if(arr.length == 0){
			return 0;
		}
		HashMap<Character, Integer> map = new HashMap<>();
		for(int i=0; i<arr.length; i++){
			if(map.containsKey(arr[i]))
				map.put(arr[i], map.get(arr[i])+ 1);
			else
				map.put(arr[i], 1);
		}
		int res = 0;
		char l = ' ';
		int i = 0;
		while(!map.isEmpty()){
			if(i == arr.length){
				i = 0;
			}
			if(arr[i] == ' '){
				i++;
				continue;
			}
			else if(arr[i] != l){
				res +=1;
				map.put(arr[i], map.get(arr[i])-1);
				if(map.get(arr[i]) == 0){
					map.remove(arr[i]);
				}
				l = arr[i];
				arr[i] = ' ';
				i++;
			}
			else if(map.size() == 1){
				int val = map.get(arr[i]);
				res += val * k + val;
				map.remove(arr[i]);
				i++;
			}else
				i++;
		}
		return res;
	}
	
	public static void main(String[] args){
		char[] arr1 = {'A','A','A','B','B','B','C','C','C'};
		char[] arr2 = {'A','A','A','B','C'};
		char[] arr3 = {'A','A','A','D','B','B','C','C'};
		System.out.println(getJob(arr1, 3));
		System.out.println(getJob(arr2, 2));
		System.out.println(getJob(arr3, 2));
	}

}
