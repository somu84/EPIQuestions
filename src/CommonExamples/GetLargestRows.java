package CommonExamples;

import java.util.*;

public class GetLargestRows {
	
	public static List<List<Integer>> getAnswer(int[][] arr){
		int maxCount = 0;
		int colLength = arr[0].length -1;
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < arr.length; i++){
			int j = arr[i].length-1;
			while(arr[i][j] != 0){
				j--;
			}
			int currL = colLength - j;
			map.put(i, currL);
			if(maxCount < currL ){
				maxCount = currL;
			}
		}
		List<List<Integer>> res = new ArrayList<>();
		for(Map.Entry<Integer, Integer> e: map.entrySet()){
			if(e.getValue() == maxCount){
				List<Integer> t = new ArrayList<>();
				t.add(e.getKey()+1);
				t.add(maxCount);
				res.add(t); 
			}
		}
		return res;
	}
	
	
	public static String run(int[][] src) {
        StringBuilder s = new StringBuilder();
        int len = src[0].length;
        boolean zeroFound = false;
        for(int col = 0 ; col < len && !zeroFound; col ++) {
            for(int row = 0; row < src.length; row++) {
                if(src[row][col] == 1) {
                    zeroFound = true;
                    s.append("[").append(row + 1).append(",").append(len - col).append("]");
                }
            }
        }
        return s.toString();
    }
	
	public static void main(String[] args){
		int[][] arr = {{0,0,0,0,0,0,0,1,1,1,1,1},
				       {0,0,0,0,1,1,1,1,1,1,1,1},
				       {0,0,0,0,0,0,1,1,1,1,1,1},
				       {0,0,0,0,0,0,0,0,0,1,1,1},
				       {0,0,0,0,0,0,0,1,1,1,1,1},
				       {0,0,0,0,1,1,1,1,1,1,1,1}};
		System.out.println(getAnswer(arr));
		System.out.println(run(arr));
	}
	

}
