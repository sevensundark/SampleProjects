package mti_test_201212;

public class ForceConver {
	public static void main(String args[]) {
		Fa s1 = new Son1();
		s1.work();
		
		//同级子类强制转换失败(运行时出错)
		Fa s2 = (Son2)s1;
		s2.work();
	}
}

class Fa {
	public void work() {
		System.out.println("Fa work!");
	}
}

class Son1 extends Fa {
	public void work() {
		System.out.println("Son1 work!");
	}
}

class Son2 extends Fa {
	public void work() {
		System.out.println("Son2 work!");
	}
}