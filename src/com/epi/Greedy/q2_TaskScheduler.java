package com.epi.Greedy;

import java.util.Collections;
import java.util.List;

public class q2_TaskScheduler {
	public static int totalWeightTime(List<Integer> times){
		Collections.sort(times);
		int totalTime = 0;
		for(int i=0; i<times.size(); i++){
			int numRemItems = times.size() - (i+1);
			totalTime += times.get(i) * numRemItems;
		}
		return totalTime;
	}

}
