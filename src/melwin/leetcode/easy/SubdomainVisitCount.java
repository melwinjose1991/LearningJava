package melwin.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

// Strings | Hash Map

public class SubdomainVisitCount {
	public static List<String> subdomainVisits(String[] cpdomains) {
		HashMap<String, Integer> domain_count = new HashMap<>();
		for (String cpd : cpdomains) {
			String[] count_domain = cpd.split(" ");
			int count = Integer.parseInt(count_domain[0]);
			String[] domains = count_domain[1].split("\\.");
			String s = "";
			for (int i = domains.length - 1; i >= 0; i--) {
				s = domains[i] + (s.length() > 0 ? "." : "") + s;
				domain_count.put(s, domain_count.getOrDefault(s, 0) + count);
			}
		}
		List<String> result = new ArrayList<String>(domain_count.size());
		for (String key : domain_count.keySet()) {
			result.add(domain_count.get(key) + " " + key);
		}
		return result;
	}

	public static void main(String[] args) {
		String[] cpdomains = { "900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org" };
		System.out.println(subdomainVisits(cpdomains));
	}

}
