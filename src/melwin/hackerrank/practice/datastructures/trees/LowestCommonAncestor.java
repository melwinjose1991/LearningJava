package melwin.hackerrank.practice.datastructures.trees;

public class LowestCommonAncestor {

	static Node lca(Node root, int v1, int v2) {
		if (root == null)
			return null;

		if (root.data == v1 || root.data == v2)
			return root;

		if ((root.data > v1 && root.data < v2) || (root.data < v1 && root.data > v2)) {
			return root;
		} else {
			if (root.data < v1)
				return lca(root.right, v1, v2);
			else
				return lca(root.left, v1, v2);
		}
	}

	public static class Node {
		int data;
		Node left;
		Node right;

		Node(int x) {
			data = x;
		}
	}

	public static void main(String[] args) {
		Node root = new Node(20);
		root.left = new Node(10);
		root.right = new Node(30);
		root.left.left = new Node(5);
		root.left.left.right = new Node(7);
		root.left.right = new Node(15);
		root.right.left = new Node(25);
		root.right.right = new Node(35);
		root.left.right.left = new Node(13);
		root.left.right.right = new Node(18);

		System.out.println(lca(root, 20, 30).data);
		
		System.out.println(lca(root, 10, 30).data);
		
		System.out.println(lca(root, 5, 15).data);
		
		System.out.println(lca(root, 25, 35).data);
	}
}
