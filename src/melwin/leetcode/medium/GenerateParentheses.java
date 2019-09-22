package melwin.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

// Recursion | Strings

public class GenerateParentheses {
	public static List<String> generateParenthesis(int n) {
		List<String> result = new ArrayList<String>();
		dfs(0, 0, n, result, "");
		return result;
	}

	private static void dfs(int l, int r, int n, List<String> result, String str) {
		if (l == r && r == n) {
			result.add(str);
		} else {
			if (l < n)
				dfs(l + 1, r, n, result, str + "(");
			if (r < n && l > r)
				dfs(l, r + 1, n, result, str + ")");
		}
	}

	public static void main(String[] args) {
		System.out.println(generateParenthesis(2));
	}

}
