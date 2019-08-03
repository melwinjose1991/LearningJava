package melwin.leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

// Tree | BFS

public class FindBottomLeftTreeValue {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public int findBottomLeftValue(TreeNode root) {
		int result = root.val;
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		while (!q.isEmpty()) {
			int len = q.size();
			for (int i = 0; i < len; i++) {
				TreeNode node = q.poll();
				if (i == 0)
					result = node.val;
				if(node.left!=null)
					q.add(node.left);
				if(node.right!=null)
					q.add(node.right);
			}
		}
		return result;
	}

	public static void main(String[] args) {
	}

}
