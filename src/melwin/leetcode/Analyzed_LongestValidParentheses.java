package melwin.leetcode;

import java.util.ArrayList;

// ||STACK|| ||PUSH POSITION|| ||PARENTHESES|| ||O(n)||
// ||DYNAMIC PROGRAMMING|| ||DP||

class Analyzed_LongestValidParentheses {

	public int longestValidParentheses(String s) {
		int n = s.length();
		int result = 0;
		ArrayList<Integer> stack = new ArrayList<>();
		stack.add(-1);

		for (int i = 0; i < n; i++) {
			if (s.charAt(i) == '(') {
				stack.add(i);
			} else {
				stack.remove(stack.size() - 1);
				if (stack.size() != 0) {
					result = Math.max(result, i - stack.get(stack.size() - 1));
				} else {
					stack.add(i);
				}
			}
		}

		return result;
	}

	public static void main(String[] args) {
		Analyzed_LongestValidParentheses x = new Analyzed_LongestValidParentheses();
		System.out.println(x.longestValidParentheses("(()()"));
	}
}