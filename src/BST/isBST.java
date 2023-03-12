package BST;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import BinaryTrees.BinaryTree;

public class isBST {
	
	
	public static isBSTReturn isBST2(BinaryTree<Integer> root) {
		if(root == null) {
			isBSTReturn ans = new isBSTReturn(Integer.MAX_VALUE, Integer.MIN_VALUE, true);
			return ans;
		}
		
		isBSTReturn ansleft = isBST2(root.left);
		isBSTReturn ansright = isBST2(root.right);
		
		int min = Math.min(root.data, Math.min(ansleft.min, ansright.min));
		int max = Math.max(root.data, Math.max(ansleft.max, ansright.max));
		boolean isBST = true;
		if(root.data <= ansleft.max) {
			isBST = false;
		}
		
		if(root.data > ansright.min) {
			isBST = false;
		}
		if(!ansleft.isBST || !ansright.isBST) {
			isBST = false;
		}
		isBSTReturn ans = new isBSTReturn(min, max, isBST);
		return ans;
	}
	
	public static boolean isBST3(BinaryTree<Integer> root, int minRange, int maxRange) {
		if(root ==null) {
			return true;
		}
		
		if(root.data < minRange || root.data > maxRange) {
			return false;
		}
		
		boolean ansLeft = isBST3(root.left, minRange, root.data-1);
		boolean ansRight = isBST3(root.right, root.data, maxRange);
		return ansLeft && ansRight;
		
	}
	
 	public static boolean isBSTtree(BinaryTree<Integer> root) {
		if(root ==null) {
			return true;
		}
		int leftMax = maximum(root.left);
		if(leftMax >= root.data) {
			return false;
		}
		int rightMin = minimum(root.right);
		
		if(rightMin < root.data) {
			return false;
		}
		
		boolean leftIsBST = isBSTtree(root.left);
		boolean rightIsBST = isBSTtree(root.right);
		return leftIsBST && rightIsBST;
	}
	
	public static int maximum(BinaryTree<Integer> root) {
//		int max = Integer.MIN_VALUE;
		if(root==null) {
			return Integer.MIN_VALUE;
		}
		
		int leftMax = maximum(root.left);
		int rightMax = maximum(root.right);
		
		return Math.max(root.data, Math.max(leftMax, rightMax));
		
	}
	
	public static int minimum (BinaryTree<Integer> root) {
//		int min = Integer.MAX_VALUE;
		if(root==null) {
			return Integer.MAX_VALUE;
		}
		
//		if(root.data<min) {
//			min = root.data;
//		}
		int leftMin = minimum(root.left);
		int rightMin = minimum(root.right);
		
		return Math.min(root.data,Math.min(leftMin, rightMin));
		
	}
	
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
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree<Integer> root = takeInputLevel();
		printTreeDetailed (root);
//		System.out.println(isBSTtree(root));
//		isBSTReturn ans = isBST2(root);
//		System.out.print("mininmum " + ans.min +" maximum "+ ans.max +" isBST "+ ans.isBST);
		System.out.print(isBST3(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
	}

}
