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

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((data == null) ? 0 : data.hashCode());
			result = prime * result + ((next == null) ? 0 : next.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Node other = (Node) obj;
			if (data == null) {
				if (other.data != null)
					return false;
			} else if (!data.equals(other.data))
				return false;
			if (next == null) {
				if (other.next != null)
					return false;
			} else if (!next.equals(other.next))
				return false;
			return true;
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
