package self_test_201303;

public class GrandChild1 extends Son1 {

	public static StaticTest stat = new StaticTest();
	
	{
		System.out.println("in GrandChild1 not static code …… ");
	}
	
	static {

		System.out.println("in GrandChild1 static code …… ");
	}

	public GrandChild1() {
		System.out.println("in GrandChild1 constructor …… ");

	}

	public GrandChild1(String s) {
		System.out.println("in GrandChild1 constructor with param: String");

	}

	public GrandChild1(int s) {
		super(s);

		System.out.println("in GrandChild1 constructor with param: int");

	}

	public GrandChild1(long s) {
		this((int) s);

		System.out.println("in GrandChild1 constructor with param: long");

	}

	public static void main(String[] args) {
		GrandChild1 GrandChild1 = new GrandChild1("");
		System.out.println("\n\r");

		GrandChild1 GrandChild2 = new GrandChild1(3);

		System.out.println("\n\r");
		GrandChild1 GrandChild3 = new GrandChild1(3L);
	}

}

class Parent1 {
	public static StaticTest stat = new StaticTest(1L);
	
	{
		System.out.println("in parent1 not static code …… ");
	}
	
	static {

		System.out.println("in parent1 static code …… ");
	}

	public Parent1() {
		System.out.println("in parent1 constructor …… ");

	}
}

class Son1 extends Parent1 {
	public static StaticTest stat = new StaticTest(1);
	
	{
		System.out.println("in Son1 not static code …… ");
	}
	
	static {
		System.out.println("in Son1 static code …… ");
	}

	public Son1() {
		System.out.println("in Son1 constructor …… ");

	}

	public Son1(int s) {
		System.out.println("in Son1 constructor with param: int");

	}

}

class StaticTest {
	public StaticTest() {
		System.out.println("in StaticTest constructor param:  ");

	}

	public StaticTest(int i) {
		System.out.println("in StaticTest constructor param:int  ");

	}

	public StaticTest(long l) {
		System.out.println("in StaticTest constructor param:long  ");

	}

//	/**
//	 * @param args
//	 */
//	public static void main(String[] args) {
//		// TODO 自动生成方法存根
//
//	}

}