package melwin.hackerrank.practice.datastructures.trees;

public class Query {

	public static class Node {
		int data;
		Node left;
		Node right;

		Node(int x) {
			data = x;
		}
	}

	private static Node predecessor, successor;

	// ||SUCESSOR|| ||PREDECESSOR||
	public static void findSuccessorPredecessor(Node root, int data) {
		if (root != null) {
			if (root.data == data) {
				if (root.left != null) {
					Node t = root.left;
					while (t.right != null) {
						t = t.right;
					}
					predecessor = t;
				}
				if (root.right != null) {
					Node t = root.right;
					while (t.left != null) {
						t = t.left;
					}
					successor = t;
				}
			} else if (root.data > data) {
				successor = root;
				findSuccessorPredecessor(root.left, data);
			} else if (root.data < data) {
				predecessor = root;
				findSuccessorPredecessor(root.right, data);
			}
		}
	}

	public static void main(String[] args) {
		Node root = new Node(3);
		root.left = new Node(1);
		root.left.right = new Node(2);
		root.right = new Node(5);
		root.right.left = new Node(4);

		int val = 2;
		findSuccessorPredecessor(root, val);
		System.out.println(predecessor.data + " " + val + " " + successor.data);
	}
}
