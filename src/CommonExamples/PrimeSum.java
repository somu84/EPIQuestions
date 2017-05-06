package CommonExamples;

import java.util.*;

public class PrimeSum {
	public static ArrayList<Integer> primesum(int a) {
        ArrayList<Integer> res = new ArrayList<>();
        for(int i = 2; i < a; i++){
        	if(i == 2){
        		if(checkPrime(a - i)){
        			res.add(i);
        			res.add(a - i);
        			return res;
        		}
        	}else{
        		if(checkPrime(i) && checkPrime(a -i)){
        			res.add(i);
        			res.add(a - i);
        			return res;
        		}
        	}
        }
        return res;
    }
    public static boolean checkPrime(int n){
        if(n == 2) return true;
        int c = (int)Math.sqrt(n);
        for(int i = 2; i <= c+1; i++){
            if(n % i == 0) return false;
        }
        return true;
    }
    
    public static void main(String[] args){
    	System.out.println(primesum(10));
    }

}
