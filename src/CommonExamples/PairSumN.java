package CommonExamples;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class PairSumN {

	public static List<Integer> pairSum(List<Integer> a, List<Integer> b, int sum){
		HashSet<Integer> arr = new HashSet<>();
		List<Integer> res = new ArrayList<>();
		getSum(a, arr, sum, res);
		if(res.isEmpty()){
			getSum(b, arr, sum, res);
		}
		return res;
	}
	
	private static void getSum(List<Integer> a, HashSet<Integer> arr, int sum, List<Integer> res){
		for(int i:a){
			if(arr.contains(sum-i)){
				res.add(i);
				res.add(sum-i);
				return;
			}
			arr.add(i);
		}
		return;
	}
}
