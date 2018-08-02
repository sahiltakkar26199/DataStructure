package trie_ds;

public class Trie_DS {

	TrieNode root;
	
	public Trie_DS() {
		this.root = new TrieNode('/');
	}

	public void addWord(String word, TrieNode root) {
		if(word.length()==0){
			root.isWord = true;
			return;
		}
		char currentChar = word.charAt(0);
		if(!root.children.containsKey(currentChar)){
			TrieNode nyaNode = new TrieNode(currentChar);
			root.children.put(currentChar,nyaNode);
		}		
		addWord(word.substring(1), root.children.get(currentChar));	
	}
	
	public boolean searchWord(String word, TrieNode root) {
		if(word.length()==0){
			if(root.isWord ){
				return true;
			}
			return false;
		}
			
		char currentChar = word.charAt(0);
		if(!root.children.containsKey(currentChar)){
			return false;
		}		
		return searchWord(word.substring(1), root.children.get(currentChar));	
	}
	
	
	public boolean removeWord(String word, TrieNode root) {
		if(word.length()==0){
			if(root.isWord ){
				root.isWord = false;
				return true;
			}
			return false;
		}
		char currentChar = word.charAt(0);
		if(!root.children.containsKey(currentChar)){
			return false;
		}	

		boolean smallAns = removeWord(word.substring(1), root.children.get(currentChar));	
		if(smallAns){
			TrieNode nextNode = root.children.get(currentChar);
			if(nextNode.children.size()==0&& !nextNode.isWord){
				root.children.remove(currentChar);
			}
		}
		return smallAns;
	}
	
	
	
	
	

	public void removeWord(String string) {
		// TODO Auto-generated method stub
		
	}

	
	
	
}
