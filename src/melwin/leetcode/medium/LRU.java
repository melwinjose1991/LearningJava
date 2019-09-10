package melwin.leetcode.medium;

import java.util.HashMap;

// Design | Cache

public class LRU {
	static class LRUCache {

		class Node {
			int key, value;
			Node before, after;

			Node(int k, int v) {
				key = k;
				value = v;
			}
		}

		private HashMap<Integer, Node> cache;
		private Node head, tail;
		private int max_size, size;

		public LRUCache(int capacity) {
			cache = new HashMap<>();
			max_size = capacity;
			size = 0;
			head = null;
			tail = null;
		}

		public int get(int key) {
			if (cache.containsKey(key)) {
				moveToFront(cache.get(key));
				return head.value;
			} else {
				return -1;
			}
		}

		public void put(int key, int value) {
			if (cache.containsKey(key)) {
				cache.get(key).value = value;
				moveToFront(cache.get(key));
			} else {
				Node n = new Node(key, value);
				cache.put(key, n);
				insertAtFront(n);
				size++;
				if (size > max_size) {
					if (tail != null)
						cache.remove(tail.key);
					removeFromTail();
					size = max_size;
				}
			}
		}

		private void insertAtFront(Node node) {
			if (head == null) {
				head = node;
				tail = node;
			} else {
				Node prev_head = head;
				prev_head.before = node;
				node.after = prev_head;
				head = node;
			}
		}

		private void removeFromTail() {
			if (tail != null) {
				Node second_last = tail.before;
				if (second_last == null) {
					head = null;
					tail = null;
				} else {
					second_last.after = null;
					tail.before = null;
					tail.after = null;
					tail = second_last;
				}
			}
		}

		private void moveToFront(Node n) {
			if (!head.equals(n)) {
				Node before = n.before;
				Node after = n.after;
				if (before != null) {
					before.after = after;
				}
				if (after != null) {
					after.before = before;
				}
				Node prev_head = head;
				prev_head.before = n;
				n.after = prev_head;
				n.before = null;
				head = n;
				if (tail.equals(n)) {
					tail = before;
				}
			}
		}

		private void printList() {
			Node n = head;
			System.out.print("\tList : ");
			while (n != null) {
				System.out.print(n.value + " ");
				n = n.after;
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		LRUCache cache = new LRUCache(2);

		cache.put(1, 1);
		cache.put(2, 2);
		System.out.println(cache.get(1)); // returns 1
		cache.put(3, 3); // evicts key 2
		System.out.println(cache.get(2)); // returns -1 (not found)
		cache.put(4, 4); // evicts key 1
		System.out.println(cache.get(1)); // returns -1 (not found)
		System.out.println(cache.get(3)); // returns 3
		System.out.println(cache.get(4)); // returns 4
	}

}
