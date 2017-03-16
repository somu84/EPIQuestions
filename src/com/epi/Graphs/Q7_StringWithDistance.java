package com.epi.Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Q7_StringWithDistance {
	static class StringWithD{
		String candidate;
		int distance;
		
		StringWithD(String cS, int d){
			this.candidate = cS;
			this.distance = d;
		}
	}
	
	public static int transForm(Set<String> dict, String s, String e){
		Queue<StringWithD> q = new LinkedList<>();
		dict.remove(s);
		q.add(new StringWithD(s, 0));
		StringWithD f;
		while(!q.isEmpty()){
			f= q.poll();
			if(f.candidate.equals(e)){
				return f.distance;
			}
			String str = f.candidate;
			for(int i=0; i<str.length(); i++){
				String start = i==0?"":str.substring(0, i);
				String end = i+1 < str.length()?str.substring(i+1):"";
				for(int j=0; j<26;j++){
					String modStr = start+(char)('a'+j)+end;
					if(dict.remove(modStr)){
						q.add(new StringWithD(modStr, f.distance+1));
					}
				}
			}
		}
		return -1;
	}
	
	//Get the actual strings
	public static List<String> transForm1(Set<String> dict, String s, String e){
		Queue<String> q = new LinkedList<>();
		Map<String,String>prev = new HashMap<>();
		q.add(s);
		while(!q.isEmpty()){
			String str = q.poll();
			if(!dict.contains(str)){
				continue;
			}
			dict.remove(str);
			if(str.equals(e)){
				List<String> res = new ArrayList<>();
				res.add(e);
				while(str!= null){
					res.add(0,str);
					str = prev.get(str);
				}
				return res;
			}
			List<String> nextWords = getOneWordEdit(str);
			for(String next: nextWords){
				if(dict.contains(next)){
					prev.put(next, str);
					q.add(next);
				}
			}
		}
		return null;
	}
	
	public static List<String> getOneWordEdit(String str){
		List<String> res = new ArrayList<>();
		for(int i = 0 ; i<str.length(); i++){
			String st = i==0?"":str.substring(0, i);
			String end = i+1<str.length()?str.substring(i+1):"";
			for(int j=0; j<=26;j++){
				String modStr = st+(char)('a'+j)+end;
				res.add(modStr);
			}
		}
		return res;
	}

}
