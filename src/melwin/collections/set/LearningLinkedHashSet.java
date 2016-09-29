package melwin.collections.set;

import java.util.LinkedHashSet;
import java.util.Set;

public class LearningLinkedHashSet {
	
	public static class Student {
		public int roll_no;
		
		public Student(int roll_no){
			this.roll_no = roll_no;
		}

		@Override
		public int hashCode() {
			System.out.println("\thashCode()");
			return roll_no%10;
		}
		
		@Override
		public boolean equals(Object obj) {
			System.out.println("\tequals()");
			return roll_no == ((Student)obj).roll_no;
		}

/*
 * NOTE : Very similar to HashSet, here elements have after and 
 * before pointers. Also head and tail for Map
 */
	}
	
	public static void main(String args[]) {
		Set<Student> s = new LinkedHashSet<Student>();
		
		System.out.println("\nGoing to add new Student(1)");
		if(s.add(new Student(1))) System.out.println(" new Student(1) added");
		
		System.out.println("\nGoing to add new Student(1)");
		if(s.add(new Student(1))) System.out.println(" new Student(1) added");
		
		System.out.println("\nGoing to add new Student(11)");
		if(s.add(new Student(11))) System.out.println(" new Student(11) added");
		
		System.out.println("\nGoing to add new Student(2)");
		if(s.add(new Student(2))) System.out.println(" new Student(2) added");
		
	}
}
