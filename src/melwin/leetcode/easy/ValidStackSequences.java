package melwin.leetcode.easy;

import java.util.Stack;

// Stack

public class ValidStackSequences {
	public static boolean validateStackSequences(int[] pushed, int[] popped) {
		Stack<Integer> stack = new Stack<>();
		int popped_i = 0;
		int pushed_i = 0;
		for (; pushed_i < pushed.length; pushed_i++) {
			int next_push = pushed[pushed_i];
			stack.push(next_push);
			while ((stack.size() > 0) && (stack.peek() == popped[popped_i])) {
				stack.pop();
				popped_i++;
			}
		}
		if (stack.size() == 0) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		int[] pushed = { 1, 2, 3, 4, 5 };
		int[] popped = { 4, 5, 3, 2, 1 };
		System.out.println(validateStackSequences(pushed, popped));

		pushed = new int[] { 1, 2, 3, 4, 5 };
		popped = new int[] { 4, 5, 3, 2, 1 };
		System.out.println(validateStackSequences(pushed, popped));
	}

}
