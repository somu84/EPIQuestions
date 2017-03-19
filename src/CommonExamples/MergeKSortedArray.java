package CommonExamples;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedArray {
	static class QueueNode implements Comparable<QueueNode>{
		int array, index, value;
		QueueNode(int arr, int ind, int val){
			this.array = arr;
			this.index = ind;
			this.value = val;
		}
		
		@Override
		public int compareTo(QueueNode n){
			if(this.value > n.value) return 1;
			if(this.value < n.value) return -1;
			return 0;
		}
	}
	
	public static List<Integer> megreK(int[][] arrays){
		PriorityQueue<QueueNode> minHeap = new PriorityQueue<>();
		for(int i=0; i<arrays.length;i++){
			minHeap.add(new QueueNode(i,0,arrays[i][0]));
		}
		List<Integer>results = new ArrayList<>();
		while(!minHeap.isEmpty()){
			QueueNode n = minHeap.poll();
			results.add(n.value);
			if(n.index < arrays[n.array].length-1){
				minHeap.add(new QueueNode(n.array, n.index+1, arrays[n.array][n.index+1]));
			}
		}
		return results;
	}

}
