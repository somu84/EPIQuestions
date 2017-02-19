package com.epi.Graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class Coordinates{
	int x;
	int y;
	Coordinates(int x, int y){
		this.x = x;
		this.y = y;
	}
	@Override
	public int hashCode() {
		return Objects.hash(x,y);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coordinates other = (Coordinates) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
	
}

public class Q1_MazeSolver {
	public static enum Color {WHITE, BLACK};
	
	public static List<Coordinates> searchMaze(List<List<Color>> maze, Coordinates s, Coordinates e){
		List<Coordinates> path = new ArrayList<Coordinates>();
		maze.get(s.x).set(s.y, Color.BLACK);
		path.add(s);
		if(!searchMazeHelper(maze, s, e, path)){
			path.remove(path.size() -1);
		}
		return path;
	}
	
	public static boolean searchMazeHelper(List<List<Color>> maze, Coordinates curr, Coordinates e, List<Coordinates> path){
		if(curr.equals(e))
			return true;
		
		final int[][] SHIFT = {{0,1},{1,0},{0,-1},{-1,0}};
		for(int[] s: SHIFT){
			Coordinates next = new Coordinates(curr.x+s[0], curr.y+s[1]);
			if(isFeasible(next, maze)){
				maze.get(next.x).set(next.y, Color.BLACK);
				path.add(next);
				if(searchMazeHelper(maze,next,e,path)){
					return true;
				}
				path.remove(path.size()-1);
			}
		}
		return false;
	}
	
	public static boolean isFeasible(Coordinates next, List<List<Color>> maze){
		if(next.x >= 0 && next.x < maze.size() && next.y >= 0 && next.y < maze.get(next.x).size()
				&& maze.get(next.x).get(next.y) == Color.WHITE)
			return true;
		return false;
			
	}
}
