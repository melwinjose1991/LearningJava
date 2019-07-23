package melwin.leetcode.easy;

// Tree | Recursion

public class ConstructStringFromBinaryTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public String tree2str(TreeNode t) {
		if (t == null)
			return "";
		String left_str = tree2str(t.left);
		String right_str = tree2str(t.right);
		if (left_str == "" && right_str == "") {
			return new String(Integer.toString(t.val));
		} else if (left_str == "" && right_str != "") {
			return new String(Integer.toString(t.val) + "()" + "(" + right_str + ")");
		} else if (left_str != "" && right_str == "") {
			return new String(Integer.toString(t.val) + "(" + left_str + ")");
		} else {
			return new String(Integer.toString(t.val) + "(" + left_str + ")" + "(" + right_str + ")");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
