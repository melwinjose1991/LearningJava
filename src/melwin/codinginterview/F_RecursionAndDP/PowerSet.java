package melwin.codinginterview.F_RecursionAndDP;

import java.util.ArrayList;

// ||POWER SET|| ||O(2^n)|| ||RECURSION||

public class PowerSet {

	public static ArrayList<ArrayList<Character>> getPowerSet(ArrayList<Character> items, int index) {
		if (items.size() == index) {
			ArrayList<Character> empty_set = new ArrayList<Character>();
			ArrayList<ArrayList<Character>> new_set = new ArrayList<ArrayList<Character>>();
			new_set.add(empty_set);
			return new_set;
		}

		ArrayList<ArrayList<Character>> new_set = new ArrayList<ArrayList<Character>>();
		ArrayList<ArrayList<Character>> old_set = getPowerSet(items, index + 1);
		for (ArrayList<Character> set : old_set) {
			ArrayList<Character> with_index = new ArrayList<>(set);
			with_index.add(items.get(index));

			new_set.add(with_index);
			new_set.add(set);
		}

		return new_set;
	}

	public static void main(String[] args) {
		ArrayList<Character> items = new ArrayList<>();
		items.add('a');
		items.add('b');
		items.add('c');

		ArrayList<ArrayList<Character>> powersets = getPowerSet(items, 0);

		for (ArrayList<Character> set : powersets) {
			System.out.println(set);
		}
	}

}
