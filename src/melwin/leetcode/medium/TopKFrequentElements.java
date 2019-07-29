package melwin.leetcode.medium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class TopKFrequentElements {
	public static List<Integer> topKFrequent(int[] nums, int k) {
		HashMap<Integer, Integer> char_count = new HashMap<>();
		for (int n : nums) {
			int count = char_count.getOrDefault(n, 0);
			char_count.put(n, count + 1);
		}
		PriorityQueue<Integer> pq = new PriorityQueue<>(k, new Comparator<Integer>() {
			@Override
			public int compare(Integer arg0, Integer arg1) {
				return char_count.get(arg1) - char_count.get(arg0);
			}
		});
		for (int n : char_count.keySet()) {
			pq.add(n);
		}
		List<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i < k; i++) {
			result.add(pq.poll());
		}
		return result;
	}

	public static void main(String[] args) {
		int[] nums = { 1 };
		System.out.println(topKFrequent(nums, 1));
	}

}
