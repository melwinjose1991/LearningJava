package melwin.leetcode;

import java.util.HashMap;
import java.util.Random;

// ||LEET CODE|| ||INSERT DELETE GETRANDOM||
// ||O(1)|| ||DOUBLE HASH MAP||

public class Analyzed_RandomizedSet {

	HashMap<Integer, Integer> map1;
	HashMap<Integer, Integer> map2;
	Random rand;

	/** Initialize your data structure here. */
	public Analyzed_RandomizedSet() {
		// key-index
		map1 = new HashMap<Integer, Integer>();

		// index-key
		map2 = new HashMap<Integer, Integer>();

		rand = new Random(System.currentTimeMillis());
	}

	/**
	 * Inserts a value to the set. Returns true if the set did not already
	 * contain the specified element.
	 */
	public boolean insert(int val) {
		if (map1.containsKey(val)) {
			return false;
		} else {
			map1.put(val, map1.size());
			map2.put(map2.size(), val);
		}
		return true;
	}

	/**
	 * Removes a value from the set. Returns true if the set contained the
	 * specified element.
	 */
	public boolean remove(int val) {
		if (map1.containsKey(val)) {
			int index = map1.get(val);

			// remove the entry from both maps
			map1.remove(val);
			map2.remove(index);

			if (map1.size() == 0) {
				return true;
			}

			// if last is deleted, do nothing
			if (index == map1.size()) {
				return true;
			}

			// update the last element's index as
			// the index of the deleted element
			int key1 = map2.get(map2.size());

			map1.put(key1, index);
			map2.remove(map2.size());
			map2.put(index, key1);

		} else {
			return false;
		}

		return true;
	}

	/** Get a random element from the set. */
	public int getRandom() {
		if (map1.size() == 0) {
			return -1;
		}

		if (map1.size() == 1) {
			return map2.get(0);
		}

		return map2.get(new Random().nextInt(map1.size()));
		// return 0;
	}
}
