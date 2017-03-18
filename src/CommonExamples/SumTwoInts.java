package CommonExamples;

public class SumTwoInts {
	
	public int sum(int a, int b){
		if(b == a){
			return a;
		}
		
		int pSum = a ^ b;
		int carry = (a & b) << 1;
		return sum(pSum, carry);
	}

}
