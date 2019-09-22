package melwin.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

// DFS | Recursion | Strings

public class PalindromePartitioning {

	public static List<List<String>> partition(String s) {
		List<List<String>> result = new ArrayList<>();
		dfs(s, 0, result, new ArrayList<>());
		return result;
	}

	private static void dfs(String s, int i, List<List<String>> result, List<String> path) {
		if (i == s.length()) {
			if (path.size() > 0) {
				result.add(new ArrayList<>(path));
			}
		} else {
			for (int j = i; j < s.length(); j++) {
				if (isPalindrome(s, i, j)) {
					path.add(s.substring(i, j + 1));
					dfs(s, j + 1, result, path);
					path.remove(path.size() - 1);
				}
			}
		}
	}

	private static boolean isPalindrome(String str, int l, int r) {
		if (l == r)
			return true;
		while (l < r) {
			if (str.charAt(l) != str.charAt(r))
				return false;
			l++;
			r--;
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(partition("aab"));
	}

}
