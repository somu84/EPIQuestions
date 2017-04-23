package com.epi.Strings;

import java.util.HashMap;

public class Extr_IsoMorphicStrings {
	public static boolean isoMorph(String str1, String str2){
		if(str1 == null || str2 == null || str1.length() == 0 || str2.length() == 0 || str1.length() != str2.length())
			return false;
		char[] a1 = str1.toCharArray();
		char[] a2 = str2.toCharArray();
		HashMap<Character, Character> map = new HashMap<>();
		int i = 0;
		while(i < a1.length){
			if(map.containsKey(a1[i])){
				if(a2[i] != map.get(a1[i]))
					return false;
			}else{
				map.put(a1[i], a2[i]);
			}
			i++;
		}
		return true;
	}
	
	public static void main(String[] args){
		System.out.println(isoMorph(null, "bar"));
	}

}
