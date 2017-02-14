package CommonExamples;
/**
 * Given an integer, count the number of bits, that are 1's in the integer.
 * @author Somu
 *
 */
public class NumberOf1s {
	/**
	 * The operation (x AND (complement of (x -1))) sets the all the bits to 0 except for the rightmost
	 * bit, which was 1.
	 * 
	 * MEMORIZE that X & ~(X - 1) sets only the right most 1 to 1 and all other bits to 0.
	 * @param x
	 * @return
	 */
	public static int count1(int x){
		int y = x & ~(x -1);
		int cnt = 0;
		while(x != 0){
			x = (x ^ y);
			y = x & ~(x -1);
			cnt++;
		}
		return cnt;
	}
	
	public static void main(String[] args){
		int x = 100;
		System.out.println("Number of 1s :"+count1(x));
	}

}
