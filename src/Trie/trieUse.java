package Trie;


public class trieUse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Trie t = new Trie();
		
		t.add("NOTE");
		t.add("NOT");
		t.add("AND");
		System.out.println("Search: " + t.search("NOT")); 
		System.out.println("Search: " + t.search("AND")); 
		t.remove("AND");
		System.out.println("After removal Search: " + t.search("AND")); 
		t.add("AND");
		t.add("AND");
		t.add("AND");
		t.add("AND");
		t.add("AND");
		t.remove("AND");
		
		System.out.println(t.numWords);
		
	}

}
