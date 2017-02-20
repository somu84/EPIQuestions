package com.epi.Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class GraphVertex1{
	int label;
	List<GraphVertex1> adj;
	
	GraphVertex1(int label){
		this.label = label;
		this.adj = new ArrayList<GraphVertex1>();
	}
}
public class Q5_CloneGraph {

	public static GraphVertex1 clone(GraphVertex1 g){
		if(g == null)
			return null;
		//This hash stores the node and a clone of the node
		Map<GraphVertex1, GraphVertex1> map = new HashMap<>();
		Queue<GraphVertex1> q = new LinkedList<>();
		q.add(g);
		map.put(g, new GraphVertex1(g.label));
		while(!q.isEmpty()){
			GraphVertex1 v = q.remove();
			for(GraphVertex1 next:v.adj){
				if(!map.containsKey(next)){
					map.put(next, new GraphVertex1(next.label));
					q.add(next);
				}
				map.get(v).adj.add(map.get(next));
			}
		}
		return map.get(g);
	}
}
