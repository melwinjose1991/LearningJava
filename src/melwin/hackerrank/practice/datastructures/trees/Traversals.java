package melwin.hackerrank.practice.datastructures.trees;

import java.util.Stack;

// ||TREE|| ||TRAVERSALS|| ||INORDER|| ||POST ORDER|| ||PRE ORDER||
// ||MORRIS|| ||STACKLESS|| ||NON RECURSIVE||

public class Traversals {
	public static class Node {
		int data;
		Node left;
		Node right;

		Node(int x) {
			data = x;
		}

		// Time:O(n) Space:O(1)
		public static void morrisInOrder(Node root) {
			Node current = root, predecessor;
			while (current != null) {
				if (current.left == null) {
					System.out.print(current.data + " ");
					current = current.right;
				} else {
					// Find the inorder predecessor of current
					predecessor = current.left;
					while (predecessor.right != null && predecessor.right != current)
						predecessor = predecessor.right;

					if (predecessor.right == null) {
						predecessor.right = current;
						current = current.left;
					} else {
						// fixing the right child of predecessor
						predecessor.right = null;
						System.out.print(current.data + " ");
						current = current.right;
					}
				}
			}

		}

		// Time:O(n) Space:O(1)
		public static void morrisPreorder(Node root) {
			Node current = root, predecessor;
			while (current != null) {
				if (current.left == null) {
					System.out.print(current.data + " ");
					current = current.right;
				} else {
					// Find inorder predecessor
					predecessor = current.left;
					while (predecessor.right != null && predecessor.right != current) {
						predecessor = predecessor.right;
					}

					if (predecessor.right == null) {
						predecessor.right = current;
						System.out.print(current.data + " ");
						current = current.left;
					} else {
						// fixing the right child of predecessor
						predecessor.right = null;
						current = current.right;
					}
				}
			}
		}

		// Time:O(n) Space:O(?)
		public static void nonRecursiveInorder(Node root) {
			Stack<Node> stack = new Stack<Node>();
			Node node = root;

			// first node to be visited will be the left one
			while (node != null) {
				stack.push(node);
				node = node.left;
			}

			while (stack.size() > 0) {
				node = stack.pop();
				System.out.print(node.data + " ");
				if (node.right != null) {
					node = node.right;

					while (node != null) {
						stack.push(node);
						node = node.left;
					}
				}
			}
		}

		// Time:O(n) Space:O(?)
		public static void nonRecursivePreorder(Node root) {
			Stack<Node> stack = new Stack<Node>();
			stack.push(root);

			while (stack.empty() == false) {

				Node current = stack.pop();
				System.out.print(current.data + " ");
				if (current.right != null) {
					stack.push(current.right);
				}
				if (current.left != null) {
					stack.push(current.left);
				}
			}
		}

		// Time:O(n) Space:O(1)
		public static void nonRecursivePostorder(Node root) {
			Stack<Node> stack_one = new Stack<Node>();
			Stack<Node> stack_two = new Stack<Node>();
			stack_one.push(root);

			while (stack_one.empty() == false) {
				Node current = stack_one.pop();
				stack_two.push(current);
				if (current.left != null) {
					stack_one.push(current.left);
				}
				if (current.right != null) {
					stack_one.push(current.right);
				}

			}

			while (!stack_two.empty()) {
				System.out.print(stack_two.pop().data + " ");
			}
		}
	}

	public static void main(String[] args) {
		Node root = new Node(3);
		root.left = new Node(1);
		root.left.right = new Node(2);
		root.right = new Node(5);
		root.right.left = new Node(4);

		System.out.print("Stackless-InOrder\t: ");
		Node.morrisInOrder(root);
		System.out.print("\nNonRecursive-InOrder\t: ");
		Node.nonRecursiveInorder(root);

		System.out.print("\n\nStackless-PreOrder\t: ");
		Node.morrisPreorder(root);
		System.out.print("\nNonRecursive-PreOrder\t: ");
		Node.nonRecursivePreorder(root);

		System.out.print("\n\nonRecursive-PostsOrder\t: ");
		Node.nonRecursivePostorder(root);

	}

}
