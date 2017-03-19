package com.epi.LinkedList;

public class Q4_OverlappingLists {
	static class Node{
		Node next;
		Integer data;
	}
	
	public static Node getOverlappingNode(Node n1, Node n2){
		int l1 = length(n1);
		int l2 = length(n2);
		if(l1 < l2){
			n2 = advanceList(l2-l1, n2);
		}
		else if(l1 > l2){
			n1 = advanceList(l1-l2, n1); 
		}
		
		while(n1 != null && n2 != null){
			if(n1 == n2){
				return n1;
			}
			n1 = n1.next;
			n2 = n2.next;
		}
		return null;
	}
	
	private static int length(Node n){
		Node t = n;
		int len = 1;
		while(t != null){
			t = t.next;
			len++;
		}
		return len;
	}
	
	private static Node advanceList(int k, Node n){
		while(k-->0){
			n = n.next;
		}
		return n;
	}

}
