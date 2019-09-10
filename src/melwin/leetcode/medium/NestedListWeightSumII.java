package melwin.leetcode.medium;

import java.util.List;

// List | Recursion

public class NestedListWeightSumII {
	public interface NestedInteger {

		// @return true if this NestedInteger holds a single integer, rather than a
		// nested list.
		public boolean isInteger();

		// @return the single integer that this NestedInteger holds, if it holds a
		// single integer
		// Return null if this NestedInteger holds a nested list
		public Integer getInteger();

		// Set this NestedInteger to hold a single integer.
		public void setInteger(int value);

		// Set this NestedInteger to hold a nested list and adds a nested integer to it.
		public void add(NestedInteger ni);

		// @return the nested list that this NestedInteger holds, if it holds a nested
		// list
		// Return null if this NestedInteger holds a single integer
		public List<NestedInteger> getList();
	}

	private int total_sum, max_depth;

	public int depthSumInverse(List<NestedInteger> nested_list) {
		max_depth = 0;
		getDepth(nested_list, 1);

		total_sum = 0;
		for (int i = 0; i < nested_list.size(); i++) {
			NestedInteger ele = nested_list.get(i);
			if (ele.getInteger() != null) {
				total_sum += (ele.getInteger() * max_depth);
			} else {
				total_sum += getSum(ele.getList(), max_depth - 1);
			}
		}
		return total_sum;
	}

	private int getSum(List<NestedInteger> list, int depth) {
		int sum = 0;
		for (int i = 0; i < list.size(); i++) {
			NestedInteger ele = list.get(i);
			if (ele.getInteger() != null) {
				sum += (depth * ele.getInteger());
			} else {
				sum += getSum(ele.getList(), depth - 1);
			}
		}
		return sum;
	}

	private void getDepth(List<NestedInteger> list, int depth) {
		max_depth = Math.max(max_depth, depth);
		for (int i = 0; i < list.size(); i++) {
			NestedInteger ele = list.get(i);
			if (ele.getInteger() == null) {
				getDepth(ele.getList(), depth + 1);
			}
		}
	}

	public static void main(String[] args) {
	}

}
