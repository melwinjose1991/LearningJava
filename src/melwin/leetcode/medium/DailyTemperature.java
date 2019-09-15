package melwin.leetcode.medium;

import java.util.Arrays;
import java.util.Stack;

// Stack 

public class DailyTemperature {
	public static int[] dailyTemperatures(int[] T) {
		Stack<Integer> stack = new Stack<>();
		int[] result = new int[T.length];
		for (int i = 0; i < T.length; i++) {
			while (!stack.isEmpty() && T[stack.peek()] < T[i]) {
				result[stack.peek()] = i - stack.peek();
				stack.pop();
			}
			stack.push(i);
		}
		return result;
	}

	public static void main(String[] args) {
		int[] T = { 73, 74, 75, 71, 69, 72, 76, 73 };
		System.out.println(Arrays.toString(dailyTemperatures(T)));
	}

}
