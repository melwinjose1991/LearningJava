package melwin.leetcode.easy;

import java.util.Stack;

import melwin.leetcode.medium.TreeNode;

// 653. Two Sum IV - Input is a BST

public class TwoSumIV {
	public boolean findTarget(TreeNode root, int k) {
		if (root == null)
			return false;
		Stack<TreeNode> l_stack = new Stack<>();
		Stack<TreeNode> r_stack = new Stack<>();
		stackAdd(l_stack, root, true);
		stackAdd(r_stack, root, false);
		while (l_stack.peek() != r_stack.peek()) {
			int n = l_stack.peek().val + r_stack.peek().val;
			if (n == k) {
				return true;
			} else if (n > k) {
				stackNext(r_stack, false);
			} else {
				stackNext(l_stack, true);
			}
		}
		return false;
	}

	private void stackAdd(Stack<TreeNode> stack, TreeNode node, boolean isLeft) {
		while (node != null) {
			stack.push(node);
			node = (isLeft) ? node.left : node.right;
		}
	}

	private void stackNext(Stack<TreeNode> stack, boolean isLeft) {
		TreeNode node = stack.pop();
		if (isLeft) {
			stackAdd(stack, node.right, isLeft);
		} else {
			stackAdd(stack, node.left, isLeft);
		}
	}

	public static void main(String[] args) {
	}

}
