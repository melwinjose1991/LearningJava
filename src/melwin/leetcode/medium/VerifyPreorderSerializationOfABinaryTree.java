package melwin.leetcode.medium;

import java.util.Stack;

// Stack

public class VerifyPreorderSerializationOfABinaryTree {
	public static boolean isValidSerialization(String preorder) {
		Stack<String> stack = new Stack<>();
		for (String c : preorder.split(",")) {
			if (!c.equals("#")) {
				stack.push(c);
			} else {
				stack.push(c);
				while (stack.peek().equals("#") && stack.size() >= 3 && stack.get(stack.size() - 2).equals("#")) {
					stack.pop();
					stack.pop();
                    if(stack.peek().equals("#"))
						return false;
					stack.pop();
					stack.push("#");
				}
			}
		}
		if(stack.size()==1 && stack.peek().equals("#")) {
			return true;
		}else {
			return false;
		}
	}

	public static void main(String[] args) {
		System.out.println(isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
		System.out.println(isValidSerialization("1,#"));
		System.out.println(isValidSerialization("9,#,#,1"));
		System.out.println(isValidSerialization("1,#,#,#,#"));
	}

}
