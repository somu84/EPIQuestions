package com.epi.LinkedList;

public class Q13_AddListBasedInt {
	static class Node{
		int data;
		Node next;
		
		Node(int d){
			this.data = d;
			this.next = null;
		}
		
		public void display(){
			Node n = this;
			while(n.next != null){
				System.out.print(n.data+"->");
				n = n.next;
			}
			System.out.print(n.data);
		}
		
	}
	
	public static Node sum(Node l1, Node l2){
		Node d1 = l1;
		Node d2 = l2;
		Node newL = new Node(0);
		Node d3 = newL;
		newL.next = d3;
		int carry = 0;
		while(d1 != null && d2 != null){
			int a = d1.data;
			int b = d2.data;
			int c = a + b;
			if(carry == 1){
				c += 1;
				carry = 0;
			}
			if(c >= 10){
				c = c % 10;
				carry = 1;
			}
			Node temp = new Node(c);
			d3.next = temp;
			d3 = d3.next;
			d2 = d2.next;
			d1 = d1.next;
		}
		Node rem = d1 == null?d2:d1;
		while(rem != null){
			int c = rem.data;
			if(carry == 1){
				c += 1;
				carry = 0;
			}
			if(c >= 10){
				c = c % 10;
				carry = 1;
			}
			Node temp = new Node(c);
			d3.next = temp;
			d3 = d3.next;
			rem = rem.next;
		}
		if(carry == 1){
			Node temp = new Node(1);
			d3.next = temp;
		}
		return newL.next;
	}
	public static void main(String[] args){
		Node d1 = new Node(9);
		Node d2 = new Node (9);
		Node d3 = new Node (9);
		d1.next = d2;
		d2.next = d3;
		Node d4 = new Node(1);
		Node d5 = new Node (0);
		Node d6 = new Node (0);
		d4.next = d5;
		d5.next = d6;
		Node res = sum(d1, d4);
		res.display();
		
	}

}
