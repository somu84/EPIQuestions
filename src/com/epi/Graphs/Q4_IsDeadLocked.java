package com.epi.Graphs;

import java.util.List;

class GraphVertex{
	public enum Color {WHITE, GRAY, BLACK};
	public Color color;
	List<GraphVertex> adj;
}
public class Q4_IsDeadLocked {
	
	public static boolean isDeadclocked(List<GraphVertex> G){
		for(GraphVertex g: G){
			if(g.color == GraphVertex.Color.WHITE && hasCycle(g))
				return true;
		}
		return false;
	}
	
	public static boolean hasCycle(GraphVertex curr){
		if(curr.color == GraphVertex.Color.GRAY)
			return true;
		curr.color = GraphVertex.Color.GRAY;
		for(GraphVertex next:curr.adj){
			if(next.color != GraphVertex.Color.BLACK){
				if(hasCycle(next))
					return true;
			}
				
		}
		curr.color = GraphVertex.Color.BLACK;
		return false;
	}

}
