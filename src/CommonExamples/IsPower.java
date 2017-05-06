package CommonExamples;

public class IsPower {
	public static boolean isPower(int a) {
        if(a == 1) return true;
        for(int i = 2; i <= a / 2; i++){
            int j = 2;
            while(true){
                int p = (int)Math.pow(i, j);
                if(p == a) return true;
                if(p > a) break;
                j++;
            }
        }
        return false;
    }
	
	public static void main(String[] args){
		System.out.println(isPower(27));
	}

}
