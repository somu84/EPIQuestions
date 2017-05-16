package CommonExamples;

import java.util.*;

/**
 * Word Boggle Problem:
 * Given a dictionary, a method to do lookup in dictionary and a M x N 
 * board where every cell has one character. 
 * Find all possible words that can be formed by a 
 * sequence of adjacent characters. 
 * Note that we can move to any of 8 adjacent characters, 
 * but a word should not have multiple instances of same cell.
 * @author Somu
 *
 */
public class BoggleProblem {
	static class Trie{
		HashMap<Character, Trie> children;
		boolean isWord;
		Trie(){
			children = new HashMap<>();
			isWord = false;
		}
		public static final Trie root = new Trie();
		
		void addWord(String str){
			Trie curr = root;
			for(int i = 0; i < str.length(); i++){
				Character c = str.charAt(i);
				Trie n = curr.children.get(c);
				if(n == null){
					n = new Trie();
					curr.children.put(c, n);
				}
				curr = n;
			}
			curr.isWord = true;
		}
	}
	
	static List<String> boggle(char[][]arr, Set<String> dict){
		for(String str: dict){
			Trie.root.addWord(str);
		}
		boolean[][]v = new boolean[arr.length][arr[0].length];
		List<String> res = new ArrayList<>();
		for(int i = 0; i< arr.length; i++){
			for(int j = 0; j<arr[i].length; j++){
				DFS(arr, v, i, j, Trie.root, "", res);
			}
		}
		return res;
	}
	
	static void DFS(char[][]arr, boolean[][]v, int i, int j, Trie curr, String temp, List<String> res){
		if(i<0 || j<0 || i==arr.length || j == arr[i].length || v[i][j] == true ||
				!curr.children.containsKey(arr[i][j]))
			return;
		v[i][j] = true;
		Trie t = curr.children.get(arr[i][j]);
		if(t.isWord){
			res.add(temp+arr[i][j]);
			return;
		}
		final int[][] SHIFT = {{0,1},{0,-1},{1,0},{-1,0},{-1,-1},{1,1},{-1,1},{1,-1}};
		for(int[]l:SHIFT){
			DFS(arr, v, i+l[0], j+l[1], t, temp+arr[i][j],res);
		}
	}

	public static void main(String[] args){
		Set<String> dict = new HashSet<>();
		dict.add("geeks");
		dict.add("for");
		dict.add("quiz");
		dict.add("go");
		//dict.add("CAT");
		char[][] arr = {   {'g','i','z'},
                           {'u','e','k'},
                           {'q','s','e'}};
		/*char[][]arr = {
				{'C','A','P'},
				{'A','N','D'},
				{'T','I','E'}
				};*/
		List<String> list = boggle(arr, dict);
		System.out.println(list);
	}
}
