package CommonExamples;

import java.util.*;

public class HeapDemo {

	public static List<Integer> heapDemo(int[] arr, int k){
		PriorityQueue<Integer> heap = new PriorityQueue<>(k,Collections.reverseOrder());
		for(int i: arr){
			heap.add(i);
		}
		List<Integer> res = new ArrayList<>();
		for(int i=0; i<k; i++){
			res.add(heap.remove());
		}
		return res;
	}
	
	public static void main(String[] args){
		int[] arr1 = {4,77,3,4455,78,9,1,3,5,6};
		
		List<Integer> res1 = heapDemo(arr1, 2);
		for(int k: res1){
			System.out.print(k+" ");
		}
		System.out.println();
		List<Integer> res2 = heapDemo(arr1, 3);
		for(int k: res2){
			System.out.print(k+" ");
		}
	}
}
