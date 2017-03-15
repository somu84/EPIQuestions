package com.epi.StacksNQs;

import java.util.Deque;
import java.util.LinkedList;

public class Q2_RPN_Expression {
	public static int eval_rpn(String expr){
		String[] exprArr = expr.split(",");
		Deque<Integer> interim = new LinkedList<>();
		for(String op: exprArr){
			if(op.length() == 1 && "+-*/".contains(op)){
				int a = interim.removeFirst();
				int b = interim.removeFirst();
				int c = 0; 
				switch(op.charAt(0)){
				case '+':
					c = a+b;
					break;
				case '-':
					c = b -a;
					break;
				case '*':
					c = b*a;
					break;
				case '/':
					c = b/a;
					break;
				}
				interim.push(c);
			}
			else{
				int a = Integer.parseInt(op);
				interim.push(a);
			}
		}
		return interim.removeFirst();
	}
	
	public static void main(String[] args){
		System.out.println(eval_rpn("3,4,+,2,*,1,+"));
	}

}
