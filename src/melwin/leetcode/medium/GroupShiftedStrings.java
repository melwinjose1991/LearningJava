package melwin.leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupShiftedStrings {

	public static List<List<String>> groupStrings(String[] strings) {
		List<List<String>> result = new ArrayList<List<String>>();
		HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();

		for (String s : strings) {
			char[] arr = s.toCharArray();
			if (arr.length > 0) {
				int diff = arr[0] - 'a';
				for (int i = 0; i < arr.length; i++) {
					if (arr[i] - 'a' - diff < 0) {
						arr[i] = (char) (arr[i] - diff + 26);
					} else {
						arr[i] = (char) (arr[i] - diff);
					}

				}
			}

			String ns = new String(arr);
			System.out.println(ns);
			if (map.containsKey(ns)) {
				map.get(ns).add(s);
			} else {
				ArrayList<String> al = new ArrayList<String>();
				al.add(s);
				map.put(ns, al);
			}
		}

		for (Map.Entry<String, ArrayList<String>> entry : map.entrySet()) {
			Collections.sort(entry.getValue());
		}

		result.addAll(map.values());

		return result;
	}

	public static void main(String[] args) {
		System.out.println(groupStrings(new String[] { "ba" }));
	}

}
