package melwin.leetcode;

import java.util.ArrayList;

// ||INORDER|| ||BST|| ||O_n||

public class Analyzed_RecoverBinarySearchTree {

	private void findPairs(TreeNode node) {
		if (node.left != null)
			findPairs(node.left);

		if (last_value == Integer.MIN_VALUE) {
			last_value = node.val;
			last = node;
		} else {
			if (last_value >= node.val) {
				pairs.add(last);
				pairs.add(node);
			}
			last_value = node.val;
			last = node;
		}

		if (node.right != null)
			findPairs(node.right);
	}

	private int last_value = Integer.MIN_VALUE;
	private TreeNode last = null;
	private ArrayList<TreeNode> pairs;

	public void recoverTree(TreeNode root) {
		pairs = new ArrayList<>();
		findPairs(root);
		
		if(pairs.size()==2){
			int tmp = pairs.get(0).val;
			pairs.get(0).val = pairs.get(1).val;
			pairs.get(1).val = tmp;
		}else if(pairs.size()==4){
			int tmp = pairs.get(0).val;
			pairs.get(0).val = pairs.get(3).val;
			pairs.get(3).val = tmp;
		}
	}

	// Template
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	public void inOrderTravesal(TreeNode node) {
		if (node.left != null)
			inOrderTravesal(node.left);

		System.out.print(node.val + " ");

		if (node.right != null)
			inOrderTravesal(node.right);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		
		root.left = new TreeNode(5);
		root.right = new TreeNode(14);
		
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(7);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(17);

		Analyzed_RecoverBinarySearchTree x = new Analyzed_RecoverBinarySearchTree();
		
		x.inOrderTravesal(root);
		System.out.println();
		x.recoverTree(root);
		x.inOrderTravesal(root);
	}

}
