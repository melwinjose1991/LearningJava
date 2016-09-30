package melwin.hackerrank.practice.java.DataStructures;

import java.util.Scanner;
import java.util.Stack;

public class JavaStack {
	public static void main(String[] argh) {
		Scanner sc = new Scanner(System.in);
		Stack<Character> stack;
		boolean printed = false;

		while (sc.hasNext()) {
			String input = sc.next();
			stack = new Stack<>();
			printed = false;
			for (int i = 0; i < input.length(); i++) {
				char ch = input.charAt(i);
				if (ch == '(' || ch == '[' || ch == '{') {
					stack.push(ch);
				} else if (!stack.isEmpty()) {
					char popped = stack.pop();
					if ((ch == ')' && popped != '(') || (ch == ']' && popped != '[') || (ch == '}' && popped != '{')) {
						System.out.println("false");
						printed = true;
						break;
					}
				} else {
					// check if empty is being popped
					System.out.println("false");
					printed = true;
					break;
				}
			}
			if (!printed) {
				if (stack.isEmpty())
					System.out.println("true");
				else
					System.out.println("false");
			}
		}

	}
}
