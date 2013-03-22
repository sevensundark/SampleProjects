package getMethod_invoke;

import java.lang.reflect.Method;

public class MainTest {

	public static void main(String[] args) throws Exception {
		
		MainTest mt = new MainTest();
		Class c = mt.getClass();
		
		Class[] cargs = new Class[2];
		String[] strArgs = { "aa", "bb", "cc" };
		cargs[0] = strArgs.getClass();
		
		Integer intArg = new Integer(3);
		cargs[1] = intArg.getClass();
		
		Method m = c.getMethod("test", cargs);
		
		Object[] inArgs = new Object[2];
		inArgs[0] = strArgs;
		inArgs[1] = intArg;
		
		m.invoke(mt, inArgs);
		
		Class[] cargs2 = new Class[0];
		Method m2 = c.getMethod("test2", cargs2);
		m2.invoke(mt, new Object[0]);
	}
	
	public void test2() {
		System.out.println("test2-----ok");
	}

	public void test(String[] str, Integer stri) {

		for (int j = 0; j < str.length; j++)
			System.out.println("test1-----" + str[j]);
		System.out.println("test1-----" + stri.intValue());

	}
}
