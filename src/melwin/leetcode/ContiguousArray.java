package melwin.leetcode;

import java.util.HashMap;
import java.util.Map;

// ||Contiguous Array|| ||O(n)||
// ||DP|| ||Counting DP||

public class ContiguousArray {

	public int findMaxLength(int[] nums) {

		/* Changing all 0s to -1s, so that
		 * if 1s and 0s are of equal count
		 * they can add to zero
		 */
		
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0)
				nums[i] = -1;
		}

		Map<Integer, Integer> sumToIndex = new HashMap<>();
		sumToIndex.put(0, -1);
		int sum = 0, max = 0;

		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (sumToIndex.containsKey(sum)) {
				max = Math.max(max, i - sumToIndex.get(sum));
			} else {
				sumToIndex.put(sum, i);
			}
		}
		
		/*	if the sum exists in Map, that means all
		 *  numbers between ( sumToIndex.get(sum), i ]
		 *  add to zero. 
		 */

		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
