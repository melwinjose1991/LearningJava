package melwin.learning.OOPS;

interface A {
	default void printOne() {
		System.out.println("A's printOne");
	}

	default void printTwo() {
		System.out.println("A's printTwo");
	}

	default void printThree() {
		System.out.println("A's printThree");
	}

	void printFour();
}

interface B extends A {
	default void printOne() {
		System.out.println("B's printOne");
	}

	default void printTwo() {
		System.out.println("B's printTwo");
	}
}

interface C extends A {
	default void printOne() {
		System.out.println("C's printOne");
	}
}

public class Diamond implements B, C {

	public static void main(String[] args) {
		Diamond d = new Diamond();
		d.printOne();
		d.printTwo();
		d.printThree();
		d.printFour();
	}

	// Diamond function. If not defined then error
	@Override
	public void printOne() {
		System.out.println("D's printOne");
	}

	// no default-method, needs to be defined
	@Override
	public void printFour() {
		System.out.println("D's printFour");
	}

}
