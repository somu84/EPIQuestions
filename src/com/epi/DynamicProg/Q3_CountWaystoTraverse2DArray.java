package com.epi.DynamicProg;

public class Q3_CountWaystoTraverse2DArray {
	public static int countWays(int[][] arr){
		int[][]temp = new int[arr.length][arr[0].length];
		for(int i=0; i<temp[0].length; i++){
			temp[0][i] = 1;
		}
		for(int i=0; i<temp.length; i++){
			temp[i][0] = 1;
		}
		
		for(int i=1; i<temp.length; i++){
			for(int j=1; j<temp[0].length; j++){
				temp[i][j] = temp[i-1][j]+temp[i][j-1];
			}
		}
		return temp[temp.length-1][temp[0].length-1];
	}
	
	public static void main(String[] args){
		int[][] arr = {{1,3,5,8},
					   {4,2,1,7},
					   {4,3,2,3}};
					   
		System.out.println("Number of Ways: "+countWays(arr));
		
		System.out.println("Min Cost:" +minCostPath(arr));
	}
	
	//Variant find the min cost path
	public static int minCostPath(int[][] arr){
		int[][]temp = new int[arr.length][arr[0].length];
		temp[0][0] = arr[0][0];
		for(int i=1; i<temp.length;i++){
			temp[i][0] = temp[i-1][0]+arr[i][0];
		}
		for(int i=1;i<temp[0].length;i++){
			temp[0][i] = temp[0][i-1]+arr[0][i];
		}
		for(int i=1; i<temp.length; i++){
			for(int j=1;j<temp[0].length; j++){
				temp[i][j] = arr[i][j]+min(temp[i-1][j],temp[i][j-1]);
			}
		}
		printMinCostPath(temp, arr);
		return temp[temp.length-1][temp[0].length-1];
	}
	
	public static int min(int a, int b){
		return a<b?a:b;
	}
	
	public static void printMinCostPath(int[][]temp, int[][]arr){
		int i = temp.length -1;
		int j = temp[0].length -1;
		System.out.print("Min Cost Path: "+ arr[i][j]+"<-");
		while(true){
			if(i==0 && j==0){
				System.out.println();
				break;
			}
			if(i != 0 && j!= 0){
				if(temp[i][j] == temp[i-1][j]+arr[i][j]){
					System.out.print(arr[i-1][j]+"<-");
					i=i-1;
				}
				else{
					System.out.print(arr[i][j-1]+"<-");
					j=j-1;
				}
			}
			else if(i==0){
				System.out.print(arr[i][j-1]+"<-");
				j=j-1;
			}
			else{
				System.out.print(arr[i-1][j]);
				i=i-1;
			}
			
		}
	}

}
