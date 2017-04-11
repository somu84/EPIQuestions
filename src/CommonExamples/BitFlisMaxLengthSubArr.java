package CommonExamples;

public class BitFlisMaxLengthSubArr {
	public static int getMaxLen(int[] arr, int k){
		int wL = 0, wR = 0;
		int n = 0;
		int maxLen = 0;
		int maxWL = 0, maxWR = 0;
		if(arr[wR] == 0) n =1;
		while(wR < arr.length-1){
			if(n <= k){
				wR++;
				if(arr[wR] == 0) n++;
			}
			if(n > k){
				if(arr[wL] == 0) n--;
				wL++;
			}
			
			if((wR - wL) > maxLen){
				maxLen = wR - wL;
				maxWL = wL;
				maxWR = wR;
			}
		}
		int oneC = 0;
		for(int i = 0; i<maxWL; i++){
			if(arr[i] == 1) oneC++;
		}
		for(int i = maxWR+1; i<arr.length; i++){
			if(arr[i] == 1) oneC++;
		}
		if(oneC >= k)
			return maxLen;
		else{
			return (maxLen - (k - oneC));
		}
	}
	
	public static void main(String[] args){
		int[] arr= {0, 1, 1, 0, 0, 1, 0, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0};
		System.out.println(getMaxLen(arr, 3));
	}

}
