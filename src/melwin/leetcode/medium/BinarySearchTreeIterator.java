package melwin.leetcode.medium;

import java.util.Stack;

// Binary Tree | Iterator

public class BinarySearchTreeIterator {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	class BSTIterator {
		private Stack<TreeNode> stack;

		public BSTIterator(TreeNode root) {
			stack = new Stack<>();
			TreeNode node = root;
			while (node != null) {
				stack.add(node);
				node = node.left;
			}
		}

		public int next() {
			TreeNode node = stack.pop();
			TreeNode tmp = node.right;
			while (tmp != null) {
				stack.push(tmp);
				tmp = tmp.left;
			}
			return node.val;
		}

		public boolean hasNext() {
			return stack.size() > 0;
		}
	}

	public static void main(String[] args) {
	}

}
