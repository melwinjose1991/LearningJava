package melwin.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;

// Leetcode - 380 - Insert Delete GetRandom - O(1)
// HashMap + ArrayList + Random

public class InsertDeleteGetRandom {

	ArrayList<Integer> nums;
	HashMap<Integer, Integer> key_index_mapping;
	java.util.Random rand = new java.util.Random();

	public InsertDeleteGetRandom() {
		nums = new ArrayList<Integer>();
		key_index_mapping = new HashMap<Integer, Integer>();
	}

	public boolean insert(int val) {
		// always add the new element at the end of List
		boolean contain = key_index_mapping.containsKey(val);
		if (contain)
			return false;
		key_index_mapping.put(val, nums.size());
		nums.add(val);
		return true;
	}

	public boolean remove(int val) {
		boolean contain = key_index_mapping.containsKey(val);
		if (!contain)
			return false;
		int loc = key_index_mapping.get(val);
		if (loc < nums.size() - 1) {
			// Element to be deleted isn't the last
			// Copy the last element's value to loc
			int lastone = nums.get(nums.size() - 1);
			nums.set(loc, lastone);
			key_index_mapping.put(lastone, loc);
		}
		key_index_mapping.remove(val);
		nums.remove(nums.size() - 1);
		return true;
	}

	public int getRandom() {
		return nums.get(rand.nextInt(nums.size()));
	}

	public static void main(String[] args) {
	}

}
