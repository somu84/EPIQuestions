package com.epi.Greedy;
class Element{
	int element;
	int count;
	
	Element(int elem, int cnt){
		this.element = elem;
		this.count = cnt;
	}
}
public class q5_MajorityElement {

	public static Element majorityElement(int[] arr){
		Element res = new Element(arr[0], 1);
		for(int i=1; i<arr.length; i++){
			if(res.count == 0){
				res.element = arr[i];
				res.count = 1;
			}
			else if(res.element == arr[i]){
				res.count++;
			}
			else{
				res.count--;
			}
		}
		return res;
	}
}
