package com.epi.Heaps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

class Point implements Comparable<Point>{
	double x, y, z;
	
	Point(double x, double y, double z){
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public double distance(){
		return (x*x+y*y+z*z);
	}
	
	@Override
	public int compareTo(Point rhs){
		return Double.compare(this.distance(), rhs.distance());
	}
	
}
public class Q4_FindKClosest {

	public static List<Point> getK(Iterator<Point> seq, int k){
		PriorityQueue<Point> maxH = new PriorityQueue<>(k, Collections.reverseOrder());
		
		while(seq.hasNext()){
			maxH.add(seq.next());
			if(maxH.size() == k+1){
				maxH.remove();
			}
		}
		List<Point> res = new ArrayList<Point>(maxH);
		Collections.sort(res);
		return res;
	}
}
