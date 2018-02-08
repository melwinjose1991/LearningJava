package melwin.leetcode.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

// 496 - Next Greater Element I - O(n) - use stack to find next greater element

public class NextGreaterElementI {

	public int[] nextGreaterElement(int[] findNums, int[] nums) {
		
		Map<Integer, Integer> map = new HashMap<>(); 
		Stack<Integer> stack = new Stack<>();
		
		for (int num : nums) {
			while (!stack.isEmpty() && stack.peek() < num)
				map.put(stack.pop(), num);
			stack.push(num);
		}
		
		for (int i = 0; i < findNums.length; i++)
			findNums[i] = map.getOrDefault(findNums[i], -1);
		
		return findNums;
	}

	public static void main(String[] args) {
	}

}
