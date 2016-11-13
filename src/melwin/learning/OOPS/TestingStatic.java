package melwin.learning.OOPS;

public class TestingStatic {

	static class Base {
		public static void baseStatic() {
			System.out.println("base's baseStatic");
		}

		public void baseNonStatic() {
			System.out.println("base's baseNonStatic");
		}
	}

	static class Child extends Base {
		public static void childStatic() {
			System.out.println("child's childStatic");
		}

		public static void baseStatic() {
			System.out.println("child's baseStatic");
		}

		@Override
		public void baseNonStatic() {
			System.out.println("child's baseNonStatic");
		}

		public static void childNonStatic() {
			System.out.println("childNonStatic");
		}
	}

	public static void main(String[] args) {
		Base b = new Child();
		b.baseStatic();		//calls base's baseStatic. cannot override static methods
		b.baseNonStatic();	//calls child's baseNonStatic
		
		Child c = new Child();
		c.baseStatic();		// calls child's baseStatic
	}

}
