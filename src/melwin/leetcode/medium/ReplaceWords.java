package melwin.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// TRIE

public class ReplaceWords {
	private static class Node {
		HashMap<Character, Node> children;

		public Node() {
			children = new HashMap<>();
		}
	}

	public static String replaceWords(List<String> dict, String sentence) {
		StringBuilder result = new StringBuilder();
		Node root = new Node();
		String[] splits = sentence.split(" ");
		for (String word : dict) {
			addToTRIE(root, word);
		}
		for (int i = 0; i < splits.length; i++) {
			String word = splits[i];
			List<String> replacement = new ArrayList<>();
			searchTRIE(root, 0, word, "", replacement);
			if (replacement.size() == 0) {
				result.append(word + ((i == splits.length - 1) ? "" : " "));
			} else {
				result.append(replacement.get(0) + ((i == splits.length - 1) ? "" : " "));
			}
		}
		return result.toString();
	}

	private static void addToTRIE(Node root, String s) {
		Node parent = root;
		for (char c : s.toCharArray()) {
			if (parent.children.containsKey(c)) {
				parent = parent.children.get(c);
			} else {
				Node node = new Node();
				parent.children.put(c, node);
				parent = node;
			}
		}
		parent.children.put('0', new Node());
	}

	private static void searchTRIE(Node node, int i, String s, String path, List<String> result) {
		if (node.children.containsKey('0') && path.length() > 0) {
			if (result.size() == 1) {
				String prev_smallest = result.get(0);
				if (path.length() < prev_smallest.length()) {
					result.set(0, path);
				}
			} else {
				result.add(path);
			}

		}
		if ((node.children.containsKey(s.charAt(i))) && (i + 1 <= s.length() - 1)) {
			char c = s.charAt(i);
			searchTRIE(node.children.get(c), i + 1, s, path + c, result);
		}
	}

	public static void main(String[] args) {
		Node root = new Node();
		addToTRIE(root, "bat");
		addToTRIE(root, "batt");
		addToTRIE(root, "rat");
		addToTRIE(root, "cat");

		List<String> r = new ArrayList<String>();
		searchTRIE(root, 0, "rock", "", r);
		// System.out.println(r.toString());

		List<String> dict = new ArrayList<>();
		dict.add("a");
		dict.add("aa");
		dict.add("aaa");
		dict.add("aaaa");
		String sentence = "a aa a aaaa aaa aaa aaa aaaaaa bbb baba ababa";
		System.out.println(replaceWords(dict, sentence));
	}

}
