package melwin.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

// 721 - Accounts Merge - Union-Find

public class AccountsMerge {
	
	public List<List<String>> accountsMerge(List<List<String>> acts) {
		Map<String, String> owner = new HashMap<>();
		Map<String, String> parents = new HashMap<>();
		Map<String, TreeSet<String>> unions = new HashMap<>();

		// Make the first email-id the representative of each list
		for (List<String> a : acts) {
			for (int i = 1; i < a.size(); i++) {
				parents.put(a.get(i), a.get(i));
				owner.put(a.get(i), a.get(0));
			}
		}

		// If an email is present in a 2nd list, make the parent
		// of the representative of the 1st list to representative
		// email of the 2nd list.
		for (List<String> a : acts) {
			String p = find(a.get(1), parents);
			for (int i = 2; i < a.size(); i++)
				parents.put(find(a.get(i), parents), p);
		}

		// Collect and sort all emails with the same representative
		// email.
		for (List<String> a : acts) {
			String p = find(a.get(1), parents);
			if (!unions.containsKey(p))
				unions.put(p, new TreeSet<>());
			for (int i = 1; i < a.size(); i++)
				unions.get(p).add(a.get(i));
		}

		// Add onwer's name for each Union-Set
		List<List<String>> res = new ArrayList<>();
		for (String p : unions.keySet()) {
			List<String> emails = new ArrayList(unions.get(p));
			emails.add(0, owner.get(p));
			res.add(emails);
		}

		return res;
	}

	private String find(String s, Map<String, String> p) {
		return p.get(s) == s ? s : find(p.get(s), p);
	}

	public static void main(String[] args) {
	}

}
