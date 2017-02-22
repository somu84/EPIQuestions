package CommonExamples;

import java.util.HashMap;
import java.util.Map;

/**
 * Disjoint Set implementation
 * https://www.youtube.com/watch?v=ID00PMy0-vE&t=17s
 * @author Somu
 *
 */

public class DisjointSets {
	Map<Long, Node> map = new HashMap<>();
	class Node{
		long data;
		Node parent;
		int rank;
	}
	
	void makeSet(long data){
		Node node = new Node ();
		node.data = data;
		node.parent = node;
		node.rank = 0;
		map.put(data, node);
	}
	
	void union(long d1, long d2){
		Node n1 = map.get(d1);
		Node n2 = map.get(d2);
		Node p1 = findSet(n1);
		Node p2 = findSet(n2);
		//check if they are part of same set
		if(p1.data == p2.data)
			return;
		if(p1.rank >= p2.rank){
			p1.rank = (p1.rank == p2.rank)?p1.rank+1:p1.rank;
			p2.parent = p1;
		}else{
			p1.parent = p2;
		}
	}
	
	public long findSet(long d1){
		return findSet(map.get(d1)).data;
	}
	
	public Node findSet(Node n1){
		Node parent = n1.parent;
		if(parent == n1){
			return parent;
		}
		n1.parent = findSet(n1.parent);
		return n1.parent;
	}

}
