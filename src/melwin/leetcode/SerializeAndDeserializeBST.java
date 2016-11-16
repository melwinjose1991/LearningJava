package melwin.leetcode;

import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.TreeMap;

/*
 * ||LEVEL_ORDER_TRAVERSAL|| ||Serialize_Deserialize||
 */
public class SerializeAndDeserializeBST {

	private static StringBuilder serialized;
	private static TreeMap<Integer, ArrayList<Integer>> level_map;

	private static void inOrderTraversal(TreeNode node, int lvl) {
		if (node.left != null)
			inOrderTraversal(node.left, lvl + 1);

		addToMap(node, lvl);

		if (node.right != null)
			inOrderTraversal(node.right, lvl + 1);
	}

	private static void addToMap(TreeNode node, int lvl) {
		if (level_map.containsKey(lvl)) {
			level_map.get(lvl).add(node.val);
		} else {
			ArrayList<Integer> new_list = new ArrayList<>();
			new_list.add(node.val);
			level_map.put(lvl, new_list);
		}
	}

	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		if (root == null)
			return null;

		level_map = new TreeMap<>();
		serialized = new StringBuilder();
		inOrderTraversal(root, 1);

		for (Entry<Integer, ArrayList<Integer>> entry : level_map.entrySet()) {
			for (Integer i : entry.getValue()) {
				serialized.append(i + ",");
			}
		}

		serialized.deleteCharAt(serialized.length() - 1);
		// System.out.println(serialized);

		return serialized.toString();
	}

	private static TreeNode insertTree(TreeNode root, int val) {
		if (root == null) {
			root = new TreeNode(val);
		} else {
			if (val < root.val) {
				if (root.left == null) {
					TreeNode new_node = new TreeNode(val);
					root.left = new_node;
				} else {
					root.left = insertTree(root.left, val);
				}
			} else {
				if (root.right == null) {
					TreeNode new_node = new TreeNode(val);
					root.right = new_node;
				} else {
					root.right = insertTree(root.right, val);
				}
			}
		}
		return root;
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		if (data == null)
			return null;
		String[] nodes = data.split(",");
		if (nodes.length == 0)
			return null;
		TreeNode root = null;
		for (String node : nodes) {
			root = insertTree(root, Integer.parseInt(node));
		}
		return root;
	}

	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	private static void inOrder(TreeNode node) {
		if (node.left != null)
			inOrder(node.left);

		System.out.println(node.val);

		if (node.right != null)
			inOrder(node.right);
	}

	public static void main(String[] args) {
		TreeNode right = new TreeNode(3);
		TreeNode left = new TreeNode(1);
		TreeNode root = new TreeNode(2);
		root.right = right;
		root.left = left;

		SerializeAndDeserializeBST sol = new SerializeAndDeserializeBST();
		inOrder(sol.deserialize(sol.serialize(null)));

		System.out.println("Done");
	}

}
