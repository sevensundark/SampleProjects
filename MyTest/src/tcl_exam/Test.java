package tcl_exam;

import test.Zhanglei;

public class Test extends Zhanglei {
	public static void main(String[] args) {
//		Zhangl1 zl = new Zhangl1();
		Zhanglei zl = new Zhanglei();

	}
	
	private void dodo() {
		jj++;
	}
}

class Sundae {
	private Sundae() {
	}

	static Sundae makeASundae() {
		return new Sundae();
	}
}
