package com.epi.Graphs;

import java.util.*;

public class LeetCode_SurroundedRegion {
	public static void solve(char[][] board) {
        if(board.length == 0) return;
        boolean[][]T = new boolean[board.length][board[0].length];
        for(int i = 0; i<board.length; i++){
            if(board[i][0] == 'O' && T[i][0] == false){
                DFS(board, T, i, 0);
            }
        }
        for(int i = 0; i<board.length; i++){
            if(board[i][board[i].length-1] == 'O' && T[i][T[i].length -1] == false){
                DFS(board, T, i, T[i].length-1);
            }
        }
        for(int i = 1; i<board[0].length - 1; i++){
            if(board[0][i] == 'O' && T[0][i] == false){
                DFS(board, T, 0, i);
            }
        }
        for(int i = 1; i < board[board.length-1].length-1; i++){
            if(board[board.length-1][i] == 'O' &&
            T[T.length -1][i] == false){
                DFS(board, T, board.length-1, i);
            }
        }
        for(int i = 0; i<board.length; i++){
            for(int j = 0; j<board[i].length; j++){
                if(board[i][j] == 'O' && T[i][j] == false){
                    board[i][j] = 'X';
                }
            }
        }
    }
    
    private static void DFS(char[][]B, boolean[][]T, int i, int j){
        if(i < 0 || i >= B.length || j < 0 || j >= B[i].length ||
        T[i][j] == true || B[i][j] == 'X') return;
        T[i][j] = true;
        final int[][] SHIFT = {{1,0},{0,1},{-1,0},{0,-1}};
        for(int[]a : SHIFT){
            DFS(B, T, i+a[0], j+a[1]);        
        }
    }
    
    static class Element{
        int i;
        int j;
        public Element(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
    
    //BFS Solution more space efficient
    private static void BFS(char[][]B, boolean[][]T, int i, int j){
        Queue<Element> q = new LinkedList<>();
        q.offer(new Element(i, j));
        while(!q.isEmpty()){
            Element curr = q.remove();
            T[curr.i][curr.j] = true;
            final int[][] SHIFT = {{1,0},{0,1},{-1,0},{0,-1}};
            for(int[]a : SHIFT){
                if(isValid(B, T, curr.i+a[0], curr.j+a[1])){
                    q.offer(new Element(curr.i+a[0], curr.j+a[1]));
                }
            }
        }
    }
    
    private static boolean isValid(char[][]B, boolean[][]T, int i, int j){
        if(i < 0 || i >= B.length || j < 0 || j>= B[i].length || T[i][j] == true || B[i][j] == 'X')
            return false;
        return true;
    }
    
    public static void main(String[] args){
    	char[][] arr = {{'O','O','O','O','X','X'},
    					{'O','O','O','O','O','O'},
    					{'O','X','O','X','O','O'},
    					{'O','X','O','O','X','O'},
    					{'O','X','O','X','O','O'},
    					{'O','X','O','O','O','O'}};
    	solve(arr);
    }

}
