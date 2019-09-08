package melwin.leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SerializeAndDeserializeBST {

	public static class Codec {

		// Encodes a tree to a single string.
		public String serialize(TreeNode root) {
			if (root == null)
				return "";
			List<String> result_list = new ArrayList<String>();
			Queue<TreeNode> q = new LinkedList<TreeNode>();
			q.add(root);
			while (!q.isEmpty()) {
				int len = q.size();
				for (int i = 0; i < len; i++) {
					TreeNode n = q.poll();
					if (n == null) {
						result_list.add("x");
					} else {
						result_list.add(String.valueOf(n.val));
						q.add(n.left);
						q.add(n.right);
					}
				}
			}
			return String.join(",", result_list);
		}

		// Decodes your encoded data to tree.
		public TreeNode deserialize(String data) {
			if (data.length() == 0)
				return null;
			String[] nodes = data.split(",");
			Queue<TreeNode> q = new LinkedList<>();
			int i = 0;
			TreeNode root = new TreeNode(Integer.valueOf(nodes[i]));
			q.add(root);
			for (i = 1; i < nodes.length;) {
				int len = q.size();
				for (int j = 0; j < len; j++) {
					TreeNode n = q.poll();
					if (!nodes[i].equals("x")) {
						n.left = new TreeNode(Integer.valueOf(nodes[i]));
						q.add(n.left);
					}
					i++;
					if (!nodes[i].equals("x")) {
						n.right = new TreeNode(Integer.valueOf(nodes[i]));
						q.add(n.right);
					}
					i++;
				}
			}
			return root;
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
		c.left = d;
		c.right = e;

		Codec codec = new Codec();
		System.out.println(codec.serialize(a));
		codec.deserialize(codec.serialize(a));
	}

}
