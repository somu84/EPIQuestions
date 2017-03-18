package CommonExamples;

import java.util.ArrayList;
import java.util.List;

public class RootToLeafSum {
	static class BinaryTree{
		BinaryTree left;
		BinaryTree right;
		int data;
		
		BinaryTree(int d){
			this.data = d;
		}
		
	}
	
	public static void findSum(BinaryTree root, int sum){
		List<Integer> path = new ArrayList<>();
		if(findSumHelp(root, sum, path)){
			for(int a: path){
				System.out.print(a+" ,");
			}
		}
	}
	
	public static boolean findSumHelp(BinaryTree root, int sum, List<Integer> path){
		if(root.left == null && root.right == null){
			if(root.data != sum){
				return false;
			}
			else{
				path.add(root.data);
				return true;
			}
		}
		if(findSumHelp(root.left, sum-root.data, path) || findSumHelp(root.right, sum-root.data, path)){
			path.add(root.data);
			return true;
		}
		return false;
	}

}
