package BST;

import BinaryTrees.BinaryTree;

public class BST {

	private BinaryTree<Integer> root;
	private int size;
	private static boolean delete;
	
	private static boolean isPresentHelper(BinaryTree<Integer> root, int x) {
		if(root==null) {
			return false;
		}
		
		if(root.data==x) {
			return true;
		}
		
		if(x<root.data) {			
			return isPresentHelper(root.left, x);
		}else {
			return isPresentHelper(root.right, x);
		}
		
	}
	
	public boolean isPresent(int x) {
		return isPresentHelper(root, x);
		
//		if(root == null) {
//			return false;
//		}
//		
//		while (root!=null) {
//			if(root.data==x) {
//				return true;
//			}else if(x<root.data) {
//				root=root.left;
//			}else {
//				root = root.right;
//			}	
//		}
//		
//		return false;
		
		
	}
	
	
	private static BinaryTree<Integer> insertHelper (BinaryTree<Integer> root, int data){
        if(root==null){
        	BinaryTree<Integer> newNode = new BinaryTree<Integer>(data);
            
            return newNode;
        }
        
        
        if(root.data <= data){
        	root.right = insertHelper(root.right, data);
        }else{
        	root.left=insertHelper(root.left, data);
        }
       
        return root;
    }
	
	public void insert (int x) {
		root = insertHelper(root, x);
		size++;
	} 
	
	private static int getMinimum(BinaryTree<Integer> root, int min) {
		if(root==null) {
			return min;
		}
		
		if(root.data < min) {
			min = root.data;
		}
		int left = getMinimum(root.left, min);
		int right = getMinimum(root.right, min);
		return Math.min(left, right);
	}
	
	private static BinaryTree<Integer> deletedataHelper(BinaryTree<Integer> root, int x){
		if(root==null) {
			delete = false;
			return null;
		}
		if(x<root.data) {
			root.left= deletedataHelper(root.left, x);
			return root;
			
		}
		
		
		if(x>root.data){
			root.right = deletedataHelper(root.right, x);
		}	
		
		if(root.data == x) {
			if(root.left==null && root.right ==null) {
				delete = true;
				return null;
			}else if(root.left==null && root.right!=null) {
				delete = true;
				root = root.right;
			}else if(root.left!=null && root.right==null) {
				delete = true;
				root = root.left;
			}else if(root.left!=null && root.right!=null) {
				int min = getMinimum(root.right, Integer.MAX_VALUE);
				root.data= min;
				root.right = deletedataHelper(root.right, min);
				delete=true;
			}
			
		}
		return root;
		
	}
	
	public boolean deleteData (int x) {
		
		root = deletedataHelper(root, x);
		return delete;
	}
	
	public int size() {
		return size;
	}
	
	private static void printTreeHelper(BinaryTree<Integer> node) {
		if (node == null) {
			return;
		}
		System.out.print(node.data +":");
		
		if(node.left!=null) {
			System.out.print("L" + node.left.data+ ",");
		}
		if(node.right !=null) {
			System.out.print("R" + node.right.data);
		}
		System.out.println();
		printTreeHelper(node.left);
		printTreeHelper(node.right);
	}
	
	public void printTree() {
		printTreeHelper(root);
		
	}
}
