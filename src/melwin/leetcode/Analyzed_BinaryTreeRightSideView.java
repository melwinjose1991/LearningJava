package melwin.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// ||IMPROVABLE|| ||TREE|| ||BFS_LEVEL_INDICATOR||
// ||CONTROLLED_POP|| ||O_n||

public class Analyzed_BinaryTreeRightSideView {

	private static int max_height = 0;
	private static HashMap<Integer, ArrayList<Integer>> level_map;

	private static void inOrderTraversal(TreeNode node, int lvl) {
		if (node.left != null)
			inOrderTraversal(node.left, lvl + 1);

		addToMap(node, lvl);

		if (node.right != null)
			inOrderTraversal(node.right, lvl + 1);
	}
	
	/* ||IMPROVEMENT|| above traversal visits the left children
	 * first and is not level-by-level. Queue for each level could 
	 * be avoided if this order could have been changed to visit the 
	 * right children first at each level. 
	 * 
	 * ||BETTER_APPROACH|| modified BFS that indicates when a next
	 * level has begun. Get queue size before starting the popping 
	 * loop and only pop that many no of elements in that cycle,
	 * first element popped is added to the final list.
	 */

	private static void addToMap(TreeNode node, int lvl) {
		if (lvl > max_height)
			max_height = lvl;
		if (level_map.containsKey(lvl)) {
			level_map.get(lvl).add(node.val);
		} else {
			ArrayList<Integer> new_list = new ArrayList<>();
			new_list.add(node.val);
			level_map.put(lvl, new_list);
		}
	}

	public List<Integer> rightSideView(TreeNode root) {
		if (root == null)
			return new ArrayList<Integer>();
		level_map = new HashMap<>();
		inOrderTraversal(root, 1);
		List<Integer> sol = new ArrayList<>();

		for (int i = 1; i <= max_height; i++) {
			if (level_map.containsKey(i)) {
				int last_index = level_map.get(i).size();
				sol.add(level_map.get(i).get(last_index - 1));
			}
		}

		return sol;
	}

	// For Testing

	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

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

	public static void main(String[] args) {
		String input = "4,3,6,1,5,2";

		Analyzed_BinaryTreeRightSideView x = new Analyzed_BinaryTreeRightSideView();
		TreeNode root = x.deserialize(input);
		System.out.println(x.rightSideView(root));
	}

}
