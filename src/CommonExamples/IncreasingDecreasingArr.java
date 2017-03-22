package CommonExamples;

public class IncreasingDecreasingArr {
	public static int getMax(int[] arr, int r, int l){
	    if(arr.length == 0){
	        return -1;
	    }
	    if(l==r){
	        return arr[r];
	    }
	    if(r-l == 1){
	        return Math.max(arr[l], arr[r]);
	    }
	    int mid = l + (r -l)/2;
	    
	    if(arr[mid] > arr[mid+1] && arr[mid] > arr[mid-1]){
	        return arr[mid];
	    }
	    else{
	        if(arr[mid] < arr[mid -1]){
	            r = mid-1;
	        }
	        else if(arr[mid]<arr[mid+1]){
	            l = mid;
	        }
	        return getMax(arr,r, l);
	    }
	 }
	
	public static void main(String[] args){
		int[] arr = {3,2,1};
		System.out.println(getMax(arr, arr.length-1, 0));
	}
}
