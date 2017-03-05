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
}
