package melwin.leetcode.medium;

import java.util.Stack;

// Stack

public class EvaluateReversePolishNotation {
	public static int evalRPN(String[] tokens) {
		Stack<Integer> stack = new Stack<>();
		for (String t : tokens) {
			if (isOperation(t)) {
				int b = stack.pop();
				int a = stack.pop();
				int c = doOperation(a, b, t);
				stack.push(c);
			} else {
				int n = Integer.valueOf(t);
				stack.push(n);
			}
		}
		return Integer.valueOf(stack.pop());
	}

	private static int doOperation(int a, int b, String op) {
		int c = 0;
		if (op.equals("+"))
			c = a + b;
		if (op.equals("-"))
			c = a - b;
		if (op.equals("*"))
			c = a * b;
		if (op.equals("/"))
			c = a / b;
		return c;
	}

	private static boolean isOperation(String t) {
		if (t.equals("+") || t.equals("-") || t.equals("*") || t.equals("/")) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		String[] tokens = { "2", "1", "+", "3", "*" };
		System.out.println(evalRPN(tokens));

		tokens = new String[] { "10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+" };
		System.out.println(evalRPN(tokens));
	}

}
