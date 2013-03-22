package self_test_201303;

public class TestInnerClass {

	public static void main(String[] args) {
		A a = new A() {
			public void method() {
				System.out.println("aa--bb--cc");
			}
		};
		a.method();
		A.Ic ic = new A.Ic();
		ic.im();
	}
	
}

interface A {
	public void method();
	
	class Ic {
		public void im() {
			System.out.println("A.Ic.im");
		}
	}
}

class C {
	private int i;
	public static D d = new D();
	
	interface I {
		void dodo();
	}
	
	class CI implements I {

		@Override
		public void dodo() {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	static class SC {
		public void do1() {
			d.f();
		}
	}
}

class D {
	public void f() {
		System.out.println("D.f()");
	}
}