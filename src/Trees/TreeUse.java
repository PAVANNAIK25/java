package Trees;
import java.util.Queue;
import java.util.Scanner;
import java.util.LinkedList;

public class TreeUse {
	
	


	public static TreeNode<Integer> takeInput () {
		Scanner sc = new Scanner(System.in);
		Queue<TreeNode<Integer>> pendingChild = new LinkedList<>();
		System.out.print("Enter roots data: ");
		int data = sc.nextInt();
		TreeNode<Integer> root = new TreeNode<>(data);
		pendingChild.add(root);
		while(!pendingChild.isEmpty()) {
			TreeNode<Integer> front = pendingChild.poll();
			
			while(true) {
				System.out.println("Enter "+ front.data + "'s childern");
				int node = sc.nextInt();
				if(node==-1) {
					break;
				}else {
					TreeNode<Integer> newNode = new TreeNode<>(node);
					front.children.add(newNode);
					pendingChild.add(newNode);
				}
			}
		}
		return root;
	}
	
	public static int numNodes(TreeNode<Integer> root) {
		
		if(root == null) {
			return 0;
		}
		
		int count = 0;
		
		for(int i=0; i<root.children.size(); i++) {
			int childCount = numNodes(root.children.get(i));
			count += childCount;
		}
		
		return 1+ count;
	}
	
	public static void printTreeBetter(TreeNode<Integer> root) {
		if(root==null) {
			return;
		}
		
		System.out.print(root.data + ": ");
		
		for(int i=0; i<root.children.size(); i++) {
			System.out.print(root.children.get(i).data+ " ");
		}
		
		System.out.println();
		
		for (int i=0; i<root.children.size(); i++) {
			TreeNode<Integer> child = root.children.get(i);
			printTreeBetter(child);
		}
	}
	
	
	public static void printTree(TreeNode<Integer> root) {
		if(root==null) {
			return;
		}
		
		System.out.print(root.data + " ");
		
		for (int i=0; i<root.children.size(); i++) {
			TreeNode<Integer> child = root.children.get(i);
			printTree(child);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		TreeNode<Integer> root = new TreeNode<>(4);
//		TreeNode<Integer> node1 = new TreeNode<>(5);
//		TreeNode<Integer> node2 = new TreeNode<>(6);
//		TreeNode<Integer> node3 = new TreeNode<>(7);
//		TreeNode<Integer> node4 = new TreeNode<>(8);
//		TreeNode<Integer> node5 = new TreeNode<>(9);
		
//		root.children.add(node1);
//		root.children.add(node2);
//		root.children.add(node3);
////		node2.children.add(node4);
//		node2.children.add(node5);
//		printTree(root);
//		TreeNode<Integer>root1 = new TreeNode<>(0);
//		root1 = null;
		TreeNode<Integer> root = takeInput();
		printTreeBetter(root);
		System.out.print("Number of Nodes: " + numNodes(root));
	}

}
