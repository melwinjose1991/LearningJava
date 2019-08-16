package melwin.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

// Tree | 

public class LowestCommonAncestorOfABinaryTree {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		List<TreeNode> p_path = new ArrayList<>();
		List<TreeNode> q_path = new ArrayList<>();
		getPath(root, p, p_path);
		getPath(root, q, q_path);

		TreeNode lca = null;
		for (int i = 0; i < p_path.size() && i < q_path.size(); i++) {
			if (p_path.get(i).equals(q_path.get(i))) {
				lca = p_path.get(i);
				continue;
			} else {
				return lca;
			}
		}

		return lca;
	}

	private static boolean getPath(TreeNode node, TreeNode target, List<TreeNode> path) {
		if (node == null)
			return false;

		if (node.val == target.val) {
			path.add(target);
			return true;
		}

		path.add(node);
		if (getPath(node.left, target, path) || getPath(node.right, target, path))
			return true;
		else {
			path.remove(path.size() - 1);
			return false;
		}
	}

	public static void main(String[] args) {
		TreeNode a = new TreeNode(1);
		TreeNode b = new TreeNode(2);
		TreeNode c = new TreeNode(3);
		TreeNode d = new TreeNode(4);
		TreeNode e = new TreeNode(5);

		a.left = b;
		a.right = c;
		b.left = e;
		c.right = d;

		System.out.println(lowestCommonAncestor(a, e, d).val);
	}

}
