package com.epi.LinkedList;

public class Extr_SortedCircularList {
	static class Node{
		int data;
		Node next;
		
		Node(int d){
			data = d;
		}
	}
	
	public static Node insert(Node n, int d){
		if(n == null)
			return new Node(d);
		Node p = n;
		if(p.data > d ){
			while(p.data < p.next.data){
				p = p.next;
			}
			Node l = p.next;
			Node t = new Node(d);
			p.next = t;
			t.next = l;
			p = p.next;
			return p;
		}else{
			Node c = p;
			while(p.data < p.next.data && p.data < d){
				c = p;
				p = p.next;
			}
			if(d < p.data){
				Node t = new Node(d);
				c.next = t;
				t.next = p;
			}else{
				Node t = new Node(d);
				Node l = p.next;
				p.next = t;
				t.next = l;
			}
			return n;
		}
	}
	
	public static void main(String[] args){
		Node h = new Node(4);
		Node n = h;
		h.next = new Node(6);
		h.next.next = new Node(9);
		h.next.next.next = new Node(12);
		h.next.next.next.next = n;
		Node res1 = n;
		while(res1.data < res1.next.data){
			System.out.print(res1.data+" ");
			res1 = res1.next;
		}
		System.out.print(res1.data);
		System.out.println();
		Node res = insert(h, 1);
		while(res.data < res.next.data){
			System.out.print(res.data+" ");
			res = res.next;
		}
		System.out.print(res.data);
	}

}
