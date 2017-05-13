package com.epi.LinkedList;

import com.epi.LinkedList.Q2_ReverseAList.Node;

public class Q11_ListIsPalindrome {
	static class Node{
		int data;
		Node next;
		
		Node(int d){
			this.data = d;
		}
	}
	
	public static boolean isPalindrome(Node n){
		if(n == null || n.next == null)
			return true;
		Node s = n, f = n;
		while(f.next != null && f.next.next != null){
			s = s.next;
			f = f.next.next;
		}
		Node l = s.next;
		s.next = null;
		l = reverse(l);
		while(l != null && n != null){
			if(l.data != n.data)
				return false;
			l = l.next;
			n = n.next;
		}
		return true;
	}
	
	public static Node reverse(Node l){
		if(l == null || l.next == null) return l;
		Node p = null;
		while(l != null){
			Node t = l.next;
			l.next = p;
			p = l;
			l = t;
		}
		return p;
	}
	
	public static void main(String[] args){
		Node n = new Node(1);
		n.next = new Node(2);
		n.next.next = new Node(2);
		n.next.next.next = new Node(3);
		n.next.next.next.next = new Node(4);
		n.next.next.next.next.next = new Node(2);
		n.next.next.next.next.next.next = new Node(1);
		
		System.out.println(isPalindrome(n));
	}

}
