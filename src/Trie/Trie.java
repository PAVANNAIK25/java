package Trie;


class TrieNode{
	char data;
	boolean isTerminal;
	TrieNode children[];
	int childCount;
	
	public TrieNode(char data) {
		// TODO Auto-generated constructor stub
		this.data = data;
		this.isTerminal = false;
		this.children = new TrieNode[26];
	}
}

public class Trie {

	private TrieNode root;
	public int numWords;
	
	public Trie() {
		// TODO Auto-generated constructor stub
		root = new TrieNode('\0');
	}
	
	private void addHelper(String word, TrieNode root) {
		if(word.length()==0) {
			root.isTerminal=true;
			return;
		}
		int childIndex = word.charAt(0) - 'A';
		TrieNode child = root.children[childIndex];
		if(child ==null) {
			child = new TrieNode(word.charAt(0));
			root.children[childIndex]= child;
			root.childCount++;
		}
		addHelper(word.substring(1), child);
	}
	
	public void add (String word) {	
		addHelper(word, root);
		numWords++;
	}
	
	private boolean searchHelper(String word, TrieNode root) {
		if(word.length()==0) {
			if(root.isTerminal) {
				return true;
			}else {
				return false;
			}
	
		}
		
		int childIndex = word.charAt(0)-'A';
		TrieNode child = root.children[childIndex];
		if(child==null) {
			return false;
		}
		return searchHelper(word.substring(1), child);
		
	}
	
	public boolean search(String word) {
		return searchHelper(word, root);
	} 
	
	private void removeHelper(String word, TrieNode root) {
		
		if(word.length()==0) {
			root.isTerminal=false;
			return;
		}
		
		int childIndex = word.charAt(0)-'A';
		TrieNode child = root.children[childIndex];
		if(child == null) {
			return;
		}
		removeHelper(word.substring(1), child);
		if(!root.isTerminal&& root.childCount==0) {
			root.children[childIndex]=null;
			root.childCount--;
		}
		
	}
	
	public void remove(String word) {
		removeHelper(word, root);
		numWords--;
	}
	
}
