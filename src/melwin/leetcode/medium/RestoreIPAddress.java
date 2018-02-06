package melwin.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddress {
	
	public List<String> restoreIpAddresses(String s) {
		List<String> solutions = new ArrayList<String>();
		doDFS(s, solutions, 0, "", 0);
		return solutions;
	}

	private void doDFS(String ip, List<String> res, int start, String restored, int dots_used) {
		if (dots_used > 4)
			return;
		if (dots_used == 4 && start == ip.length())
			res.add(restored);

		for (int i = 1; i < 4; i++) {
			if (start + i > ip.length())
				break;
			
			String s = ip.substring(start, start + i);
			if ((s.startsWith("0") && s.length() > 1) || (i == 3 && Integer.parseInt(s) >= 256))
				continue;
			
			String so_far = restored + s + (dots_used == 3 ? "" : ".");
			doDFS(ip, res, start + i, so_far, dots_used + 1);
		}
	}

	public static void main(String[] args) {
	}

}
