package melwin.learning.collections.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/*
 * Learning Java Series : Collections : Set : HashSet
 * Author : Melwin Jose
 *
 */

public class LearningHashSet {

	private static class Element {
		int roll_no;
		public Element(int r){
			roll_no=r;
		}
		
		// hashCode() is used to find the bucket
		@Override
		public int hashCode() {
			System.out.println("hashCode for "+roll_no);
			return roll_no%10;
		}

		// equals() is used to check if objects 
		// are equal
		@Override
		public boolean equals(Object obj) {
			System.out.println("equals("+roll_no+","+((Element)obj).roll_no+")");
			return roll_no==(((Element)obj).roll_no);
		}

/*
The contract between equals() and hashCode() is: 
-	If two objects are equal, then they must have the same hash code.
-	If two objects have the same hash code, they may or may not be equal.

NOTE : 	HashSet is backed by HashMap, so the Keys are the Elements
		and values are all references to the SAME dummy objects.
		Highlighted in the image
*/
		
		/* Default equals()
			public boolean equals(Object obj) {
				// checks if obj are equal
				return super.equals(obj);
			}
		*/
	}
	 
	public static void main(String[] args) {
		Set<Element> ts = new HashSet<Element>();
		
		System.out.println("Going to add : new Element(1)");
		if(ts.add(new Element(1))) System.out.println("new Element(1) added");
		// hashCode = 1, goes to bucket-1
		
		System.out.println("\nGoing to add : new Element(11)");
		if(ts.add(new Element(11))) System.out.println("new Element(11) added");
		// hashCode = 1, goes to bucket-1
		// Since the objects the different insertion is successful
		
		System.out.println("\nGoing to add : new Element(2)");
		if(ts.add(new Element(2))) System.out.println("new Element(2) added");
		// hahsCode = 2, goes to bucket-2
		
		System.out.println("\nGoing to add : Element three");
		Element three = new Element(3);
		if(ts.add(three)) System.out.println("three added");
		// hahsCode = 3, goes to bucket-3
		
		System.out.println("\nGoing to add : Element three");
		if(ts.add(three)) System.out.println("three added");
		// hahsCode = 3, goes to bucket-3
		// but since the elements are equal(same roll-no), insertion fails
		// Would also FAIL with the default equals(), as the same objects are used
		
		System.out.println("\nGoing to add : new Element(3)");
		if(ts.add(new Element(3))) System.out.println("new Element(1) added");
		// hahsCode = 3, goes to bucket-3
		// but since the elements are equal(same roll-no), insertion fails
		// Would PASS with the default equals(), as different objects are used
		
		System.out.print("\nSet : ");
		Iterator<Element> i = ts.iterator();
		while(i.hasNext()){
			Element current = i.next();
			System.out.print(current.roll_no+" ");
			if(current.roll_no==11)	current.roll_no=0;
			// don't do this !!!
			// better remove the element and reinsert !!!
		}
		
		if(ts.contains(new Element(0))) System.out.println("contains zero");
		// won't work. 0 is the wrong bucket[1] and the above
		// search look in bucket[0]
		
	}

}