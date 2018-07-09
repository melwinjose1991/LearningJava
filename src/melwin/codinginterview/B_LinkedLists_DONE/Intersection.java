package melwin.codinginterview.B_LinkedLists_DONE;

public class Intersection {

	public boolean checkIntersection(Node list1, Node list2) {
		int len1 = 0, len2 = 0;
		Node tmp1 = list1;
		while (tmp1 != null) {
			tmp1 = tmp1.next;
			len1++;
		}
		Node tmp2 = list2;
		while (tmp2 != null) {
			tmp2 = tmp2.next;
			len2++;
		}
		if (tmp1 != tmp2)
			return false;

		if (len1 > len2) {
			int diff = len1 - len2;
			tmp1 = list1;
			for (int i = 0; i < diff; i++) {
				tmp1 = tmp1.next;
			}
			tmp2 = list2;
		} else {
			int diff = len2 - len1;
			tmp2 = list2;
			for (int i = 0; i < diff; i++) {
				tmp2 = tmp2.next;
			}
			tmp1 = list1;
		}

		while (tmp1 != null && tmp2 != null) {
			if (tmp1 == tmp2)
				return true;
			tmp1 = tmp1.next;
			tmp2 = tmp2.next;
		}

		return false;
	}

	private static class Node {
		public Node next;
		public int val;

		Node(int val) {
			this.val = val;
			next = null;
		}
	}

	public static void main(String[] args) {
		Node a = new Node(1);
		Node b = new Node(2);
		Node c = new Node(3);
		Node d = new Node(4);
		Node e = new Node(5);
		Node f = new Node(6);

		e.next = f;
		d.next = e;
		a.next = d;
		c.next = d;
		b.next = c;

		Intersection x = new Intersection();
		System.out.println(x.checkIntersection(a, b));
	}

}
