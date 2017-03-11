package com.epi.LinkedList;

class Node{
	int data;
	Node next;
	
	Node(int d1, Node n){
		this.data = d1;
		this.next = n;
	}
}
public class Q1_MergeLists {
	public static Node merge(Node l1, Node l2){
		Node dummy = new Node(0, null);
		Node current = dummy;
		Node p1 = l1;
		Node p2 = l2;
		while(p1 != null && p2 != null){
			if(p1.data <= p2.data){
				current.next = p1;
				p1 = p1.next;
			}
			else{
				current.next = p2;
				p2 = p2.next;
			}
			current = current.next;
		}
		current.next = p1.next != null ? p1:p2;
		return dummy.next;
	}

}
