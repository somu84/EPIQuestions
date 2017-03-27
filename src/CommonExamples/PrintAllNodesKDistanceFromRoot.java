package CommonExamples;

public class PrintAllNodesKDistanceFromRoot {
	static class Tree{
		Tree left;
		Tree right;
		int data;
		
		Tree(int d){
			this.data = d;
		}
	}
	
	public static void printKNodes(Tree root, int k){
		if(root == null) return;
		if(k == 0){
			System.out.print(root.data+" ");
			return;
		}
		printKNodes(root.left, k-1);
		printKNodes(root.right, k-1);
	}
	
	public static void main(String[] args){
		Tree root = new Tree(1);
		root.left = new Tree(2);
		root.left.left = new Tree(4);
		root.left.right = new Tree(5);
		root.right = new Tree(3);
		root.right.left = new Tree(8);
		
		printKNodes(root, 2);
	}

}
