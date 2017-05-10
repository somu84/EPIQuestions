package CommonExamples;

import java.util.Stack;

public class DropParantheses {
	static class Elem{
	 	Character c;
	 	int ind;

	 	Elem(Character c, int ind){
	 		this.c = c;
	 		this.ind = ind;
	 	}
	 }

	 public static String dropBraces(String str){
	 	if(str == null || str.length() == 0) return str;

	 	Stack<Elem> stack = new Stack<>();
	 	char[]arr = str.toCharArray();
	 	for(int i = 0; i < arr.length; i++){
	 		if(arr[i] == '('){
	 			stack.push(new Elem('(', i));
	 		}else if(stack.isEmpty()){
	 			arr[i] = '0';
	 		}else{
	 			stack.pop();
	 		}
	 	}
	 	while(!stack.isEmpty()){
	 		int i = stack.pop().ind;
	 		arr[i] = '0';
	 	}
	 	StringBuilder temp = new StringBuilder();
	 	for(int i = 0; i<arr.length; i++){
	 		if(arr[i] == '0') continue;
	 		temp.append(arr[i]);
	 	}
	 	return temp.toString();
	 }
	 
	 public static void main(String[] args){
		 String str = ")(()(()))()))";
		 System.out.println(dropBraces(str));
	 }

}
