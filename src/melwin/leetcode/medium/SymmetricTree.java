package melwin.leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Tree | BFS

public class SymmetricTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public boolean isSymmetric(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		while (!q.isEmpty()) {
			int len = q.size();
			List<Integer> lvl = new ArrayList<Integer>();
			for (int i = 0; i < len; i++) {
				TreeNode node = q.poll();
				if (node != null) {
					lvl.add(node.val);
					q.add(node.left);
					q.add(node.right);
				}
				else
					lvl.add(-1);
				
			}
			if (!isPalindrome(lvl))
				return false;
		}
		return true;
	}

	private boolean isPalindrome(List<Integer> list) {
		for (int i = 0, j = list.size() - 1; i <= j; i++, j--) {
			if (list.get(i) != list.get(j)) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
	}

}
