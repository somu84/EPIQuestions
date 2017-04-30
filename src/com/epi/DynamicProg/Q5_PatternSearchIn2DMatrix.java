package com.epi.DynamicProg;
import java.util.HashSet;
import java.util.Set;

class Attempt{
	int x;
	int y;
	int offset;
	
	Attempt(int x, int y, int offset){
		this.x = x;
		this.y = y;
		this.offset = offset;
	}
}
public class Q5_PatternSearchIn2DMatrix {

	public static boolean patternSearch(int[][] arr, int[] pattern){
		
		Set<Attempt> failedAttempts = new HashSet<>();
		for(int i=0; i<arr.length; i++){
			for(int j=0; j<arr[0].length;j++){
				if(isPatternExist(arr,i,j,pattern,0, failedAttempts))
					return true;
					
			}
		}
		return false;
	}
	
	private static boolean isPatternExist(int[][]arr, int x, int y, int[]pattern,int offset, Set<Attempt> failedAtt){
		if(pattern.length == offset)
			return true;
		
		if(x < 0 || x >= arr.length ||y<0 || y>=arr[x].length || 
				failedAtt.contains(new Attempt(x,y,offset)))
			return false;
		if(arr[x][y] == pattern[offset]
				&&(isPatternExist(arr,x-1,y,pattern,offset+1,failedAtt)
				|| isPatternExist(arr,x+1,y,pattern,offset+1,failedAtt)
				|| isPatternExist(arr,x,y+1,pattern,offset+1,failedAtt)
				|| isPatternExist(arr,x,y-1,pattern,offset+1,failedAtt)))
			return true;
		
		failedAtt.add(new Attempt(x,y,offset));
		return false;
	}
	
	//Using DFS
	public static boolean search(int[][] arr, int[] num){
		if(arr == null || arr.length == 0)
			return false;
		for(int i = 0; i<arr.length; i++){
			for(int j = 0; j < arr[i].length; j++){
				if(arr[i][j] == num[0])
					if(DFS(arr, num, i, j, 1))
						return true;
			}
		}
		return false;
	}
	
	private static boolean DFS(int[][]arr, int[] num, int i, int j, int idx){
		if(idx == num.length) return true;
		
		final int[][] SHIFT = {{0,1}, {0,-1}, {-1,0}, {1,0}};
		for(int[] l : SHIFT){
			if(isValid(arr, i+l[0], j+l[1])){
				if(arr[i+l[0]][j+l[1]] == num[idx]){
					if(DFS(arr, num, i+l[0], j+l[1], idx+1))
						return true;
				}
			}
		}
		return false;
	}
	
	private static boolean isValid(int[][]arr, int i, int j){
		if(i < 0 || j < 0 || i >= arr.length || j >= arr[i].length)
			return false;
		return true;
	}
	
	public static void main(String[] args){
		int[][] arr = {{1, 2, 3},{3, 4, 5}, {5, 6, 7}};
		int [] num = {1, 3, 5, 6};
		System.out.println(search(arr, num));
	}
}
