package melwin.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;

// Random | Hash Map | XXX 

public class InsertDeleteGetRandom {
	ArrayList<Integer> nums;
	HashMap<Integer, Integer> locs;
	java.util.Random rand = new java.util.Random();

	public InsertDeleteGetRandom() { // Randomized Set
		nums = new ArrayList<Integer>();
		locs = new HashMap<Integer, Integer>();
	}

	public boolean insert(int val) {
		boolean contain = locs.containsKey(val);
		if (contain)
			return false;
		locs.put(val, nums.size());
		nums.add(val);
		return true;
	}

	public boolean remove(int val) {
		boolean contain = locs.containsKey(val);
		if (!contain)
			return false;
		int loc = locs.get(val);
		if (loc < nums.size() - 1) {
			// if the element to be deleted isn't the last one
			// swap it with last one
			int lastone = nums.get(nums.size() - 1);
			nums.set(loc, lastone);
			locs.put(lastone, loc);
		}
		// And delete the last element which is `val`
		locs.remove(val);
		nums.remove(nums.size() - 1);
		return true;
	}

	public int getRandom() {
		return nums.get(rand.nextInt(nums.size()));
	}
}
