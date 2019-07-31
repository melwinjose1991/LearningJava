package melwin.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Stacks || Medium

public class AstriodCollision {
	public static int[] asteroidCollision(int[] asteroids) {
		List<Integer> stack = new ArrayList<Integer>();
		for (int n : asteroids) {
			if (stack.size() == 0) {
				stack.add(n);
			} else {
				boolean push_n = true;
				while (stack.size() > 0 && stack.get(stack.size() - 1) > 0 && n < 0) {
					int peek_mag = Math.abs(stack.get(stack.size() - 1));
					if (peek_mag > Math.abs(n)) {
						push_n = false;
						break;
					} else if (peek_mag == Math.abs(n)) {
						stack.remove(stack.size() - 1);
						push_n = false;
						break;
					} else {
						stack.remove(stack.size() - 1);
					}
				}
				if (push_n) {
					stack.add(n);
				}
			}
		}
		int[] res = new int[stack.size()];
		for (int i = 0; i < stack.size(); i++) {
			res[i] = stack.get(i);
		}
		return res;
	}

	public static void main(String[] args) {
		int[] asteroids = { 10, 2, -5 };
		System.out.println(Arrays.toString(asteroidCollision(asteroids)));

		asteroids = new int[] { -2, -1, 1, 2 };
		System.out.println(Arrays.toString(asteroidCollision(asteroids)));

		asteroids = new int[] { 8, -8 };
		System.out.println(Arrays.toString(asteroidCollision(asteroids)));

		asteroids = new int[] { 5, 10, -5 };
		System.out.println(Arrays.toString(asteroidCollision(asteroids)));
	}

}
