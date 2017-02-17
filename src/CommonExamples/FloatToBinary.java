package CommonExamples;

public class FloatToBinary {

	public static void Convert(float num){
		int sim = (int)num;
		StringBuffer res = new StringBuffer(ConvertInt(sim));
		res.append(".");
		float rem = num - (float)(int)num;
		rem = rem*2;
		int mul = (int)rem;
		while(mul != 1){
			res.append(mul);
			rem = rem * 2;
			mul = (int)rem;
		}
		res.append(mul);
		System.out.println(res.toString());
	}
	
	public static String ConvertInt(int num){
		if(num < 2){
			return String.valueOf(num);
		}
		int rem = num%2;
		return ConvertInt(num/2)+String.valueOf(rem);
	}
	
	public static void main(String args[]){
		float n = 12.25f;
		Convert(n);
	}
}
