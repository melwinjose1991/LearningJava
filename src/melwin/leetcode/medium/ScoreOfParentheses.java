package melwin.leetcode.medium;

import java.util.Stack;

// Stack

public class ScoreOfParentheses {
	public static int scoreOfParentheses(String S) {
		Stack<String> stack = new Stack<>();
		for (char c : S.toCharArray()) {
			if (c == '(') {
				stack.push(c + "");
			} else {
				if (stack.peek().equals("(")) {
					stack.pop();
					int cur_score = 1;
					while (!stack.isEmpty() && !stack.peek().equals("(")) {
						int pre_score = Integer.parseInt(stack.pop());
						cur_score = cur_score + pre_score;
					}
					stack.push(Integer.toString(cur_score));
				} else {
					int cur_score = 2 * (Integer.parseInt(stack.pop()));
					stack.pop();
					while (!stack.isEmpty() && !stack.peek().equals("(")) {
						int pre_score = Integer.parseInt(stack.pop());
						cur_score = cur_score + pre_score;
					}
					stack.push(Integer.toString(cur_score));
				}
			}
			// System.out.println(stack.toString());
		}
		return Integer.parseInt(stack.pop());
	}

	public static void main(String[] args) {
		System.out.println(scoreOfParentheses("()()(())"));
	}

}
