package melwin.interviewhelp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

public class CheatSheet {

	public static void main(String[] args) {

		// ###### LIST ######
		// |= ARRAYLIST
		List<Integer> array_list = new ArrayList<Integer>();

		array_list.add(1); // adds at the end
		array_list.add(3);
		array_list.add(1, 2); // shifts elements

		array_list.get(0); // returns element at 0
		array_list.indexOf(1); // i/p:element o/p:first index
		array_list.remove(0); // i/p:index o/p:1

		System.out.println(array_list); // [2, 3]

		// |= LinkedList
		List<Integer> linked_list = new LinkedList<Integer>();

		linked_list.add(1); // adds at the end
		linked_list.add(3);
		linked_list.add(1, 2); // shifts elements

		linked_list.get(0); // returns element at 0
		linked_list.indexOf(1); // i/p:element o/p:first index
		linked_list.remove(0); // i/p:index o/p:1

		System.out.println(linked_list); // [2, 3]

		Queue<Integer> q = new LinkedList<Integer>();
		q.add(1);
		q.add(2);
		q.peek(); // 1 doesn't remove the head
		q.poll(); // 1 returns null when empty
		q.remove(); // 2 throws exception when empty
		q.isEmpty(); // true
		System.out.println(q);

		Random rand = new Random();
		System.out.println(rand.nextInt(10));
	}
}
