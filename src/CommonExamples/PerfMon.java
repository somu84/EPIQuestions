package CommonExamples;

import java.util.*;

public class PerfMon {
	public static int getTime(String log, String fun){
		if(log == null || log.length() == 0){
			return -1;
		}
	    Deque<String> stack = new LinkedList<>();
	    String[] arr = log.split("\n");
	    int currTime = 0;
	    int lastTime = 0;
	    for(String str: arr){
	        String[] st = str.split(" ");
	        int time = getTime(st[0]);
	        if(st[1].equals("start"))
	        {
	            if(st[2].equals(fun)){
	                lastTime = time;
	            }
	            if(!st[2].equals(fun)){
	                if(stack.peek().equals(fun)){
	                    currTime += time - lastTime;
	                }
	            }
	            stack.push(st[2]);
	        }
	        else if(st[1].equals("end")){
	            String t = stack.pop();
	            if(t.equals(fun)){
	                   currTime = currTime + time - lastTime;
	                   return currTime;
	            }
	            else{
	                if(stack.peek().equals(fun)){
	                    lastTime = time;
	                }
	            }
	        }        
	    }
	    return -1;
	}
	
	public static int getTime(String str){
		return Integer.parseInt(str);
	}
	
	public static void main(String[] args){
		StringBuilder str = new StringBuilder();
		str.append("10 start fun\n");
		str.append("20 start f1\n");
		str.append("22 end f1\n");
		str.append("30 start f2\n");
		str.append("31 start f3\n");
		str.append("32 end f3\n");
		str.append("33 end f2\n");
		str.append("40 end fun\n");
		
		System.out.println(getTime(str.toString(), "fun"));
		
	}

}
