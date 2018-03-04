package melwin.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

// 731 - My Calendar II

public class MyCalendarII {
	
	private List<int[]> bookings;
	private List<int[]> overlaps;

	public MyCalendarII() {
        bookings = new ArrayList<>();
        overlaps = new ArrayList<>();
    }

	public boolean book(int start, int end) {
		for (int[] bo : bookings) {
			int overlapStart = Math.max(bo[0], start), overlapEnd = Math.min(bo[1], end);
			if (overlapStart < overlapEnd) {
				for (int[] ov : overlaps) {
					if (Math.max(ov[0], overlapStart) < Math.min(ov[1], overlapEnd)) {
						overlaps.clear();
						return false;
					}
				}
				overlaps.add(new int[] { overlapStart, overlapEnd });
			}
		}
		bookings.add(new int[] { start, end });
		return true;
	}

	public static void main(String[] args) {
	}

}
