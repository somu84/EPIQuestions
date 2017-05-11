package CommonExamples;

import java.util.*;


public class ParenthesisMatch {
	static class Elem{
		Character c;
		int ind;
		
		Elem(Character c, int i){
			this.c = c;
			this.ind = i;
		}
	}
	public static String matchPar(String str){
		char[] arr = str.toCharArray();
		Stack<Elem> st = new Stack<>();
		for(int i = 0; i<arr.length; i++){
			if(arr[i] == '('){
				st.push(new Elem(arr[i], i));
			}else if(arr[i] == ')' && st.isEmpty()){
				arr[i] = '0';
			}
			else{
				st.pop();
			}
		}
		while(!st.isEmpty()){
			int i = st.pop().ind;
			arr[i] = '0';
		}
		StringBuilder temp = new StringBuilder();
		for(int i=0; i<arr.length; i++){
			if(arr[i] == '0') continue;
			temp.append(arr[i]);
		}
		return temp.toString();
	}
	
	public static void main(String[] args){
		String str = ")()(()())))()((())((";
		System.out.println(matchPar(str));
	}
	

}
