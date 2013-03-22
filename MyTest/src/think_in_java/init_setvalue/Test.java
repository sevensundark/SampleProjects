package think_in_java.init_setvalue;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Test {
	public static void main(String[] args) {
//		String str1 = new String("abc");
//		String str2 = new String("abc");
//		
//		System.out.println(str1 == str2);
//		System.out.println(str1.equals(str2));
//		
//		System.out.println(str1.hashCode());
//		System.out.println(str2.hashCode());
//		
//		Set<String> s = new HashSet<String>();
//		s.add(str1);
//		s.add(str2);
//		
//		Iterator<String> it = s.iterator();
//		while (it.hasNext()) {
//			String st = it.next();
//			System.out.println(st);
//		}
		
		A a = new A();
		B b = new B();
		b.setA(a);
		a = null;
		
		if (b.getContent() == null) {
			System.out.println("it is null");
		} else {
			System.out.println("it isn't null");
		}
		
//		b = null;
		System.gc();
	}
	
	static void f1() {
		
	}

	void f2() {
		f1();
	}
}

class A {
	public void finalize() {
		System.out.println("A---------I'm be cleaned!");
	}
}

class B {
	private A a;
	
	public void setA(A newA) {
		a = newA;
	}
	
	public A getContent() {
		return a;
	}
	
	public void finalize() {
//		super.finalize();
		System.out.println("B---------I'm be cleaned!");
	}
}