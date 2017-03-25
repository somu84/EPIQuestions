package com.epi.StacksNQs;

import java.util.*;

public class Q3_CheckParantheses {
	public static boolean checkBalance(String str){
		if(str.length() == 0){
			return true;
		}
		Deque<Character> stack = new LinkedList<>();
		for(int i=0; i<str.length(); i++){
			char c = str.charAt(i);
			if(c == '(' || c == '{' || c == '['){
				stack.push(c);
			}
			else{
				if(stack.isEmpty()){
					return false;
				}
				else if((c == ')' && stack.peekFirst() != '(')
						||(c == '}' && stack.peekFirst() != '{')
						||(c == ']' && stack.peekFirst()!= '[')){
					return false;
				}
				stack.pop();
			}
		}
		return stack.isEmpty();
	}

}
