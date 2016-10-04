package melwin.learning.collections.map;

import java.util.Collection;
import java.util.TreeMap;

public class LearningTreeMap2 {

	private static class Student implements Comparable<Student>{
		public int roll_no;

		public Student(int no) {
			roll_no = no;
		}

		@Override
		public int hashCode() {
			System.out.println("\t@hashCode()");
			return super.hashCode();
		}// NOT USED by TreeMap, since its a TREE 
		 // not a Bucket
		
		@Override
		public boolean equals(Object obj) {
			System.out.println("\t@equals()");
			return roll_no == ((Student)obj).roll_no;
		}// NOT USED by TreeMap since this is TREE
		 // and NOT a bucket
		
		@Override
		public int compareTo(Student other) {
			System.out.println("\t@compareTo() "+roll_no+"-"+other.roll_no+"="+(roll_no - other.roll_no));
			return roll_no - other.roll_no;
		}// Used by TreeMap while inserting to check < = > 
	}

	public static void main(String[] args) {
		TreeMap<Student, Integer> s = new TreeMap<>();
		
		System.out.println("\nGoing to add (new Student(1),1)");
		if(s.put(new Student(1),1) == null) System.out.println("\tadding (new Student(1),1) SUCCESS");
		else System.out.println("\tadding (new Student(1),1) FAIL");
		
		System.out.println("\nGoing to add (new Student(1),1)");
		if(s.put(new Student(1),1) == null) System.out.println("\tadding (new Student(1),1) SUCCESS");
		else System.out.println("\tadding (new Student(1),1) FAIL !!!");
		
		
		System.out.println("\nGoing to add (new Student(2), 2)");
		if(s.put(new Student(2),2) == null) System.out.println("\tadding (new Student(2), 2) SUCCESS");
		else System.out.println("\tadding (new Student(2), 2) FAIL !!!");
		
		
		Student three = new Student(3);
		System.out.println("\nGoing to add (three, 3)");
		if(s.put(three,3) == null) System.out.println("\tadding (three, 3) SUCCESS");
		else System.out.println("\tadding (three, 3) FAIL !!!");
		
		System.out.println("\nGoing to add (three, 3)");
		if(s.put(three,3) == null) System.out.println("\tadding (three, 3) SUCCESS");
		else System.out.println("\tadding (three, 3) FAIL !!!");
	
		System.out.println("\nGoing to add(three,4)");
		if(s.put(three,4) == null) System.out.println("\tadding add(three,4) SUCCESS");
		else System.out.println("\tadding add(three,4) FAIL !!!");
		
		
		System.out.println("\nSearching three");
		if(s.containsKey(three)) System.out.println("\tthree FOUND");
		else System.out.println("\tthree NOT FOUND !!!");

		System.out.println();
		Collection<Student> students = s.keySet();
		for(Student student : students){
			if(student.equals(new Student(1))){
				System.out.println("TreeMap contains a value with student whose roll_no = 1");
				break;
			}
		}
	}

}
