package melwin.collections.set;

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
		Set<Student> s = new TreeSet<Student>();
		
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
	}

}
