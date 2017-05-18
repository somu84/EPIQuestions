package CommonExamples;

public class Extr_MinSizeSubArrSum {
	/**
	 * https://leetcode.com/problems/minimum-size-subarray-sum/#/description
	 * TimeComplexity: O(n)
	 * Space : O(1)
	 * @param s
	 * @param nums
	 * @return
	 */
	public int minSubArrayLen(int s, int[] nums) {
        if(nums.length == 0) return 0;
        if(s == 0) return 0;
        int i = 0, j = 0;
        int sum = nums[0];
        int min = Integer.MAX_VALUE;
        while(i < nums.length && j < nums.length){
            if(sum < s){
                j++;
                if(j < nums.length){
                    sum += nums[j];
                }
            }else if(sum >= s){
                int c = j - i+1;
                if(c < min){
                    min = c;
                }
                sum -= nums[i];
                i++;
            }
        }
        if(min == Integer.MAX_VALUE) return 0;
        return min;
    }
	

}
