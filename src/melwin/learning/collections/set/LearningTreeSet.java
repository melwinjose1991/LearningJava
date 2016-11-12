package melwin.learning.collections.set;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class LearningTreeSet {

	private static class Student implements Comparable<Student>{
		public int roll_no;

		public Student(int no) {
			roll_no = no;
		}

		@Override
		public int hashCode() {
			System.out.println("\t@hashCode()");
			return super.hashCode();
		}// not used by TreeSet
		
		@Override
		public boolean equals(Object obj) {
			System.out.println("\t@equals()");
			return super.equals(obj);
		}// not used by TreeSet
		
		@Override
		public int compareTo(Student other) {
			System.out.println("\t@compareTo() "+roll_no+"-"+other.roll_no+"="+(roll_no - other.roll_no));
			return roll_no - other.roll_no;
		}// used by TreeSet, even contains() uses it
	}

	public static void main(String[] args) {
		TreeSet<Student> s = new TreeSet<Student>();
		
		System.out.println("\nGoing to add new Student(1)");
		if(s.add(new Student(1))) System.out.println("\tadding new Student(1) SUCCESS");
		else System.out.println("\tadding new Student(1) FAIL");
		
		System.out.println("\nGoing to add new Student(1)");
		if(s.add(new Student(1))) System.out.println("\tadding new Student(1) SUCCESS");
		else System.out.println("\tadding new Student(1) FAIL !!!");
		
		System.out.println("\nGoing to add new Student(2)");
		if(s.add(new Student(2))) System.out.println("\tadding new Student(2) SUCCESS");
		else System.out.println("\tadding new Student(2) FAIL !!!");
		
		Student three = new Student(3);
		System.out.println("\nGoing to three");
		if(s.add(three)) System.out.println("\tadding three SUCCESS");
		else System.out.println("\tadding three FAIL !!!");
		
		System.out.println("\nGoing to three");
		if(s.add(three)) System.out.println("\tadding three SUCCESS");
		else System.out.println("\tadding three FAIL !!!");
	
		System.out.println("\nSearching three");
		if(s.contains(three)) System.out.println("\tthree FOUND");
		else System.out.println("\tthree NOT FOUND !!!");
		
		System.out.println("\nTreeSet : ");
		Iterator<Student> i = s.iterator();
		while(i.hasNext()){
			Student current = i.next();
			System.out.print(" "+current.roll_no+" ");
			if(current.roll_no==3){
				current.roll_no=0;
			}
		}
		System.out.println("\n\nChanged the value of 3 to 0 during the above iteration");

		System.out.println("\nNew TreeSet:");
		i = s.iterator();
		while(i.hasNext()){
			Student current = i.next();
			System.out.print(" "+current.roll_no+" ");
		}System.out.println();
		//Here 0 is at the location of 3 and violated the 
		//Tree property
		
		System.out.println("\nSearching for 0");
		if(s.contains(new Student(0))) System.out.println(" 0 Found !!!");
		else System.out.println("0 not FOUND!!!");
		// Search goes in the direction 2->1 and then ends
		
		System.out.println("\nSearching for 3");
		if(s.contains(new Student(3))) System.out.println(" 3 Found !!!");
		else System.out.println("3 not FOUND!!!");
		// Search goes in the direction 2->1 and then ends
	}

}
