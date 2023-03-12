package BinaryTrees;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class BinaryTreeUse {
	
	public static BinaryTree<Integer> takeInputLevel (){
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Root data: ");
		int rootData = sc.nextInt();
		
		if(rootData == -1) {
			return null;
		}
		
		BinaryTree<Integer> root = new BinaryTree<Integer>(rootData);
		Queue<BinaryTree<Integer>> pendingChildren = new LinkedList<BinaryTree<Integer>>();
		pendingChildren.add(root);
		
		while(!pendingChildren.isEmpty()) {
			
			BinaryTree<Integer> front = pendingChildren.poll();
			
			System.out.println("Enter the left child of " + front.data);
			int left = sc.nextInt();
			if(left!=-1) {
				BinaryTree<Integer> leftChild = new BinaryTree<Integer>(left);
				front.left=leftChild;
				pendingChildren.add(leftChild);
			}
			
			System.out.println("Enter the right child of " + front.data);
			int right = sc.nextInt();
			if(right!=-1) {
				BinaryTree<Integer> rightChild = new BinaryTree<Integer>(right);
				front.right = rightChild;
				pendingChildren.add(rightChild);
			}
			
		}
		
		return root;
	}
	
	public static boolean isBalance(BinaryTree<Integer> root) {
		if (root == null) {
			return true;
		}

		int leftHeight = height(root.left);
		int rightHeight = height(root.right);

		if (Math.abs(rightHeight - leftHeight) > 1) {
			return false;
		}

		boolean leftBalance = isBalance(root.left);
		boolean rightBalance = isBalance(root.right);

		return leftBalance && rightBalance;

	}

	static int height(BinaryTree<Integer> root) {
		if (root == null) {
			return 0;
		}

		int leftHeight = height(root.left);
		int rightHeight = height(root.right);

		return 1 + Math.max(leftHeight, rightHeight);

	}

	public static BinaryTree<Integer> removeLeaf(BinaryTree<Integer> root) {
		if (root == null) {

			return null;
		}

		if (root.right == null && root.left == null) {
			return null;
		}

		root.right = removeLeaf(root.right);
		root.left = removeLeaf(root.left);
		return root;

	}

	public static void printDepthKelem(BinaryTree<Integer> root, int k) {
		if (root == null) {
			return;
		}
		if (k == 0) {
			System.out.print(root.data + " ");
			return;
		}
		printDepthKelem(root.left, k - 1);
		printDepthKelem(root.right, k - 1);

	}

	public static int numOfLeafs(BinaryTree<Integer> root) {

		if (root == null) {
			return 0;
		}

		if (root.left == null && root.right == null) {
			return 1;
		}

		return numOfLeafs(root.left) + numOfLeafs(root.right);

	}

	public static BinaryTree<Integer> takeInputBetter(boolean isRoot, int parentdata, boolean isLeft) {

		if (isRoot) {
			System.out.println("Enter Root data");

		} else {
			if (isLeft) {
				System.out.println("Enter left data of " + parentdata);
			} else {
				System.out.println("Enter right data of " + parentdata);
			}
		}

		Scanner sc = new Scanner(System.in);
		int rootdata = sc.nextInt();
		if (rootdata == -1) {
			return null;
		}

		BinaryTree<Integer> root = new BinaryTree<Integer>(rootdata);

		BinaryTree<Integer> leftchild = takeInputBetter(false, rootdata, true);
		BinaryTree<Integer> rightchild = takeInputBetter(false, rootdata, false);
		root.left = leftchild;
		root.right = rightchild;
		return root;

	}

	public static BinaryTree<Integer> takeInput() {
		System.out.println("Enter Root data");
		Scanner sc = new Scanner(System.in);
		int rootdata = sc.nextInt();

		if (rootdata == -1) {
			return null;
		}

		BinaryTree<Integer> root = new BinaryTree<Integer>(rootdata);

		BinaryTree<Integer> leftchild = takeInput();
		BinaryTree<Integer> rightchild = takeInput();
		root.left = leftchild;
		root.right = rightchild;

		return root;

	}

	public static void printTreeDetailed(BinaryTree<Integer> root) {
		if (root == null) {
			return;
		}

		System.out.print(root.data + ":");

		if (root.left != null) {
			System.out.print("L" + root.left.data + ",");
		}
		if (root.right != null) {
			System.out.print("R" + root.right.data);
		}

		System.out.println();
		printTreeDetailed(root.left);
		printTreeDetailed(root.right);

	}

	public static void printTree(BinaryTree<Integer> root) {
		if (root == null) {
			return;
		}

		System.out.println(root.data);
		printTree(root.left);
		printTree(root.right);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		BinaryTree<Integer> root = new BinaryTree<>(1);
//		
//		BinaryTree<Integer> rootLeft = new BinaryTree<>(2);
//		BinaryTree<Integer> rootRight = new BinaryTree<>(3);
//		root.left=rootLeft;
//		root.right=rootRight;
//		
//		BinaryTree<Integer> twoLeft = new BinaryTree<>(4);
//		BinaryTree<Integer> threesRight = new BinaryTree<>(5);
//		rootLeft.left=twoLeft;
//		rootRight.right=threesRight;

//		BinaryTree<Integer> root = takeInput();
//		BinaryTree<Integer> root = takeInputBetter(true, 0, false);
		BinaryTree<Integer> root = takeInputLevel();
		printTreeDetailed(root);
		System.out.println("Number of Leafs" + numOfLeafs(root));
//		printDepthKelem(root, 2);
//		removeLeaf(root);
//		System.out.println("After removing leafs ");
//		printTreeDetailed(root);
//		System.out.println("is tree Balanced: " + isBalance(root));
	}

}
