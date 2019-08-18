package melwin.leetcode.easy;

import java.util.Stack;

// Stack 

public class MinStack {

	private Stack<Integer> stack, min_stack;

	public MinStack() {
		stack = new Stack<>();
		min_stack = new Stack<>();
	}

	public void push(int x) {
		stack.push(x);
		if (min_stack.size() == 0 || x <= min_stack.peek())
			min_stack.push(x);
		else
			min_stack.push(min_stack.peek());
	}

	public void pop() {
		if (stack.size() > 0) {
			stack.pop();
			min_stack.pop();
		}
	}

	public int top() {
		if (stack.size() > 0)
			return stack.peek();
		else
			return -1;
	}

	public int getMin() {
		return min_stack.peek();
	}

	public static void main(String[] args) {
		MinStack minStack = new MinStack();
		minStack.push(-2);
		minStack.push(0);
		minStack.push(-3);
		System.out.println(minStack.getMin());
		minStack.pop();
		System.out.println(minStack.top());
		System.out.println(minStack.getMin());
	}

}
