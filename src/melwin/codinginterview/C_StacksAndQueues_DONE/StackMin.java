package melwin.codinginterview.C_StacksAndQueues;

import java.util.Stack;

public class StackMin extends Stack<Integer> {

	private Stack<Integer> min = new Stack<Integer>();

	public void push(int item) {
		if (min.isEmpty() || item < min()) {
			min.push(item);
		}
		super.push(item);
	}

	public Integer pop() {
		int item = super.pop();
		if (item == min()) {
			min.pop();
		}
		return item;
	}

	public Integer min() {
		return min.peek();
	}

	public static void main(String[] args) {
		StackMin stack = new StackMin();

		stack.push(2);
		System.out.println(stack.min());

		stack.push(-1);
		System.out.println(stack.min());

		stack.push(3);
		System.out.println(stack.min());

		stack.push(-10);
		System.out.println(stack.min());

		stack.pop();
		System.out.println(stack.min());

		stack.pop();
		System.out.println(stack.min());

		stack.push(-20);
		System.out.println(stack.min());

		stack.pop();
		System.out.println(stack.min());
	}
}
