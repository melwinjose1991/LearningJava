package melwin.leetcode.medium;

import java.util.Stack;

// Stack 

public class LongestAbsoluteFilePath {
	public static int lengthLongestPath(String input) {
		Stack<String> stack = new Stack<>();
		String[] words = input.split("\n");
		String longest = "";
		for (String w : words) {
			if (w.contains(".")) {
				int tabs = getTabCount(w);
				StringBuilder path = new StringBuilder();
				for (int i = 0; i < tabs; i++) {
					path.append(stack.get(i).replace("\t", "") + "/");
				}
				path.append(w.replace("\t", ""));
				if (path.length() > longest.length()) {
					longest = path.toString();
				}
			} else {
				while (stack.size() > 0 && getTabCount(stack.peek()) >= getTabCount(w)) {
					stack.pop();
				}
				stack.push(w);
			}
		}
		return longest.length();
	}

	private static int getTabCount(String str) {
		return str.length() - str.replace("\t", "").length();
	}

	public static void main(String[] args) {
		System.out.println(lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"));
		System.out.println(lengthLongestPath("dir\n\tfile.txt"));
		System.out.println(lengthLongestPath("dir\n        file.txt"));
	}

}
