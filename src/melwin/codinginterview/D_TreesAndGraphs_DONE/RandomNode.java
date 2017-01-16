package melwin.codinginterview.D_TreesAndGraphs_DONE;

import java.util.Random;

// ||CRACKING|| ||I-th Node|| ||TREE||

public class RandomNode {

	public int size;

	public TreeNode getRandomNode(TreeNode root) {
		if (root == null)
			return null;
		Random random = new Random();
		int i = random.nextInt(size);
		return getIthNode(root, i);
	}

	public TreeNode getIthNode(TreeNode root, int i) {
		int leftSize = root.left == null ? 0 : root.left.size;
		if (i < leftSize) {
			return getIthNode(root.left, i);
		} else if (i == leftSize) {
			return root;
		} else {
			return getIthNode(root.right, i - (leftSize + 1));
		}
	}

	public static class TreeNode {
		public int val;
		public int size;
		public TreeNode left, right;
	}

	public static void main(String[] args) {
		RandomNode x = new RandomNode();

		TreeNode a = new TreeNode();
		a.size = 3;
		a.val = 100;

		TreeNode b = new TreeNode();
		b.size = 1;
		b.val = 200;

		TreeNode c = new TreeNode();
		c.size = 1;
		c.val = 50;

		a.left = b;
		a.right = c;

		x.size = 3;
		System.out.println(x.getRandomNode(a).val);
		System.out.println(x.getRandomNode(a).val);
		System.out.println(x.getRandomNode(a).val);
	}

}
