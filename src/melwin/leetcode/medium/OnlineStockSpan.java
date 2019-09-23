package melwin.leetcode.medium;

import java.util.Stack;

// Stack | Monotone | XXX

public class OnlineStockSpan {
	class StockSpanner {

		private Stack<int[]> stack;

		public StockSpanner() {
			stack = new Stack<>();
		}

		public int next(int price) {
			int res = 1;
			while (!stack.isEmpty() && stack.peek()[0] <= price)
				res += stack.pop()[1];
			stack.push(new int[] { price, res });
			return res;
		}
	}

	public static void main(String[] args) {
	}

}
