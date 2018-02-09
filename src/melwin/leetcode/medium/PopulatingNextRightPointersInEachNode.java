package melwin.leetcode.medium;

// 117 - Populating Next Right Pointers in Each Node II
//	Level order traversal, with prev, cur and head pointers

public class PopulatingNextRightPointersInEachNode {

	public class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;

		TreeLinkNode(int x) {
			val = x;
		}
	}

	// based on level order traversal
	public void connect(TreeLinkNode root) {

		TreeLinkNode head = null; // head of the next level
		TreeLinkNode prev = null; // the leading node on the next level
		TreeLinkNode cur = root; // current node of current level

		while (cur != null) {

			while (cur != null) { // iterate on the current level
				// left child
				if (cur.left != null) {
					if (prev != null) {
						prev.next = cur.left;
					} else {
						head = cur.left;
					}
					prev = cur.left;
				}
				// right child
				if (cur.right != null) {
					if (prev != null) {
						prev.next = cur.right;
					} else {
						head = cur.right;
					}
					prev = cur.right;
				}
				// move to next node
				cur = cur.next;
			}

			// move to next level
			cur = head;
			head = null;
			prev = null;
		}

	}

	public static void main(String[] args) {
	}

}
