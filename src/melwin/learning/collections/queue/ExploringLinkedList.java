package melwin.learning.collections.queue;

import java.util.LinkedList;

public class ExploringLinkedList {

	public static void main(String[] args) {
		LinkedList<Integer> ll = new LinkedList<Integer>();

		ll.add(1);
		ll.add(1);
		ll.add(2);
		ll.add(3);

		while (ll.peek() != null) {
			System.out.println(ll.poll());
		}
	}

}
