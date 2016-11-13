package melwin.hackerrank.practice.datastructures.linkedlists;

/*
 * ||CYCLE_DETECTION|| ||FLYOD_CYCLE_DETECTION||
 */

public class CycleDetection {

	private static class Node {
		int data;
		Node next;
	}

	private static boolean hasCycle(Node head) {
		if (head == null)
			return false;
		if (head.next == null)
			return false;
		if (head == head.next)
			return true;

		Node first = head;
		Node second = head.next;
		while (first != null && second != null) {
			if (first == second)
				return true;
			first = first.next;
			if (second.next == null)
				break;
			second = second.next.next;
		}

		return false;
	}

	public static void main(String[] args) {
	}

}
