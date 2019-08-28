package melwin.leetcode.easy;

import java.util.HashMap;

// Hash Map

public class TwoSumIII {
	private HashMap<Integer, Integer> set;

	public TwoSumIII() {
		set = new HashMap<>();
	}

	public void add(int number) {
		set.put(number, set.getOrDefault(number, 0) + 1);
	}

	public boolean find(int value) {
		for (int key : set.keySet()) {
			int diff = value - key;
			if (diff == key) {
				if (set.get(key) >= 2)
					return true;
			} else {
				if (set.containsKey(diff))
					return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		TwoSumIII ds = new TwoSumIII();
		ds.add(1);
		ds.add(3);
		ds.add(5);

		System.out.println(ds.find(4));
		System.out.println(ds.find(7));

		ds = new TwoSumIII();
		ds.add(0);
		System.out.println("\n" + ds.find(0));
		ds.add(0);
		System.out.println(ds.find(0));
		System.out.println(ds.find(4));
		ds.add(4);
		System.out.println(ds.find(0));
		System.out.println(ds.find(4));
	}

}
