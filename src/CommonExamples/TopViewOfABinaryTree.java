package CommonExamples;

import java.util.ArrayList;
import java.util.List;

public class TopViewOfABinaryTree {
	static class Tree{
		Tree left;
		Tree right;
		int data;
	}
	
	public static List<Integer> getTop(Tree root){
		if(root == null)
			return null;
		List<Integer> res = new ArrayList<>();
		
		Tree curr = root;
		while(curr != null){
			res.add(0,curr.data);
			curr = curr.left;
		}
		curr = root.right;
		while(curr != null){
			res.add(curr.data);
			curr = curr.right;
		}
		return res;
	}

}
