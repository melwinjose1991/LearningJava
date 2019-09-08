package melwin.leetcode.easy;

import java.util.Stack;

// Stack

public class RemoveAllAdjacentDuplicatesInString {
	public String removeDuplicates(String S) {
		Stack<Character> stack = new Stack<>();
		for (int i = S.length() - 1; i >= 0; i--) {
			char c = S.charAt(i);
			if (stack.size() > 0 && c == stack.peek()) {
				stack.pop();
			} else {
				stack.push(c);
			}
		}
		StringBuilder result = new StringBuilder(stack.size());
		while (!stack.isEmpty())
			result.append(stack.pop());
		return result.toString();

	}

	public static void main(String[] args) {
	}

}
