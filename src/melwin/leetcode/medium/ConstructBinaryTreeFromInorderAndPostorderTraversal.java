package melwin.leetcode.medium;

import java.util.HashMap;

// Tree | Recursion

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	private static HashMap<Integer, Integer> inorder_map;
	private static HashMap<Integer, Integer> postorder_map;

	public static TreeNode buildTree(int[] inorder, int[] postorder) {
		if (inorder.length == 0)
			return null;

		inorder_map = new HashMap<>();
		for (int i = 0; i < inorder.length; i++) {
			inorder_map.put(inorder[i], i);
		}

		postorder_map = new HashMap<>();
		for (int i = 0; i < postorder.length; i++) {
			postorder_map.put(postorder[i], i);
		}

		return createTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
	}

	private static TreeNode createTree(int[] in, int in_i, int in_j, int[] post, int post_i, int post_j) {
		if (post_i == Integer.MAX_VALUE || post_j == Integer.MIN_VALUE)
			return null;

		if (post_i == post_j) {
			return new TreeNode(post[post_i]);
		} else {
			// System.out.println("@ in:" + in_i + "-" + in_j + " post:" + post_i + "-" +
			// post_j);
			int val = post[post_j];
			int val_in_index = inorder_map.get(val);
			TreeNode node = new TreeNode(val);

			int[] left_post_index = getPostIndices(in, in_i, val_in_index - 1);
			// System.out.println(Arrays.toString(left_post_index));
			node.left = createTree(in, in_i, val_in_index - 1, post, left_post_index[0], left_post_index[1]);

			int[] right_post_index = getPostIndices(in, val_in_index + 1, in_j);
			// System.out.println(Arrays.toString(right_post_index));
			node.right = createTree(in, val_in_index + 1, in_j, post, right_post_index[0], right_post_index[1]);

			return node;
		}
	}

	private static int[] getPostIndices(int[] in, int in_i, int in_j) {
		int min_index = Integer.MAX_VALUE, max_index = Integer.MIN_VALUE;
		for (int i = in_i; i <= in_j; i++) {
			min_index = Math.min(min_index, postorder_map.get(in[i]));
			max_index = Math.max(max_index, postorder_map.get(in[i]));
		}
		return new int[] { min_index, max_index };
	}

	public static void main(String[] args) {
		int[] in = { 9, 3, 15, 20, 7 };
		int[] post = { 9, 15, 7, 20, 3 };
		buildTree(in, post);
	}

}
