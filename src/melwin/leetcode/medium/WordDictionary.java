package melwin.leetcode.medium;

import java.util.HashMap;

// Trie

public class WordDictionary {

	private class Node {
		public HashMap<Character, Node> children;
		public boolean word_end;

		public Node() {
			children = new HashMap<>();
		}
	}

	private Node root;

	public WordDictionary() {
		root = new Node();
	}

	public void addWord(String word) {
		Node node = root;
		for (int i = 0; i < word.length(); i++) {
			if (!node.children.containsKey(word.charAt(i))) {
				node.children.put(word.charAt(i), new Node());
			}
			node = node.children.get(word.charAt(i));
		}
		node.word_end = true;
	}

	public boolean search(String word) {
		return searchHelper(root, word, 0);
	}

	private boolean searchHelper(Node node, String word, int i) {
		if (i == word.length()) {
			if (node.word_end)
				return true;
			else
				return false;
		}

		char c = word.charAt(i);
		if (c == '.') {
			for (char key : node.children.keySet()) {
				if (searchHelper(node.children.get(key), word, i + 1))
					return true;
			}
			return false;
		} else {
			if (node.children.containsKey(c))
				return searchHelper(node.children.get(c), word, i + 1);
			else
				return false;
		}
	}

	public static void main(String[] args) {
		WordDictionary dict = new WordDictionary();
		dict.addWord("bad");
		dict.addWord("dad");
		dict.addWord("mad");

		System.out.println(dict.search("pad"));
		System.out.println(dict.search("bad"));
		System.out.println(dict.search(".ad"));
		System.out.println(dict.search("b.."));
		System.out.println(dict.search(".ad") + "\n");

		dict = new WordDictionary();
		dict.addWord("at");
		dict.addWord("and");
		dict.addWord("an");
		dict.addWord("add");

		System.out.println(dict.search("a"));
		System.out.println(dict.search(".at"));
		System.out.println(dict.search("bat"));
		System.out.println(dict.search("an"));
	}

}
