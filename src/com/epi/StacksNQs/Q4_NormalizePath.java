package com.epi.StacksNQs;

import java.util.*;

public class Q4_NormalizePath {
	public static String normalize(String path){
		if(path == null || path.length() == 0) return path;
		Stack<String> stack = new Stack<>();
		String[] arr = path.split("/");
		for(int i = 1; i < arr.length; i++){
			if(arr[i].equals("") || arr[i].equals("."))
				continue;
			else if(arr[i].equals("..")){
				if(!stack.isEmpty())
					stack.pop();
			}
			else{
				stack.push(arr[i]);
			}
		}
		String res = "";
		while(!stack.isEmpty()){
			res = "/"+stack.pop()+res;
		}
		return res.isEmpty() ? "/" : res;
	}
	
	public static void main(String[] args){
		String str = "/...";
		System.out.println(normalize(str));
		String str1 = "/scripts//./../scripts/awk";
		System.out.println(normalize(str1));
	}

}
