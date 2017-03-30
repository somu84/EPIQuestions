package com.epi.Honors;

public class Q33_MaxArray {
	/**
	 * https://www.youtube.com/watch?v=_Lf1looyJMU&t=21s
	 * @param arr
	 * @return
	 */
	public static int maxSubSquare(int[][]arr){
		int max = Integer.MIN_VALUE;
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
	
	public static void main(String[] args){
		int[][]arr = {{0,0,1,1,1},{1,0,1,1,1},{0,1,1,1,1},{1,0,1,1,1}};
		System.out.println("Max Sub Square: "+maxSubSquare(arr));
		
	}

}
