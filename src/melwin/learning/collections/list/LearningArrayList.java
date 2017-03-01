package melwin.learning.collections.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class LearningArrayList {

	public static void main(String[] args) {
		List<Integer> l = new ArrayList<>();
		
		l.add(1);	l.add(1);	l.add(2);	l.add(5);
		
		System.out.println(l);
		Iterator<Integer> i = l.iterator();
		while(i.hasNext()){
			System.out.println(i.next());
			i.remove();
		}
		System.out.println(l);

		l.add(1);	l.add(1);	l.add(2);	l.add(5);
		
		System.out.println(l);
		ListIterator<Integer> li = l.listIterator();
		while(li.hasNext()){
			if(li.next()==2){	
				li.add(3);
				li.add(4);
			}
		}
		System.out.println(l);
	}

}
