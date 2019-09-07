package melwin.leetcode.medium;

import java.util.Stack;

// Stack | Monotone Stack | Preprocessing | XXX

public class SumOfSubarrayMinimums {
	public int sumSubarrayMins(int[] A) {

		Stack<int[]> prev_less_stack = new Stack<>();
		Stack<int[]> next_less_stack = new Stack<>();
		int[] left_dist = new int[A.length];
		int[] right_dist = new int[A.length];

		for (int i = 0; i < A.length; i++) {
			while (!prev_less_stack.isEmpty() && prev_less_stack.peek()[0] >= A[i]) {
				prev_less_stack.pop();
			}

			left_dist[i] = prev_less_stack.isEmpty() ? i + 1 : i - prev_less_stack.peek()[1];
			prev_less_stack.push(new int[] { A[i], i });

		}

		for (int i = A.length - 1; i >= 0; i--) {
			while (!next_less_stack.isEmpty() && next_less_stack.peek()[0] > A[i]) {
				next_less_stack.pop();
			}

			right_dist[i] = next_less_stack.isEmpty() ? A.length - i : next_less_stack.peek()[1] - i;
			next_less_stack.push(new int[] { A[i], i });
		}

		int ans = 0;
		int mod = 1000000007;
		for (int i = 0; i < A.length; i++) {
			ans = (ans + A[i] * left_dist[i] * right_dist[i]) % mod;
		}
		return ans;
	}

	public static void main(String[] args) {
	}

}
