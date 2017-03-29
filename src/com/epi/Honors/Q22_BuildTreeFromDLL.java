package com.epi.Honors;

public class Q22_BuildTreeFromDLL {
	static class DLL{
		DLL next;
		DLL prev;
		int data;
		
		DLL(int data, DLL next, DLL prev){
			this.data = data;
			this.next = next;
			this.prev = prev;
		}
	}
	
	private static DLL head;
	
	public static DLL buiildBST(DLL L, int len){
		head = L;
		return buildTree(0, len);
	}
	
	private static DLL buildTree(int start, int end){
		if(start >= end) return null;
		
		int mid = start + (end - start)/2;
		
		DLL left = buildTree(start, mid);
		DLL curr = new DLL(head.data, left, null);
		head = head.next;
		curr.next = buildTree(mid+1, end);
		return curr;
	}

}
