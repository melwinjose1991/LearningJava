package melwin.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

// Tree | Traversal 

public class BinaryTreeInorderTraversal {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		traverse(root, result);
		return result;
	}

	private void traverse(TreeNode node, List<Integer> result) {
		if (node == null) {
			return;
		}else {
			traverse(node.left, result);
			result.add(node.val);
			traverse(node.right, result);
		}	
	}

	public static void main(String[] args) {
	}

}
