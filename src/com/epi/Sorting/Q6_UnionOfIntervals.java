package com.epi.Sorting;

import java.util.*;
import java.util.Objects;

public class Q6_UnionOfIntervals {
	static class Interval implements Comparable<Interval>{
		Endpoint left = new Endpoint();
		Endpoint right = new Endpoint();
		
		static class Endpoint{
			boolean isClosed;
			int val;
		}
		@Override
		public int compareTo(Interval i){
			if(Integer.compare(left.val, i.left.val) != 0){
				return left.val - i.left.val;
			}
			if(left.isClosed && i.left.isClosed){
				return -1;
			}
			if(!left.isClosed && i.left.isClosed){
				return 1;
			}
			return 0;
		}
		
		@Override 
		public boolean equals(Object obj){
			if(obj == null || !(obj instanceof Interval))
				return false;
			if(this == obj)
				return true;
			Interval i = (Interval) obj;
			return left.val == i.left.val && left.isClosed == i.left.isClosed;
		}
		
		@Override
		public int hashCode(){
			return Objects.hash(left.val, left.isClosed);
		}
	}
	
	public static List<Interval> unionOfIntervals(List<Interval> intervals){
		if(intervals == null){
			return null;
		}
		Collections.sort(intervals);
		Interval curr  = intervals.get(0);
		List<Interval> result = new ArrayList<>();
		for(int i=1; i<intervals.size(); i++){
			if(intervals.get(i).left.val < curr.right.val
					|| (intervals.get(i).left.val == curr.right.val
					&& (intervals.get(i).left.isClosed || curr.right.isClosed))){
				if(intervals.get(i).right.val > curr.right.val 
						|| (intervals.get(i).right.val == curr.right.val &&
						intervals.get(i).right.isClosed)){
					curr.right = intervals.get(i).right;
				}
			}else{
				result.add(curr);
				curr = intervals.get(i);
			}
		}
			
		result.add(curr);
		return result;
	}
}
