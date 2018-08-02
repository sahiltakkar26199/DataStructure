package trie_ds;

import java.util.HashMap;

public class TrieNode {
	char ch;
	HashMap<Character, TrieNode> children ;
	boolean isWord;
	
	TrieNode(char ch){
		this.ch = ch;
		children = new HashMap<>();
	}
}
