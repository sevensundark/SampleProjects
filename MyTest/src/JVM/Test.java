package JVM;

public class Test {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		Class clazz1 = Class.forName("java.lang.String");
		System.out.println(clazz1.getClassLoader());

		Class clazz2 = Class.forName("JVM.ABC");
		System.out.println(clazz2.getClassLoader());
		
//		ABC clazz3 = new ABC();
//		System.out.println(clazz3.getClassLoader());
	}

}


class ABC {
	
}