package com.epi.Graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Coord{
	int x;
	int y;
	Coord(int x, int y){
		this.x = x;
		this.y = y;
	}
}
public class Q3_EnclosedRegion {
	
	public static void fillEnclosedRegion(List<List<Character>> board){
		if(board.isEmpty())
			return;
		//Maintain a visited list
		List<List<Boolean>> visited = new ArrayList<>(board.size());
		//Initialize
		for(int i=0; i<board.size(); i++){
			visited.add(new ArrayList<Boolean>(Collections.nCopies(board.get(i).size(), false)));
		}
		
		for(int i=0; i<board.size(); i++){
			//Now check the first column for Ws'
			if(board.get(i).get(0) == 'W' && !visited.get(i).get(0)){
				markBoundary(i,0,board, visited);
			}
			//Now check the last column
			if(board.get(i).get(board.get(i).size()-1) == 'W' && !visited.get(i).get(board.get(i).size()-1)){
				markBoundary(i,board.get(i).size()-1, board, visited);
			}
		}
		for(int j=0; j<board.get(0).size(); j++){
			//Check the first row
			if(board.get(0).get(j) == 'W' && !visited.get(0).get(j)){
				markBoundary(0,j,board,visited);
			}
			//Check the last row
			if(board.get(board.size()-1).get(j) == 'W' && !visited.get(board.size()-1).get(j)){
				markBoundary(board.size()-1,j, board, visited);
			}
		}
		
		//Mark the surrounded Ws' as Bs'
		for(int i=0; i<board.size(); i++){
			for(int j=0; j<board.get(i).size(); j++){
				if(board.get(i).get(j) == 'W' && !visited.get(i).get(j)){
					board.get(i).set(j, 'B');
				}
			}
		}
		
	}
	
	public static void markBoundary(int x, int y, List<List<Character>> board, List<List<Boolean>>visited){
		Queue<Coord> q = new LinkedList<Coord>();
		q.add(new Coord(x,y));
		visited.get(x).set(y, true);
		while(!q.isEmpty()){
			
			Coord curr = q.poll();
			final int[][] SHIFT= {{0,1},{1,0},{0,-1},{-1,0}};
			for(int[]dir : SHIFT){
				Coord next = new Coord(curr.x+dir[0], curr.y+dir[1]);
				if(next.x >= 0 && next.x < board.size() && next.y>=0
						&& next.y < board.get(next.x).size() 
						&& board.get(next.x).get(next.y) == 'W'
						&& !visited.get(next.x).get(next.y)){
					visited.get(next.x).set(next.y, true);
					q.add(next);
				}
			}
			
		}
	}

}
