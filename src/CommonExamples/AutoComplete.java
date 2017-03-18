package CommonExamples;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AutoComplete {
	static class Node{
		Map<Character, Node> children;
		boolean isEndOfWord;
		/**
		 * 
		 * @param c
		 */
		Node(Character c){
			this.children = new HashMap<>();
			this.children.put(c, null);
			this.isEndOfWord = false;
		}
		
		/**
		 * 
		 */
		Node(){
			this.children = new HashMap<>();
			this.isEndOfWord = false;
		}
		
		public final Node root = new Node();
		
		
		/**
		 * Method to insert a word, to the dictionary
		 * @param word
		 */
		public void add(String word){
			Node curr = root;
			for(int i=0; i<word.length(); i++){
				Character c = word.charAt(i);
				Node child = curr.children.get(c);
				if(child == null){
					child = new Node(c);
				}
				curr = child;
			}
			curr.isEndOfWord = true;
		}
		
		public List<String> getAllDisctWords(String prefix){
			List<String> res = new ArrayList<>();
			return getAllWords(prefix, root, res);
		}
		
		private List<String> getAllWords(String prefix,  Node trie, List<String> res){
			Node curr = trie;
			for(int i=0; i<prefix.length(); i++){
				Character c = prefix.charAt(i);
				Node child = curr.children.get(c);
				if(child == null){
					return null;
				}
				curr = child;
			}
			getAllWords(curr, prefix, res);
			return res;
		}
		
		private void getAllWords(Node curr, String currS, List<String> res){
			if(curr == null){
				return;
			}
			if(curr.isEndOfWord){
				res.add(currS);
			}
			for(Map.Entry<Character, Node> e: curr.children.entrySet()){
				String temp = currS+e.getKey();
				getAllWords(e.getValue(), temp, res);
			}
			return;		
		}
		
	}

}
