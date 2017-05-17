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
		Node temp = head;
	    Node newHead = head;
	    while (temp != null) {
	        Node prev = temp.prev;
	        temp.prev = temp.next;
	        temp.next = prev;
	        newHead = temp;
	        temp = temp.prev;
	    }
	    return newHead;
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
