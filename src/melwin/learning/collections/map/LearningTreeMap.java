package melwin.learning.collections.map;

import java.util.Collection;
import java.util.TreeMap;

public class LearningTreeMap {

	private static class Student implements Comparable<Student> {
		public int roll_no;

		public Student(int no) {
			roll_no = no;
		}

		@Override
		public int hashCode() {
			System.out.println("\t@hashCode()");
			return super.hashCode();
		}// not used by TreeMap as Student is value

		@Override
		public boolean equals(Object obj) {
			System.out.println("\t@equals()");
			return roll_no == ((Student) obj).roll_no;
		}// Not used by TreeMap while inserting as Student is value.
			// While iterating the values and when equals() is called
			// on them, then this is called.

		@Override
		public int compareTo(Student other) {
			System.out.println("\t@compareTo() " + roll_no + "-" + other.roll_no + "=" + (roll_no - other.roll_no));
			return roll_no - other.roll_no;
		}// Here Key is Integer and Value is Student, since values
			// are never compared while inserting they are never
			// called while inserting.
	}

	public static void main(String[] args) {
		TreeMap<Integer, Student> s = new TreeMap<>();

		System.out.println("\nGoing to add (1, new Student(1))");
		if (s.put(1, new Student(1)) == null)
			System.out.println("\tadding (1,new Student(1)) SUCCESS");
		else
			System.out.println("\tadding (1, new Student(1)) FAIL");

		System.out.println("\nGoing to add (1, new Student(1))");
		if (s.put(1, new Student(1)) == null)
			System.out.println("\tadding (1,new Student(1)) SUCCESS");
		else
			System.out.println("\tadding (1, new Student(1)) FAIL !!!");

		System.out.println("\nGoing to add (2, new Student(2))");
		if (s.put(2, new Student(2)) == null)
			System.out.println("\tadding (2, new Student(2)) SUCCESS");
		else
			System.out.println("\tadding (2, new Student(2)) FAIL !!!");

		Student three = new Student(3);
		System.out.println("\nGoing to add (3, three)");
		if (s.put(3, three) == null)
			System.out.println("\tadding add(3, three) SUCCESS");
		else
			System.out.println("\tadding add(3, three) FAIL !!!");

		System.out.println("\nGoing to add(3, three)");
		if (s.put(3, three) == null)
			System.out.println("\tadding add(3, three) SUCCESS");
		else
			System.out.println("\tadding add(3, three) FAIL !!!");

		System.out.println("\nGoing to add(4, three)");
		if (s.put(4, three) == null)
			System.out.println("\tadding add(4, three) SUCCESS");
		else
			System.out.println("\tadding add(4, three) FAIL !!!");

		System.out.println("\nSearching three");
		if (s.containsKey(3))
			System.out.println("\tthree FOUND");
		else
			System.out.println("\tthree NOT FOUND !!!");

		System.out.println();
		Collection<Student> students = s.values();
		for (Student student : students) {
			if (student.equals(new Student(1))) {
				System.out.println("TreeMap contains a value with student whose roll_no = 1");
				break;
			}
		}
	}

}
