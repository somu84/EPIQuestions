package CommonExamples;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BuildOrder {
	static class Node{
		List<Node> adj;
		Integer data;
		Color color;
		Node(int d){
			this.adj = new LinkedList<>();
			this.data = d;
			this.color = Color.WHITE;
		}
		
		@Override
		public boolean equals(Object o){
			if(this == o){
				return true;
			}
			if(o == null)
				return false;
			if(o instanceof Node) {
				Node test = (Node)o;
				if(this.data == test.data){
					return true;
				}
			}
			return false;
		}
	}
	public enum Color {BLACK, WHITE, GRAY};
	
	public static List<Node> buildGraph(List<List<Integer>> dependency){
		List<Node> res = new LinkedList<>();
		res.add(new Node(0));
		for(int i=1; i<dependency.size(); i++){
			Node temp = new Node(i);
			res.add(temp);
			for(Integer j:dependency.get(i)){
				if(j == null) continue;
				Node child = res.get(j);
				if(child == null){
					child = new Node(j);
				}
				temp.adj.add(child);
			}
		}
		return res;
	}
	
	public static List<Integer> getBuildOrder(List<Node> graph){
		List<Integer> res = new ArrayList<>();
		for(Node curr: graph){
			if(curr.color == Color.BLACK) continue;
			getBuildHelper(curr, res);
		}
		return res;
	}
	
	private static void getBuildHelper(Node curr, List<Integer> res){
		if(curr.color == Color.GRAY)
			return;
		curr.color = Color.GRAY;
		res.add(curr.data);
		for(Node next:curr.adj){
			if(next.color != Color.BLACK){
				getBuildHelper(next, res);
			}
		}
		curr.color = Color.BLACK;
		return;
	}

	public static void main(String[] args){
		List<Integer> jobs = new ArrayList<>();
		jobs.add(null);
		List<Integer> job2 = new ArrayList<>();
		job2.add(0);
		List<Integer> job3 = new ArrayList<>();
		job3.add(0);
		List<Integer> job4 = new ArrayList<>();
		job4.add(1);
		job4.add(2);
		List<Integer> job5 = new ArrayList<>();
		job5.add(3);
		List<Integer> job6 = new ArrayList<>();
		job6.add(4);
		
		List<List<Integer>> jobList = new ArrayList<>();
		jobList.add(jobs);
		jobList.add(job2);
		jobList.add(job3);
		jobList.add(job4);
		jobList.add(job5);
		jobList.add(job6);
		List<Node> graph = buildGraph(jobList);
		List<Integer> res = getBuildOrder(graph);
		for(Integer r: res){
			System.out.print(r);
		}
	}
}
