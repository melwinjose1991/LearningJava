package melwin.leetcode;

// ||COMPLETE TREE|| ||HEIGHT|| ||#NODES||
// ||O(h^2)|| ||RECURSION|| ||DIVIDE AND CONQUER||

public class Analyzed_CountCompleteTreeNodes {

	public int countNodes(TreeNode root) {
		if (root == null)
			return 0;
		TreeNode left = root, right = root;
		int height = 0;
		while (right != null) {
			left = left.left;
			right = right.right;
			height++;
		}
		if (left == null)
			return (1 << height) - 1;
		return 1 + countNodes(root.left) + countNodes(root.right);
	}

	/*
	 * If height of left subtree is equal to that of right, then you can use the
	 * formula to compute the number of node. Else, recursively call the
	 * countNodes function either till it root==null OR height of left = right
	 */

	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static void main(String[] args) {
		TreeNode b = new TreeNode(2);
		TreeNode a = new TreeNode(3);

		a.left = b;
		
		Analyzed_CountCompleteTreeNodes x = new Analyzed_CountCompleteTreeNodes();
		System.out.println(x.countNodes(a));
	}

}
