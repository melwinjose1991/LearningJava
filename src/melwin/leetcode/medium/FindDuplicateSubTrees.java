package melwin.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// Tree | Recursion | Encoding | HashMap | HashSet | XXX

public class FindDuplicateSubTrees {

	public static List<TreeNode> findDuplicateSubtrees(TreeNode root) {
		HashMap<String, TreeNode> result = new HashMap<>();
		HashMap<String, TreeNode> set = new HashMap<>();
		traverse(root, result, set);
		return getValueList(result);
	}

	private static List<TreeNode> getValueList(HashMap<String, TreeNode> map) {
		List<TreeNode> result = new ArrayList<>();
		for (TreeNode n : map.values()) {
			result.add(n);
		}
		return result;
	}

	private static String traverse(TreeNode t, HashMap<String, TreeNode> result, HashMap<String, TreeNode> set) {
		if (t == null)
			return "";

		String left_str = traverse(t.left, result, set);
		String right_str = traverse(t.right, result, set);
		String key = null;
		if (left_str == "" && right_str == "") {
			key = new String(Integer.toString(t.val));
		} else if (left_str == "" && right_str != "") {
			key = new String(Integer.toString(t.val) + "()" + "(" + right_str + ")");
		} else if (left_str != "" && right_str == "") {
			key = new String(Integer.toString(t.val) + "(" + left_str + ")");
		} else {
			key = new String(Integer.toString(t.val) + "(" + left_str + ")" + "(" + right_str + ")");
		}
		// System.out.println("@" + t.val + " key=" + key);
		if (set.containsKey(key)) {
			// System.out.println("\t Found duplicate at " + t.val);
			if (!result.containsKey(key)) {
				result.put(key, t);
			}
		} else {
			set.put(key, t);
		}
		return key;

	}

	public static void main(String[] args) {
		TreeNode a = new TreeNode(1);
		TreeNode b = new TreeNode(2);
		TreeNode c = new TreeNode(2);
		TreeNode d = new TreeNode(3);
		TreeNode e = new TreeNode(3);

		a.left = b;
		a.right = c;
		b.left = d;
		c.left = e;

		findDuplicateSubtrees(a);
	}

}
