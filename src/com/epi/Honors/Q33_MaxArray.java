package com.epi.Honors;

import java.util.*;

public class Q33_MaxArray {
	/**
	 * https://www.youtube.com/watch?v=_Lf1looyJMU&t=21s
	 * @param arr
	 * @return
	 */
	public static int maxSubSquare(int[][]arr){
		int max = 0;
		int[][]T = new int[arr.length+1][arr[0].length+1];
		for(int i=1; i<T.length; i++){
			for(int j=1; j<T[i].length; j++){
				if(arr[i-1][j-1] == 0){
					T[i][j] = 0;
				}
				else{
					T[i][j] = min(T[i-1][j], T[i-1][j-1], T[i][j-1])+1;
					if(max < T[i][j]){
						max = T[i][j];
					}
				}
			}
		}
		return max;
	}
	
	private static int min(int a, int b, int c){
		return Math.min(a, Math.min(b, c));
	}
	
	/**
	 * https://www.youtube.com/watch?v=g8bSdXCG-lA&index=17&list=PLrmLmBdmIlpsHaNTPP_jHHDx_os9ItYXr
	 * @param arr
	 * @return
	 */
	public static int maxSubRectangle(int[][]arr){
		int max = 0;
		int[]T = new int[arr[0].length];
		for(int i=0; i<arr.length; i++){
			for(int j=0; j<arr[i].length; j++){
				if(arr[i][j] == 0){
					T[j] = 0;
				}
				else{
					T[j]+=1;
				}
			}
			int currMax = getMaxHistogram(T);
			if(max < currMax){
				max = currMax;
			}
		}
		return max;
	}
	
	/**
	 * https://www.youtube.com/watch?v=ZmnqCZp9bBs&t=375s
	 * @param arr
	 * @return
	 */
	private static int getMaxHistogram(int[] arr){
		Deque<Integer> st = new LinkedList<>();
		int area = 0;
		int maxArea = 0;
		int i = 0;
		for(i=0; i<arr.length; i++){
			if(st.isEmpty() || arr[i] >= st.peekFirst()){
				st.push(i++);
			}
			else{
				int top = st.pop();
				if(st.isEmpty()){
					area = arr[top]* i;
				}else{
					area = arr[top]*(i-st.peekFirst()-1);
				}
				if(area > maxArea){
					maxArea = area;
				}
			}
		}
		while(!st.isEmpty()){
			int j = st.pop();
			if(st.isEmpty()){
				area = arr[j]*i;
			}else{
				area = arr[j]*(i-st.peekFirst() - 1);
			}
			if(area > maxArea){
				maxArea = area;
			}
		}
		return maxArea;
	}
	
	public static void main(String[] args){
		int[][]arr = {{0,0,1,1,1},{1,0,1,1,1},{0,1,1,1,1},{1,0,1,1,1}};
		System.out.println("Max Sub Square: "+maxSubSquare(arr));
		System.out.println("Max Sub Rectangle: "+maxSubRectangle(arr));
		
	}

}
