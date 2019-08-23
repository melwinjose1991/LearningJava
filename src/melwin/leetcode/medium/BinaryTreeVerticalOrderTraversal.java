package melwin.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

// Tree | BFS | Queue | HashMap

public class BinaryTreeVerticalOrderTraversal {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static class Node {
		TreeNode node;
		int col;

		Node(TreeNode n, int column) {
			node = n;
			col = column;
		}
	}

	public static List<List<Integer>> verticalOrder(TreeNode root) {
		HashMap<Integer, List<Integer>> map = new HashMap<>();
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(root, 0));
		while (!q.isEmpty()) {
			int len = q.size();
			for (int i = 0; i < len; i++) {
				Node n = q.poll();
				if (n.node != null) {
					if (!map.containsKey(n.col))
						map.put(n.col, new ArrayList<>());
					map.get(n.col).add(n.node.val);
					if (n.node.left != null) {
						q.add(new Node(n.node.left, n.col - 1));
					}
					if (n.node.right != null) {
						q.add(new Node(n.node.right, n.col + 1));
					}
				}
			}
		}

		int[] lvls = getSortedKeys(map.keySet());
		List<List<Integer>> result = new ArrayList<List<Integer>>(lvls.length);
		for (int i = 0; i < lvls.length; i++) {
			result.add(map.get(lvls[i]));
			System.out.println(map.get(lvls[i]));
		}
		return result;
	}

	private static int[] getSortedKeys(Set<Integer> set) {
		int[] keys = new int[set.size()];
		int i = 0;
		for (int k : set) {
			keys[i++] = k;
		}
		Arrays.sort(keys);
		return keys;
	}

	public static void main(String[] args) {
		TreeNode a = new TreeNode(1);
		TreeNode b = new TreeNode(2);
		TreeNode c = new TreeNode(3);
		TreeNode d = new TreeNode(4);
		a.left = b;
		a.right = c;
		b.right = d;

		System.out.println(verticalOrder(a));
	}

}
