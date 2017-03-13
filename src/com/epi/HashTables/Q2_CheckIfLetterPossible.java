package com.epi.HashTables;

import java.util.HashMap;
import java.util.Map;

public class Q2_CheckIfLetterPossible {
	public static boolean checkIfPossible(String letter, String mag){
		Map<Character, Integer> wC = new HashMap<>();
		for(int i=0; i<mag.length(); i++){
			if(wC.containsKey(mag.charAt(i))){
				wC.put(mag.charAt(i), wC.get(mag.charAt(i))+1);
			}else{
				wC.put(mag.charAt(i), 1);
			}
		}
		
		for(int i=0; i<letter.length(); i++){
			if(!wC.containsKey(letter.charAt(i))){
				return false;
			}
			wC.put(letter.charAt(i), wC.get(letter.charAt(i)-1));
			if(wC.get(letter.charAt(i))<= 0){
				wC.remove(letter.charAt(i));
			}
		}
		return true;
	}

}
