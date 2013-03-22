package tcl_exam;

public class TestOverride {

	private void doPrint(int i) {
		System.out.println("I am int");
	}
	
	private void doPrint(String s) {
		System.out.println("I am string");
	}
	
	public static void main(String[] args) {
		TestOverride t = new TestOverride();
		char st = 1234;
		System.out.println(st);
		char ch = 'y';
		t.doPrint(ch);
	}

}
