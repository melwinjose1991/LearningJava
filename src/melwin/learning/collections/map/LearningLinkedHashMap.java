package melwin.learning.collections.map;

import java.util.LinkedHashMap;
import java.util.Map;

public class LearningLinkedHashMap {

	public static class Student {
		public int roll_no;

		public Student(int roll_no) {
			this.roll_no = roll_no;
		}

		@Override
		public int hashCode() {
			System.out.println("\thashCode()");
			return roll_no % 10;
		}

		@Override
		public boolean equals(Object obj) {
			System.out.println("\tequals()");
			return roll_no == ((Student) obj).roll_no;
		}

	}

	public static void main(String args[]) {
		Map<Integer, Student> s = new LinkedHashMap<>();

		System.out.println("\nGoing to add new Student(1)");
		if (s.put(1, new Student(1)) == null)
			System.out.println(" <1, new Student(1)> added");
		else
			System.out.println("adding <1, new Student(1)> failed");

		System.out.println("\nGoing to add one=Student(1)");
		Student one = new Student(1);
		if (s.put(1, one) == null)
			System.out.println("<1, one> added");
		else
			System.out.println("adding <1, one> failed");
		// Key is still 1

		System.out.println("\nGoing to add new Student(11)");
		if (s.put(2, one) == null)
			System.out.println(" <2, one> added");
		else
			System.out.println("adding <2, one> failed");
		// Key=2, with same object

	}
}
