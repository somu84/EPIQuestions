package com.epi.Graphs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Coordinate {
	int x;
	int y;

	Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Q2_BooleanMatirx {
	//Flip Color using BFS
	public void FlipColorBFS(List<List<Boolean>> A, int x, int y) {
		boolean color = A.get(x).get(y);
		final int[][] SHIFT = { { 0, 1, }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
		Queue<Coordinate> next = new LinkedList<Coordinate>();
		// Flip color
		A.get(x).set(y, !A.get(x).get(y));
		next.add(new Coordinate(x, y));
		while (!next.isEmpty()) {
			Coordinate curr = next.peek();
			for (int[] dir : SHIFT) {
				Coordinate newC = new Coordinate(curr.x + dir[0], curr.y + dir[1]);
				if (newC.x >= 0 && newC.x < A.size() && newC.y >= 0 && newC.y < A.get(newC.x).size()
						&& A.get(newC.x).get(newC.y) == color) {
					// Flip Color
					A.get(newC.x).set(newC.y, !A.get(newC.x).get(newC.y));
					next.add(newC);
				}
			}
			next.remove();
		}
	}

	//Flip color using DFS
	public void FlipColorDFS(List<List<Boolean>> A, int x, int y) {
		boolean color = A.get(x).get(y);
		final int[][] SHIFT = { { 0, 1, }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
		for (int[] dir : SHIFT) {
			int nextX = x + dir[0];
			int nextY = y + dir[1];
			if (nextX >= 0 && nextX < A.size() && nextY >= 0 && nextY < A.get(nextX).size()
					&& A.get(nextX).get(nextY) == color) {
				// Flip Color
				A.get(nextX).set(nextY, !A.get(nextX).get(nextY));
				// Recurse
				FlipColorDFS(A, nextX, nextY);
			}
		}
		return;
	}
}
