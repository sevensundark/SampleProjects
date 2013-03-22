package self_test_201303;

public class TestJavaInit extends TestJavaInitParent {

	private String b = "b";
	
	static int i = doSome();

	{
		System.out.println("Child# not static block");
	}

	private static int doSome() {
		System.out.println("Child# doSome()");
		return 1;
	}
	
	static {
		System.out.println("Child# static block");
	}

	public TestJavaInit() {
		this("c");
		System.out.println("Child# TestJavaInit() " + this.b);
	}

	public TestJavaInit(String param) {
		super(param);
		this.b = param;
		System.out.println("Child# TestJavaInit(string) " + this.b);
	}

	public static void main(String[] args) {
		new TestJavaInit();
	}

}


class TestJavaInitParent {

	static int i = doSome();
	
	{
		System.out.println("Parent# not static block");

	}

	private static int doSome() {
		System.out.println("Parent# doSome()");
		return 1;
	}
	
	static {
		System.out.println("Parent# static block");
	}

//	public TestJavaInitParent() {
//		System.out.println("Parent# TestJavaInitParent() ");
//	}
	
	public TestJavaInitParent(String s) {
		System.out.println("Parent# TestJavaInitParent() with param ");
	}
}
