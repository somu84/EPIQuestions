package com.epi.Recursion;

public class Q1_TowersOfHanoi {
	
	public static void print(String fr, String to){
		System.out.println("Move ring from "+fr+"to "+to);
	}
	
	//Recursive Solution 
	public static void Towers(int n, String fr, String to, String sp){
		if(n == 1){
			print(fr, to);
			return;
		}
		Towers(n-1, fr, sp, to);
		Towers(1, fr, to, sp);
		Towers(n-1, sp, to, fr);
	}
	
	//Non-recursive solution
	/**
	 * 	1. Calculate the total number of moves required i.e. "pow(2, n)
   			- 1" here n is number of disks.
	   	2. If number of disks (i.e. n) is even then interchange destination 
   			pole and auxiliary pole.
	   	3. for i = 1 to total number of moves:
     		if i%3 == 1:
				legal movement of top disk between source pole and 
        		destination pole
     		if i%3 == 2:
				legal movement top disk between source pole and 
        		auxiliary pole	
     		if i%3 == 0:
        		legal movement top disk between auxiliary pole 
        	and destination pole 
	 * @param n
	 * @param fr
	 * @param to
	 * @param sp
	 */
	public static void nonRecTowers(int n, String fr, String to, String sp){
		double totalMoves = Math.pow(n, 2)-1;
		if(n%2 == 0){
			String tmp = sp;
			sp = to;
			to = tmp;
		}
		for(double i=1; i<=totalMoves; i++){
			if(i%3 == 1){
				print(fr, to);
			}
			else if(i%3 == 2){
				print(fr, sp);
			}
			else if(i%3 == 0){
				print(sp, to);
			}
		}
	}

}
