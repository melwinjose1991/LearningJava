package melwin.leetcode.medium;

// Tree | Binary Search | XXX |

public class CountCompleteTreeNodes {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static int countNodes(TreeNode node) {
		if (node == null)
			return 0;
		int left_height = getHeight(node, true);
		int right_height = getHeight(node, false);
		if (left_height == right_height) {
			int nodes_count = 0;
			for (int i = 0; i < left_height; i++) {
				nodes_count += (1 << i);
			}
			return nodes_count;
		}else {
			return 1 + countNodes(node.left) + countNodes(node.right);
		}

	}

	private static int getHeight(TreeNode node, boolean left_height) {
		if (node == null)
			return 0;
		if (left_height) {
			return 1 + getHeight(node.left, left_height);
		} else {
			return 1 + getHeight(node.right, left_height);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
