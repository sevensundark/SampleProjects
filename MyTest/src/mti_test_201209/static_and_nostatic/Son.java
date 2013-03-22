package mti_test_201209.static_and_nostatic;

public class Son extends Father {

	void method3() {
		System.out.println("son method3");
	}
	
	public static void main(String[] args) {
		doMethod();
		
	}

	static void doMethod() {
		method1();
		new Son().method3();
		//静态方法内无法调用非静态方法，无论是不是父类
		// method2();
		
		// 实例类，类方法是可以的
		new Son().method2();
	}
}
