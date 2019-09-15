package melwin.leetcode.medium;

// Trie

public class ImplementTrie {

	static class Trie {
		class Node {
			Node[] children;
			boolean end;

			Node() {
				children = new Node[26];
				end = false;
			}
		}

		private Node root;

		public Trie() {
			root = new Node();
		}

		public void insert(String word) {
			Node n = root;
			for (char c : word.toCharArray()) {
				if (n.children[c - 'a'] == null) {
					n.children[c - 'a'] = new Node();
				}
				n = n.children[c - 'a'];
			}
			n.end = true;
		}

		public boolean search(String word) {
			Node n = root;
			for (char c : word.toCharArray()) {
				if (n.children[c - 'a'] == null) {
					return false;
				} else {
					n = n.children[c - 'a'];
				}
			}
			return n.end;
		}

		public boolean startsWith(String prefix) {
			Node n = root;
			for (char c : prefix.toCharArray()) {
				if (n.children[c - 'a'] == null) {
					return false;
				} else {
					n = n.children[c - 'a'];
				}
			}
			return dfs(n);
		}

		private boolean dfs(Node n) {
			if (n.end)
				return true;
			for (int i = 0; i < 26; i++) {
				if (n.children[i] != null) {
					if (dfs(n.children[i])) {
						return true;
					}
				}
			}
			return false;
		}
	}

	public static void main(String[] args) {
		Trie t = new Trie();
		t.insert("apple");
		System.out.println(t.search("apple"));
		System.out.println(t.search("app"));
		System.out.println(t.startsWith("app"));
		
		t.insert("app");
		System.out.println(t.search("app"));
		System.out.println(t.startsWith("app"));
	}

}
