package melwin.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

// Tree | Recrusion

public class FindLargestValueInEachTreeRow {
	public List<Integer> largestValues(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		traverse(root, 1, result);
		return result;
	}

	private void traverse(TreeNode node, int depth, List<Integer> result) {
		if (node == null)
			return;

		if (depth > result.size()) {
			result.add(node.val);
		} else {
			if (result.get(depth - 1) < node.val) {
				result.set(depth - 1, node.val);
			}
		}
		traverse(node.left, depth + 1, result);
		traverse(node.right, depth + 1, result);
	}

	public static void main(String[] args) {
	}

}
