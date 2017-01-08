package melwin.codinginterview.B_LinkedLists_DONE;

public class DeleteMiddleNode {

	public boolean deleteNode(LinkedListNode n) {
		if (n == null || n.next == null) {
			return false;
		}
		LinkedListNode next = n.next;
		n.val = next.val;
		n.next = next.next;
		return true;
	}

	private static class LinkedListNode {
		int val;
		LinkedListNode next;

		LinkedListNode(int val) {
			this.val = val;
			this.next = null;
		}
	}

	public static void main(String[] args) {
	}

}
