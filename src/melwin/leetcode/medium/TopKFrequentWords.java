package melwin.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

// Priority Queue | String

public class TopKFrequentWords {
	public static List<String> topKFrequent(String[] words, int k) {
		HashMap<String, Integer> word_count = new HashMap<>();
		for (String w : words) {
			word_count.put(w, word_count.getOrDefault(w, 0) + 1);
		}
		PriorityQueue<String> min_heap = new PriorityQueue<>(k, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if (word_count.get(o1) == word_count.get(o2)) {
					return -o1.compareTo(o2);
				} else {
					return word_count.get(o1) - word_count.get(o2);
				}
			}
		});
		String[] keys = new String[word_count.size()];
		keys = word_count.keySet().toArray(keys);
		Arrays.sort(keys);
		for (String w : keys) {
			if (min_heap.size() < k) {
				min_heap.add(w);
			} else {
				if (word_count.get(w) > word_count.get(min_heap.peek())) {
					min_heap.poll();
					min_heap.add(w);
				}
			}
		}
		List<String> result = new ArrayList<String>();
		for (int i = 0; i < k; i++) {
			result.add(0, min_heap.poll());
		}
		return result;
	}

	public static void main(String[] args) {
		String[] words = { "the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is" };
		System.out.println(topKFrequent(words, 4));

		words = new String[] { "i", "love", "leetcode", "i", "love", "coding" };
		System.out.println(topKFrequent(words, 2));
		
		words = new String[] { "i", "love", "leetcode", "i", "love", "coding" };
		System.out.println(topKFrequent(words, 1));
	}

}
