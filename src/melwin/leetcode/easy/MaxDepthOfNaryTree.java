package melwin.leetcode.easy;

import java.util.List;

// Tree | DFS

public class MaxDepthOfNaryTree {
	class Node {
		public int val;
		public List<Node> children;

		public Node() {
		}

		public Node(int _val, List<Node> _children) {
			val = _val;
			children = _children;
		}
	}

	private int max_depth;

	public int maxDepth(Node root) {
		dfs(root, 1);
		return max_depth;
	}

	private void dfs(Node node, int lvl) {
		if (node == null)
			return;

		max_depth = Math.max(max_depth, lvl);
		for (Node c : node.children) {
			dfs(c, lvl + 1);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
