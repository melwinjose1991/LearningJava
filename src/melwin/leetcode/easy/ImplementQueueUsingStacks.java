package melwin.leetcode.easy;

import java.util.Stack;

// Stack | Queue

public class ImplementQueueUsingStacks {
	static class MyQueue {

		private Stack<Integer> left, right;

		public MyQueue() {
			left = new Stack<>();
			right = new Stack<>();
		}

		public void push(int x) {
			right.push(x);
		}

		public int pop() {
			if (left.isEmpty())
				copyLeft();
			return left.pop();
		}

		public int peek() {
			if (left.isEmpty())
				copyLeft();
			return left.peek();
		}

		public boolean empty() {
			return left.isEmpty() && right.isEmpty();
		}

		private void copyLeft() {
			while (!right.isEmpty()) {
				left.push(right.pop());
			}
		}
	}

	public static void main(String[] args) {
		MyQueue queue = new MyQueue();

		queue.push(1);
		queue.push(2);
		System.out.println(queue.peek()); // returns 1
		System.out.println(queue.pop()); // returns 1
		System.out.println(queue.empty()); // returns false
	}

}
