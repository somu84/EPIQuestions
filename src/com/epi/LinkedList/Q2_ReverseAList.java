package com.epi.LinkedList;

public class Q2_ReverseAList {
	static class Node{
		Node next;
		Integer data;
		
		Node(int d, Node n){
			this.data = d;
			this.next = n;
		}
		
		Node(){
			this.data = null;
			this.next = null;
		}
		
		public void insert(Node n){
			Node curr = this;
			while(curr.next != null){
				curr = curr.next;
			}
			curr.next = n;
		}
	}
	
	public static void reverse(Node root){
		if(root == null){
			return;
		}
		reverse(root.next);
		System.out.println(root.data);
	}
	
	public static Node reverseList(Node root){
		Node curr = root;
		Node prev = null;
		while(curr != null){
			Node temp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = temp;
		}
		return prev;
	}

	public static void main(String[] args){
		Node n1 = new Node(1,null);
		Node n2 = new Node(2, null);
		Node n3 = new Node(3, null);
		n2.insert(n3);
		n1.insert(n2);
		Node t = reverseList(n1);
		while(t != null){
			System.out.print(t.data+" ");
			t = t.next;
		}
	}
}
