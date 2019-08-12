package melwin.leetcode.medium;

// Tree | String

public class SmallestStringStartingFromLeaf {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	private static String result;

	public static String smallestFromLeaf(TreeNode root) {
		result = "";
		traverse(root, "");
		return result;
	}

	private static void traverse(TreeNode node, String path) {
		if (node == null)
			return;
		if (node.left == null && node.right == null) {
			path = path + (char) (node.val + 'a');
			String path_rev = new StringBuilder(path).reverse().toString();
			int compare = path_rev.compareTo(result);
			if (result == "" || compare < 0) {
				result = path_rev;
			}
		} else {
			char c = (char) (node.val + 'a');
			traverse(node.left, path + c);
			traverse(node.right, path + c);
		}
	}

	public static void main(String[] args) {
		TreeNode r = new TreeNode(2);
		TreeNode r_l = new TreeNode(2);
		TreeNode r_r = new TreeNode(1);
		r.left = r_l;
		r.right = r_r;

		System.out.println(smallestFromLeaf(r));
	}

}
