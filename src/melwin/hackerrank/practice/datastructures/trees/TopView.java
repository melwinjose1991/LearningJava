package melwin.hackerrank.practice.datastructures.trees;

import java.util.Map;
import java.util.TreeMap;

public class TopView {

	private static void preOrder(Node root, int step) {
		if (!top_view.containsKey(step)) {
			top_view.put(step, root.data);
		}
		if (root.left != null)
			preOrder(root.left, step - 1);
		if (root.right != null)
			preOrder(root.right, step + 1);
	}

	private static TreeMap<Integer, Integer> top_view = new TreeMap<>();
	// If you can pre-run and find the maximum span, create an 
	// array of that size and you can switch to ArrayList 

	public static void topView(Node root) {
		if(root!=null) preOrder(root, 0);
		for (Map.Entry<Integer, Integer> entry : top_view.entrySet()) {
			Integer value = entry.getValue();
			System.out.print(value+" ");
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
		Node root = new Node(3);
		root.left = new Node(5);
		root.right = new Node(2);

		root.left.right = new Node(4);
		root.right.left = new Node(6);
		root.right.right = new Node(7);

		root.left.right.left = new Node(9);
		root.right.right.left = new Node(8);

		root.left.right.left.left = new Node(1);

		topView(root);
	}

}
