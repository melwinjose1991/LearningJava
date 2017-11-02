package melwin.learning.OOPS;

public class TestingAccessModifiersA {

	public String a_public;
	protected String a_protected;
	private String a_private;
	String a_default;
	
	public TestingAccessModifiersA() {
		a_public = new String("A's Public");
		a_protected = new String("A's Protected");
		a_private = new String("A's Private");
		a_default = new String("A's Default");
	}

	public static void main(String[] args) {
	}

	// Overloading experiment
	protected void OLF1(){
		System.out.println("OLF1");
	}
	
	protected int OLF1(int a){
		System.out.println("OLF1(int)");
		return a;
	}
	
	protected void OLF1(float a){
		System.out.println("OLF1(float)");
	}

	//	protected int OLF1() { ... }
	//		return type cannot used to differentiate it from OF1
	
	//	protected void OLF1() throws Exception { ... }
	//		Exception type cannot used to differentiate it from OF1
}
