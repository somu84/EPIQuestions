package CommonExamples;

public class CountNumberOfIslands {
	
	public static int getCount(int[][] arr){
		int count = 0;
		boolean[][] visited = new boolean[arr.length][arr[0].length];
		for(int i = 0; i< arr.length; i++){
			for(int j = 0; j < arr[i].length; j++){
				if(arr[i][j] == 1 && !visited[i][j]){
					DFS(arr, visited, i, j);
					count++;
				}
			}
		}
		return count;
	}

	private static void DFS(int[][] arr, boolean[][] v, int i, int j){
		if(i < 0 || j < 0 || i>= arr.length || j >= arr[i].length || v[i][j] == true || arr[i][j] == 0)
			return;
		v[i][j] = true;
		final int[][] SHIFT = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
		for(int[] a: SHIFT){
			DFS(arr, v, i+a[0], j+a[1]);
		}
	}
	
	public static void main(String[] args){
		int[][] arr = {{0, 0, 0, 1},
					   {1, 0, 0, 1},
					   {0, 0, 1, 0},
					   {1, 0, 0, 0}};
		
		System.out.println(getCount(arr));
	}

}
