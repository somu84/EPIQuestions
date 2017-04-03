package com.epi.Greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Interval{
	int start;
	int end;
	
	Interval(int s, int e){
		this.start = s;
		this.end = e;
	}
}
public class Q3_IntervalCovering {

	public static List<Integer> getChekupTime(List<Interval> times){
		Collections.sort(times, new Comparator<Interval>(){
			public int compare(Interval i1, Interval i2){
				return Integer.compare(i1.end, i2.end);
			}
		});
		List<Integer> visit = new ArrayList<>();
		Integer lastVisit = times.get(0).end;
		visit.add(lastVisit);
		for(Interval chek: times){
			if(chek.start > lastVisit){
				lastVisit = chek.end;
				visit.add(lastVisit);
			}
		}
		return visit;
	}
}
