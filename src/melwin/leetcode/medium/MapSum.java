package melwin.leetcode.medium;

import java.util.HashMap;

// TRIE

public class MapSum {
	private class Node {
		HashMap<Character, Node> children;
		int value;

		public Node() {
			children = new HashMap<>();
			value = 0;
		}
	}

	private Node root;

	public MapSum() {
		root = new Node();
	}

	public void insert(String key, int val) {
		Node parent = root;
		for (char c : key.toCharArray()) {
			if (parent.children.containsKey(c)) {
				parent = parent.children.get(c);
			} else {
				Node node = new Node();
				parent.children.put(c, node);
				parent = node;
			}
		}
		parent.value = val;
	}

	public int sum(String prefix) {
		Node node = root;
		for (char c : prefix.toCharArray()) {
			if (node.children.containsKey(c)) {
				node = node.children.get(c);
			}
		}
		return getSum(node);
	}

	private int getSum(Node node) {
		int sum = node.value;
		for (char c : node.children.keySet()) {
			sum += getSum(node.children.get(c));
		}
		return sum;
	}

	public static void main(String[] args) {
		MapSum mp = new MapSum();
		mp.insert("apple", 3);
		System.out.println(mp.sum("ap"));
		mp.insert("app", 2);
		System.out.println(mp.sum("ap"));
	}

}
