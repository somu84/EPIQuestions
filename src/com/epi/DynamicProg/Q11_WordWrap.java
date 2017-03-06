package com.epi.DynamicProg;

import java.util.List;

public class Q11_WordWrap {
	
	/**
	 * This solution is from YouTube:
	 * https://www.youtube.com/watch?v=RORuwHiblPc
	 * The Recurrence formula is: 
	 * M(i) = M(j)+C[i][j-1]
	 */
	public String justify(String words[], int width) {
		int cost[][] = new int[words.length+1][words.length+1];
		//Build the cost matrix
		for(int i=0; i<words.length;i++){
			cost[i][i] = width-words[i].length();
			for(int j=i+1; j<words.length;j++){
				cost[i][j] = cost[i][j-1] - words[j].length() -1;
			}
		}
		for(int i=0; i<words.length;i++){
			for(int j=i; j<words.length;j++){
				if(cost[i][j] < 0)
					cost[i][j] = Integer.MAX_VALUE;
				else{
					cost[i][j] = (int)Math.pow(cost[i][j], 2);
				}
			}
		}
		
		int minCost[] = new int[words.length];
		int result[] = new int[words.length];
		for(int i=words.length-1; i>=0; i--){
			minCost[i] = cost[i][words.length-1];
			result[i] = words.length;
			for(int j=words.length-1; j>=0;j--){
				if(cost[i][j]==Integer.MAX_VALUE) continue;
				
				if(minCost[i] > minCost[j]+cost[i][j-1]){
					minCost[i] = minCost[j]+cost[i][j-1];
					result[i] = j;
				}
			}
		}
		int i= 0 ;
		int j;
		
		System.out.println("Min cost is : "+minCost[0]);
		System.out.println();
		
		StringBuilder b = new StringBuilder();
		do{
			j=result[i];
			for(int k= i; k<j; k++){
				b.append(words[k]+" ");
			}
			b.append("\n");
			i = j;
		
		}while(j<words.length);
		return b.toString();
	}
	
	//Space optimized solution
	public static int minWrap(List<String> words, int width){
		return 0;
	}
}
