package com.epi.Honors;

public class Q9_ZipList {
	static class ListNode{
		ListNode next;
		int data;
	}
	
	public static ListNode zipList(ListNode L){
		if(L == null || L.next == null){
			return L;
		}
		ListNode fast = L;
		ListNode slow = L;
		while(fast != null && fast.next != null){
			fast = fast.next.next;
			slow = slow.next;
		}
		ListNode firstH = L;
		ListNode secondH = slow.next;
		slow.next = null;
		
		secondH = reverseList(secondH);
		ListNode firstHF = firstH;
		ListNode secondHF = secondH;
		while(secondHF != null){
			ListNode temp = secondHF.next;
			secondHF.next = firstHF.next;
			firstHF.next = secondHF;
			firstHF = firstHF.next.next;
			secondHF = temp;
		}
		return L;
	}
	
	public static ListNode reverseList(ListNode L){
		ListNode curr = L;
		ListNode prev = null;
		while(curr != null){
			ListNode temp = curr.next;
			curr.next = prev;
			prev= curr;
			curr = temp;
		}
		return prev;
		
	}

}
