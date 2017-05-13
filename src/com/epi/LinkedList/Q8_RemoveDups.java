package com.epi.LinkedList;

public class Q8_RemoveDups {
	static class Node{
		int data;
		Node next;
		
		Node(int d){
			data = d;
		}
	}
	/**
	 * Time Complexity: O(n)
	 * Space Complexity: O(1)
	 * @param h
	 */
	public static void removeDups(Node h){
		if(h == null) return;
		Node c = h;
		while(c != null && c.next != null){
			if(c.data == c.next.data){
				Node t = c.next;
				while( t != null && t.data == c.data){
					t = t.next;
				}
				c.next = t;
			}
			c = c.next;
		}
	}
	
	
	public static void main(String[] args){
		Node n = new Node(1);
		n.next = new Node(2);
		n.next.next = new Node(2);
		n.next.next.next = new Node(3);
		n.next.next.next.next = new Node(4);
		n.next.next.next.next.next = new Node(4);
		n.next.next.next.next.next.next = new Node(4);
		//n.next.next.next.next.next.next.next = new Node(5);
		
		removeDups(n);
		while(n.next != null){
			System.out.print(n.data+"->");
			n = n.next;
		}
		System.out.print(n.data);
	}

}
