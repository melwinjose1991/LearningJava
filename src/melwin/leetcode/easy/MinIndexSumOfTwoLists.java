package melwin.leetcode.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MinIndexSumOfTwoLists {
	public String[] findRestaurant(String[] list1, String[] list2) {
		HashMap<String, Integer> map_1 = new HashMap<>();
		for (int i = 0; i < list1.length; i++) {
			map_1.put(list1[i], i);
		}
		HashMap<String, Integer> map_2 = new HashMap<>();
		int min_sum = Integer.MAX_VALUE;
		List<String> result_list = new ArrayList<>();
		for (int i = 0; i < list2.length; i++) {
			if (map_1.containsKey(list2[i])) {
				map_2.put(list2[i], i + map_1.get(list2[i]));
				int sum = map_2.get(list2[i]);
				if (sum < min_sum) {
					min_sum = sum;
					result_list = new ArrayList<>();
					result_list.add(list2[i]);
				} else if (sum == min_sum) {
					result_list.add(list2[i]);
				}

			}
		}
		String[] result_str = new String[result_list.size()];
		for (int i = 0; i < result_list.size(); i++) {
			result_str[i] = result_list.get(i);
		}
		return result_str;
	}

	public static void main(String[] args) {
	}

}
