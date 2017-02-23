package com.epi.Graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.SortedSet;
import java.util.TreeSet;

class VertexWithDistance{
	public GraphVertex2 vertex;
	public Integer distance;
	
	VertexWithDistance(GraphVertex2 vertex, int distance){
		this.vertex = vertex;
		this.distance = distance;
	}
}

class DistanceWithFewEdges{
	int distance;
	int minEdges;
	
	DistanceWithFewEdges(int dist, int edg){
		this.distance = dist;
		this.minEdges = edg;
	}
}

class GraphVertex2 implements Comparable<GraphVertex2>{

	DistanceWithFewEdges dFE = new DistanceWithFewEdges(Integer.MAX_VALUE, 0);
	List<VertexWithDistance> edges = new ArrayList<>();
	int id;
	GraphVertex2 pred = null;
	
	@Override
	public int compareTo(GraphVertex2 arg0) {
		if(dFE.distance != arg0.dFE.distance){
			return Integer.compare(dFE.distance,arg0.dFE.distance);
		}
		if(dFE.minEdges != arg0.dFE.minEdges){
			return Integer.compare(dFE.minEdges, arg0.dFE.minEdges);
		}
		return Integer.compare(id,arg0.id);
	}
	@Override
	public boolean equals(Object obj){
		if(obj == null || (obj instanceof GraphVertex2)){
			return false;
		}
		if(this == obj)
			return true;
		GraphVertex2 that = (GraphVertex2) obj;
		return id==that.id && dFE.distance == that.dFE.distance && dFE.minEdges == that.dFE.minEdges;
	}
	
	@Override
	public int hashCode(){
		return Objects.hash(dFE.distance, dFE.minEdges);
	}
	
}
public class Q9_ShortestPathEdges {

	public static void dijkstraShortestPath(GraphVertex2 s, GraphVertex2 t){
		s.dFE = new DistanceWithFewEdges(0, 0);
		SortedSet<GraphVertex2> nodeSet = new TreeSet<>();
		nodeSet.add(s);
		
		while(!nodeSet.isEmpty()){
			//Extracts the min distance from the heap
			GraphVertex2 next = nodeSet.first();
			if(next.equals(t))
				break;
			
			nodeSet.remove(nodeSet.first());
			
			//Relax the edges
			for(VertexWithDistance v: next.edges){
				int vDist = next.dFE.distance+v.distance;
				int vEdg = next.dFE.minEdges+1;
				if(v.vertex.dFE.distance > vDist || (v.vertex.dFE.distance == vDist
						&& v.vertex.dFE.minEdges > vEdg)){
					nodeSet.remove(v.vertex);
					v.vertex.pred = next;
					v.vertex.dFE = new DistanceWithFewEdges(vDist, vEdg);
					nodeSet.add(v.vertex);
				}
			}
		}
		outPutShortestPath(t);
	}
	private static void outPutShortestPath(GraphVertex2 t) {
		if(t!= null){
			outPutShortestPath(t.pred);
			System.out.println(t.id+" ");
		}
	}
	
}
