package melwin.leetcode.medium;

import java.util.Stack;

// Leetcode 173 - Binary Search Tree Iterator
// Stack

public class BinarySearchTreeIterator {

	private Stack<TreeNode> stack = new Stack<TreeNode>();

	public BinarySearchTreeIterator(TreeNode root) {
		pushAll(root);
	}

	public boolean hasNext() {
		return !stack.isEmpty();
	}

	public int next() {
		TreeNode tmpNode = stack.pop();
		pushAll(tmpNode.right);
		return tmpNode.val;
	}

	private void pushAll(TreeNode node) {
		for (; node != null; stack.push(node), node = node.left);
	}

	public static void main(String[] args) {
	}

}
