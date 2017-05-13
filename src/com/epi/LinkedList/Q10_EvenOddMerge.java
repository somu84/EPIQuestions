package com.epi.LinkedList;

public class Q10_EvenOddMerge {
	static class Node{
		String data;
		Node next;
		
		Node(String s){
			data = s;
		}
	}
	
	public static Node merge(Node n){
		if(n == null || n.next == null)
			return n;
		Node e = n;
		Node o = n.next;
		Node evenHead = e;
		Node oddHead = o;
		while(e.next != null && e.next.next != null){
			o = e.next;
			e.next = e.next.next;
			o.next = o.next.next;
			e = e.next;
			o = o.next;
		}
		e.next = oddHead;
		return evenHead;
	}
	
	public static void main(String[] args){
		Node n = new Node("L0");
		Node n1 = new Node("L1");
		n.next = n1;
		Node n2 = new Node("L2");
		n1.next = n2;
		Node n3 = new Node("L3");
		n2.next = n3;
		Node n4 = new Node("L4");
		n3.next = n4;
		Node n5 = new Node("L5");
		n4.next = n5;
		Node n6 = new Node("L6");
		n5.next = n6;
		Node r1 = n;
		while(r1.next != null){
			System.out.print(r1.data+" -> ");
			r1 = r1.next;
		}
		System.out.print(r1.data);
		System.out.println();
		Node r = merge(n);
		while(r.next != null){
			System.out.print(r.data+" -> ");
			r = r.next;
		}
		System.out.print(r.data);
	}

}
