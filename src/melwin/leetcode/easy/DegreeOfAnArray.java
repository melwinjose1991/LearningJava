package melwin.leetcode.easy;

import java.util.Hashtable;
import java.util.Map;

// 697 - Degree Of An Array - O(n)
// [0]=count, [1]=start_index, [2]=end_index
public class DegreeOfAnArray {

	public int findShortestSubArray(int[] nums) {
		Map<Integer, int[]> db = new Hashtable<>();
		int size = nums.length;
		int degree = 0;
		int smallestSubarray = 50001;
		for (int i = 0; i < size; i++) {
			int[] data;
			if (db.containsKey(nums[i])) {
				data = db.get(nums[i]);
			} else {
				data = new int[3];
				data[1] = i;
			}
			data[2] = i;
			data[0] += 1;

			db.put(nums[i], data);
			if (data[0] > degree) {
				degree = data[0];
				smallestSubarray = data[2] - data[1] + 1;
			} else if (degree == data[0]) {
				smallestSubarray = data[2] - data[1] + 1 < smallestSubarray ? data[2] - data[1] + 1 : smallestSubarray;
			}
		}

		return smallestSubarray;
	}

	public static void main(String[] args) {
	}

}
