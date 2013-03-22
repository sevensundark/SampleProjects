package mti_test_201212;

public class ExtendPrivateTest {
	public static void main(String args[]) {
		A a = new B();
		System.out.println(a.f());
	}
}

class A {
	int b = 10;
	
	public A() {
		System.out.println("A()");
	}
	
	public A(String s) {
		System.out.println("A(s)");
	}
	
	public int f() {
		return b;
	}
}

class B extends A {
	int b;
	
//	public B(String s) {
//		System.out.println("b(s)");
////		super(s);
//	}
}