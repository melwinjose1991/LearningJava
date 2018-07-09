package melwin.codinginterview.D_TreesAndGraphs_DONE;

import java.util.HashMap;

// ||DYNAMIC PROGRAMMING|| ||TREE|| ||PRE-ORDER||
// ||RUNNING SUM|| ||CRACKING||

public class PathsWithSum {

	// source : CtCI-6th-Edition/Java/Ch 04. Trees and
	// Graphs/Q4_12_Paths_with_Sum/QuestionB.java

	public static int countPathsWithSum(TreeNode root, int targetSum) {
		return countPathsWithSum(root, targetSum, 0, new HashMap<Integer, Integer>());
	}

	// pathCount stores how many times a particular sum has been seen in the
	// current path
	public static int countPathsWithSum(TreeNode node, int targetSum, int runningSum,
			HashMap<Integer, Integer> pathCount) {
		if (node == null)
			return 0; // Base case

		runningSum += node.data;

		/* Count paths with sum ending at the current node. */
		int sum = runningSum - targetSum;
		int totalPaths = pathCount.getOrDefault(sum, 0);

		// If runningSum equals targetSum, then one additional path starts at
		// root. Add in this path.
		if (runningSum == targetSum) {
			totalPaths++;
		}

		// Add runningSum to pathCount
		incrementHashTable(pathCount, runningSum, 1);

		// Count paths with sum on the left and right
		totalPaths += countPathsWithSum(node.left, targetSum, runningSum, pathCount);
		totalPaths += countPathsWithSum(node.right, targetSum, runningSum, pathCount);

		incrementHashTable(pathCount, runningSum, -1); // Remove runningSum
		return totalPaths;
	}

	public static void incrementHashTable(HashMap<Integer, Integer> hashTable, int key, int delta) {
		int newCount = hashTable.getOrDefault(key, 0) + delta;
		if (newCount == 0) { // Remove when zero to reduce space usage
			hashTable.remove(key);
		} else {
			hashTable.put(key, newCount);
		}
	}

	public static class TreeNode {
		TreeNode left, right;
		int data;

		TreeNode(int val) {
			this.data = val;
			left = right = null;
		}

	}

	public static void main(String[] args) {
		/*
		 * TreeNode root = new TreeNode(5); root.left = new TreeNode(3); root.right =
		 * new TreeNode(1); root.left.left = new TreeNode(-8); root.left.right = new
		 * TreeNode(8); root.right.left = new TreeNode(2); root.right.right = new
		 * TreeNode(6); root.right.left.left = new TreeNode(0);
		 * System.out.println(countPathsWithSum(root, 0));
		 */

		TreeNode root = new TreeNode(-7);
		root.left = new TreeNode(-7);
		root.left.right = new TreeNode(1);
		root.left.right.left = new TreeNode(2);
		root.right = new TreeNode(7);
		root.right.left = new TreeNode(3);
		root.right.right = new TreeNode(20);
		root.right.right.left = new TreeNode(0);
		root.right.right.left.left = new TreeNode(-3);
		root.right.right.left.left.right = new TreeNode(2);
		root.right.right.left.left.right.left = new TreeNode(1);
		System.out.println(countPathsWithSum(root, 0));

	}
}
