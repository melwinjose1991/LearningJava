package melwin.leetcode.medium;

import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

// LEETCODE - 71 - Simplify Path - O(n)
// Stack 

public class SimplifyPath {

	public String simplifyPath(String path) {

		Deque<String> stack = new LinkedList<>();
		Set<String> skip = new HashSet<>(Arrays.asList("..", ".", ""));

		for (String dir : path.split("/")) {

			if (dir.equals("..") && !stack.isEmpty())
				stack.pop();
			else if (!skip.contains(dir))
				stack.push(dir);

		}

		String res = "";
		for (String dir : stack)
			res = "/" + dir + res;

		return res.isEmpty() ? "/" : res;
	}

	public static void main(String[] args) {
	}

}
