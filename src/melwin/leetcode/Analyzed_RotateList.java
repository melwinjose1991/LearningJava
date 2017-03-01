package melwin.leetcode;

public class Analyzed_RotateList {

	public ListNode rotateRight(ListNode head, int k) {
		if (head == null || head.next == null)
			return head;

		int n = 0;
		ListNode ptr = head;
		ListNode last=null;
		while (ptr != null) {
			last = ptr;
			ptr = ptr.next;
			n++;
		}
		k = k % n;
		if (k == 0)
			return head;

		ListNode new_last_node = head;
		for (int i = 1; i < (n - k); i++) {
			new_last_node = new_last_node.next;
		}
		//System.out.println(new_last_node.val);
		
		ListNode new_head = new_last_node.next;
		new_last_node.next = null;
		last.next = head;
		head = new_head;

		return head;
	}

	// Template
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
	
	public void printLinkeList(ListNode node){
		while(node!=null){
			System.out.print(node.val+" ");
			node = node.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		ListNode five = new ListNode(5);
		ListNode four = new ListNode(4);
		ListNode three = new ListNode(3);
		ListNode two = new ListNode(2);
		ListNode one = new ListNode(1);

		one.next = two;
		two.next = three;
		three.next = four;
		four.next = five;

		Analyzed_RotateList x = new Analyzed_RotateList();
		x.printLinkeList(x.rotateRight(one, 6));
	
	}

}
