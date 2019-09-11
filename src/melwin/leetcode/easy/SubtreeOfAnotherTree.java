package melwin.leetcode.easy;

// Tree | Recursion

public class SubtreeOfAnotherTree {

	private boolean is_subtree;

	public boolean isSubtree(TreeNode s, TreeNode t) {
		is_subtree = false;
		findRoot(s, t);
		return is_subtree;
	}

	private void findRoot(TreeNode s, TreeNode t) {
		if (s == null)
			return;

		if (s.val == t.val) {
			is_subtree = isEqual(s, t) == true ? true : is_subtree;
		}
		findRoot(s.left, t);
		findRoot(s.right, t);
	}

	private boolean isEqual(TreeNode node_s, TreeNode node_t) {
		if (node_s == null && node_t == null)
			return true;
		else if ((node_s == null && node_t != null) || (node_s != null && node_t == null)) {
			return false;
		} else {
			if (node_s.val != node_t.val)
				return false;
			else {
				return isEqual(node_s.left, node_t.left) && isEqual(node_s.right, node_t.right);
			}
		}
	}

	public static void main(String[] args) {
	}

}
