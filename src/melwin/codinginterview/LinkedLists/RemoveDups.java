package melwin.codinginterview.LinkedLists;

import java.util.Iterator;
import java.util.LinkedList;

/*
 * Chapter 2 : Linked Lists
 * Question  : 2.1
 */

public class RemoveDups {

	public static void main(String[] args) {
		LinkedList<Integer> ll = new LinkedList<>();
		ll.add(0);	ll.add(1);	ll.add(2);
		ll.add(3);	ll.add(2);	ll.add(3);
		ll.add(4);	ll.add(5);	ll.add(6);
		ll.add(4);	ll.add(5);	ll.add(6);
		ll.add(7);	ll.add(8);	ll.add(9);
		
		System.out.println(ll.toString());
		
		for(int i=0;i<ll.size();i++){
			int current = ll.get(i);
			Iterator<Integer> iterator = ll.listIterator(i+1);
			while(iterator.hasNext()){
				int x = iterator.next();
				if(x==current) iterator.remove();
			}
		}
		
		System.out.println(ll.toString());
	}

}
