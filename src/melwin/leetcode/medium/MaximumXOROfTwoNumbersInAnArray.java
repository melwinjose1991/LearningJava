package melwin.leetcode.medium;

// 421 - Maximum XOR Of Two Numbers In An Array - O(n)
// Use Trie to store bit representation of the num

public class MaximumXOROfTwoNumbersInAnArray {
	
	public int findMaximumXOR(int[] nums) {
		
		if (nums == null || nums.length == 0) {
			return 0;
		}
		
		// Init Trie.
		Object[] root = { null, null };
		for (int num : nums) {
			Object[] curNode = root;
			for (int i = 31; i >= 0; i--) {
				int curBit = (num >>> i) & 1;
				if (curNode[curBit] == null) {
					curNode[curBit] = new Object[] { null, null };
				}
				curNode = (Object[]) curNode[curBit];
			}
		}
		
		int max = Integer.MIN_VALUE;
		for (int num : nums) {
			Object[] curNode = root;
			int curSum = 0;
			for (int i = 31; i >= 0; i--) {
				int curBit = (num >>> i) & 1;
				if (curNode[curBit ^ 1] != null) {
					curSum += (1 << i);
					curNode = (Object[]) curNode[curBit ^ 1];
				} else {
					curNode = (Object[]) curNode[curBit];
				}
			}
			max = Math.max(curSum, max);
		}
		
		return max;
	}

	public static void main(String[] args) {
	}

}
