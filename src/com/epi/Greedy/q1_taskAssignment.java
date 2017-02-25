package com.epi.Greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class PairedTask{
	int t1;
	int t2;
	
	PairedTask(int t1, int t2){
		this.t1 = t1;
		this.t2 = t2;
	}
}
public class q1_taskAssignment {
	public static List<PairedTask> optimumAssign(List<Integer> tasks){
		Collections.sort(tasks);
		List<PairedTask> result = new ArrayList<>();
		for(int i=0, j=tasks.size() -1; i<j; i++, j--){
			result.add(new PairedTask(tasks.get(i),tasks.get(j)));
		}
		return result;
	}

}
