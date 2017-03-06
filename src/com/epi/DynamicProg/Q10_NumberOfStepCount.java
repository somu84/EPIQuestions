package com.epi.DynamicProg;

public class Q10_NumberOfStepCount {
	/**
	 * Time Complexity: O(n*k)
	 * Space Complexity: O(n)
	 * @param n
	 * @param step
	 * @return
	 */
	public static int numberOfSolutions(int n, int step){
		int[] temp = new int[n+1];
		temp[0] = 1;
		for(int i=1;i<=step;i++){
			for(int j=1;j<=n;j++){
				if(j >= i)
					temp[j] += temp[j-i];
			}
		}
		return temp[n];
		
	}
	
	//Recursive solution
	public static int numberOfSolutionsRec(int n, int k){
		return compute(n, k, new int[n+1]);
	}
	
	private static int compute(int top, int k, int[] ways){
		if(top<=1)
			return 1;
		if(ways[top] == 0){
			for(int i=1; i<=k && top-i>=0; i++){
				ways[top] +=compute(top-i,k,ways);
			}
		}
		return ways[top];
	}

}
