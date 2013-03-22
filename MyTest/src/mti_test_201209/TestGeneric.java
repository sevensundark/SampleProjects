package mti_test_201209;

public class TestGeneric<E extends TestGeneric> {
	E innerE;
	public static <E extends TestGeneric>E doStuff(E e, TestGeneric<E> e2) {
		return e;
	}
	
	public E getE() {
		return innerE;
	}
	
	public E doTest(E e) {
		return e;
	}
}
