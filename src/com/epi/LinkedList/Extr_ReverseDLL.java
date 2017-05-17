package com.epi.LinkedList;

public class Extr_ReverseDLL {
	static class Node{
		int data;
		Node next;
		Node prev;
		
		Node(int d){
			data = d;
		}
	}
	
	public static Node reverse(Node head){
		if(head == null) return null;
		Node nH = null;
		Node t = null;
		Node c = head;
		while(c != null){
			t = c.next;
			c.next = c.prev;
			c.prev = t;
			nH = c;
			c = t;
		}
		return nH;
	}
	
	public static void main(String[] args){
		Node n = new Node(6);
		Node n1 = new Node(4);
		Node n2 = new Node(2);
		n.next = n1;
		n.prev = null;
		n1.next = n2;
		n1.prev = n;
		n2.next = null;
		n2.prev = n1;
		Node curr = n;
		while(curr != null){
			System.out.print(curr.data+" ");
			curr = curr.next;
		}
		System.out.println();
		Node r = reverse(n);
		curr = r;
		while(curr != null){
			System.out.print(curr.data+" ");
			curr = curr.next;
		}
				
	}

}
