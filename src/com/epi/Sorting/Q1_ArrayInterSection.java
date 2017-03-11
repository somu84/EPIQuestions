package com.epi.Sorting;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q1_ArrayInterSection {
	
	public static List<Integer> getCommon(List<Integer> A, List<Integer> B){
		Set<Integer> res = new HashSet<>();
		int a = 0, b= 0;
		while(a<A.size() && b<B.size()){
			if(res.contains(A.get(a))){
				a++; continue;
			}
			if(res.contains(B.get(b))){
				b++; continue;
			}
			if(A.get(a)<B.get(b)){
				a++;
				continue;
			}
			else if(A.get(a)>B.get(b)){
				b++;
				continue;
			}
			else{
				res.add(A.get(a));
				a++;
				b++;
				continue;
			}
		}
		return new ArrayList<>(res);
	}

}
