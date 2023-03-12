package BST;

public class BSTUse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BST b = new BST();
		b.insert(4);
		b.insert(4);
		b.insert(4);
		b.insert(4);
		b.printTree();
	
		System.out.println(b.deleteData(4));
		b.printTree();

	}

}
