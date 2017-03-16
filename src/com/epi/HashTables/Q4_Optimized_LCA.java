package com.epi.HashTables;

import java.util.HashSet;
import java.util.Set;

public class Q4_Optimized_LCA {

	static class Tree{
		Tree left;
		Tree right;
		Tree parent;
		int data;
	}
	
	public static Tree getLCA(Tree n1, Tree n2){
		Set<Tree> c = new HashSet<>();
		while(n1 != null && n2 != null){
			if(n1 != null){
				if(!c.add(n1))
					return n1;
				n1 = n1.parent;
			}
			if(n2 != null){
				if(!c.add(n2))
					return n2;
				n2 = n2.parent;
			}
		}
		return null;
	}
}
