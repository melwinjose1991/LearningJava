package melwin.codinginterview.C_StacksAndQueues;

import java.util.Arrays;
import java.util.Stack;

// ||CRACKING|| ||SORT STACK|| ||STACK FILTER||
// ||O(n^2)||

public class SortStack {

	// O(n^2) time and O(n) space
	public static Stack<Integer> sortStack(Stack<Integer> s1) {
		Stack<Integer> s2 = new Stack<Integer>();
		while (!s1.isEmpty()) {
			int s1_top_element = s1.pop();
			while (!s2.isEmpty() && s1_top_element < s2.peek()) {
				s1.push(s2.pop());
			}
			s2.push(s1_top_element);
		}
		return s2;
	}

	public static void main(String[] args) {
		Integer[] array = { 2, 6, 5, 4, 1, 3, 8, 7 };
		Stack<Integer> stack = new Stack<Integer>();
		stack.addAll(Arrays.asList(array));
		System.out.println(sortStack(stack));
	}
}
