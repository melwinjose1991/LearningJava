package melwin.leetcode;

import java.util.Stack;

// ||STACK|| ||O(n)|| ||HISTOGRAM|| ||NEW TECHNIQUE||
// ||GEOMETRY|| ||SELECTIVE PUSH|| ||PUSH POSITION||

public class Anaylzed_LargestRectangleInHistogram {

	// source : http://www.geeksforgeeks.org/largest-rectangle-under-histogram/
	public int largestRectangleArea(int[] heights) {
		if (heights == null || heights.length == 0) {
			return 0;
		}

		// Create an empty stack. The stack holds indexes of hist[] array
		// The bars stored in stack are always in increasing order of their
		// heights.
		Stack<Integer> stack = new Stack<Integer>();

		int max = 0;
		int i = 0;

		while (i < heights.length) {
			// push index to stack when the current height is larger than the
			// previous one
			if (stack.isEmpty() || heights[i] >= heights[stack.peek()]) {
				stack.push(i);
				i++;
			} else {
				// If this bar is lower than top of stack, then calculate area
				// of rectangle with stack top as the smallest (or minimum
				// height) bar. 'i' is 'right index' for the top and element
				// before top in stack is 'left index'

				int p = stack.pop();
				int h = heights[p];
				int w = stack.isEmpty() ? i : i - stack.peek() - 1;
				max = Math.max(h * w, max);
			}

		}

		while (!stack.isEmpty()) {
			int p = stack.pop();
			int h = heights[p];
			int w = stack.isEmpty() ? i : i - stack.peek() - 1;
			max = Math.max(h * w, max);
		}

		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
