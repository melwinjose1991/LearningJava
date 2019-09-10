package melwin.leetcode.easy;

import java.util.List;

// List | Recursion

public class NestedListWeightSum {
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

	private int total_sum;

	public int depthSum(List<NestedInteger> nested_list) {
		total_sum = 0;
		for (int i = 0; i < nested_list.size(); i++) {
			NestedInteger ele = nested_list.get(i);
			if (ele.getInteger() != null) {
				total_sum += ele.getInteger();
			} else {
				total_sum += getSum(ele.getList(), 2);
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
				sum += getSum(ele.getList(), depth + 1);
			}
		}
		return sum;
	}

	public static void main(String[] args) {
	}

}
