package melwin.leetcode.medium;

public class Q3 {

	// 1
	static String mergeStrings(String a, String b) {

		if (a == null && b == null) {
			return null;
		} else if (a == null) {
			return new String(b);
		} else if (b == null) {
			return new String(a);
		}

		StringBuilder sb = new StringBuilder();
		int i, j, k;
		for (i = 0, j = 0, k = 0; i < a.length() && j < b.length(); k++) {
			if (k % 2 == 0) {
				sb.append(a.charAt(i++));
			} else {
				sb.append(b.charAt(j++));
			}
		}

		if (i == a.length() && j == b.length()) {
			return new String(sb);
		} else if (i == a.length()) {
			return new String(sb.append(b.substring(j)));
		} else {
			return new String(sb.append(a.substring(i)));
		}
	}

	// 3
	public static class LinkedListNode {
		int val;
		LinkedListNode next;

		public LinkedListNode(int v) {
			val = v;
			next = null;
		}
	}

	static LinkedListNode removeNodes(LinkedListNode list, int x) {

		if (list == null)
			return list;

		LinkedListNode dummy = new LinkedListNode(0);
		dummy.next = list;
		LinkedListNode prev = dummy;
		while (list != null) {
			if (list.val > x) {
				prev.next = list.next;
				list = prev.next;
			} else {
				prev = list;
				list = list.next;
			}
		}

		return dummy.next;
	}

	// 4

	class Point2D {
		int x, y;

		public Point2D(int a, int b) {
			x = a;
			y = b;
		}

		public double dist2D(Point2D p) {
			return Math.sqrt(Math.pow(x - p.x, 2) + Math.pow(y - p.y, 2));
		}

		public void printDistance(double d) {
			System.out.println("2D distance = " + (int)Math.ceil(d));
		}
	}

	class Point3D extends Point2D {
		int z;

		public Point3D(int a, int b, int c) {
			super(a, b);
			z = c;
		}

		public double dist3D(Point3D p) {
			return Math.sqrt(Math.pow(x - p.x, 2) + Math.pow(y - p.y, 2) + Math.pow(z - p.z, 2));
		}

		public void printDistance(double d) {
			System.out.println("3D distance = " + (int)Math.ceil(d));
		}
	}


	public static void main(String[] args) {
	}

}
