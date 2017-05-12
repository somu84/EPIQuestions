package CommonExamples;

public class StringToInt {
	static int getDouble(String str){
	    if(str == null || str.length() == 0)
	        return 0;
	    int len = str.length();
	    int num = 0;
	    for(int i = 0; i<len; i++){
	        char c = str.charAt(i);
	        int t = c - '0';
	        num = num*10+t;
	    }
	    //System.out.println(num*2);
	    return num;
	}

	static void getDoubleDecimal(String str){
	    if(str == null || str.length() == 0)
	        return;
	    String[]arr = str.split("\\.");
	    int n1 = getDouble(arr[0]);
	    int n2 = getDouble(arr[1]);
	    int len = arr[1].length();
	    float frac = (float) (n2/Math.pow(10, len));
	    float res = (float)n1+frac;
	    System.out.println(res*2);
	    return;
	}

	public static void main(String[] args){
		getDoubleDecimal("226.0500");
	}
}
