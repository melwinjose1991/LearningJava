package melwin.leetcode;

import java.util.ArrayList;

// ||List_To_BST|| ||O_n|| ||Empty_Tree|| ||Inorder||

public class Analyzed_ConvertSortedListToBinarySearchTree {

	private TreeNode createEmptyTree(int n) {
		TreeNode root = new TreeNode(0);
		ArrayList<TreeNode> q = new ArrayList<>();
		q.add(root);
		n--;
		while (!q.isEmpty()) {
			TreeNode node = q.remove(0);
			if (n <= 0)
				break;
			TreeNode left = new TreeNode(0);
			node.left = left;
			q.add(left);
			n--;

			if (n <= 0)
				break;
			TreeNode right = new TreeNode(0);
			node.right = right;
			q.add(right);
			n--;
		}
		return root;
	}

	private ListNode list_node;
	private void inOrderTraversal(TreeNode tree_node) {
		if (tree_node.left != null)
			inOrderTraversal(tree_node.left);

		tree_node.val = list_node.val;
		list_node = list_node.next;

		if (tree_node.right != null)
			inOrderTraversal(tree_node.right);
	}

	public TreeNode sortedListToBST(ListNode head) {
		if (head == null)
			return null;

		int n = 0;
		ListNode ptr = head;
		while (ptr != null) {
			ptr = ptr.next;
			n++;
		}
		TreeNode root = createEmptyTree(n);
		list_node = head;
		inOrderTraversal(root);
		return root;
	}

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static void main(String[] args) {
		Analyzed_ConvertSortedListToBinarySearchTree x = new Analyzed_ConvertSortedListToBinarySearchTree();

		ListNode three = new ListNode(2);
		ListNode two = new ListNode(1);
		two.next = three;
		ListNode one = new ListNode(0);
		one.next = two;
		ListNode zero = new ListNode(-1);
		zero.next = one;

		x.sortedListToBST(zero);
	}

}
