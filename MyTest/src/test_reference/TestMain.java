package test_reference;

public class TestMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

//		test1();
//		test2();
		test3();
	}
	
	private static void test1() {
		String str1 = "string1";
		String str2 = str1;
		
		System.out.println("str1:" + str1);
		System.out.println("str2:" + str2);
		
		str1 = "str change";
		System.out.println("str1:" + str1);
		System.out.println("str2:" + str2);
	}
	
	private static void test2() {
		String str1 = new String("string1");
		String str2 = new String("string1");
		
		System.out.println(str1 == str2);
	}
	
	private static void test3() {
		PartContainer container1 = new PartContainer();
		PartContainer container2 = container1;
		
		System.out.println("container1----parStr: " + container1.getParStr());
		System.out.println("container1----getParInt: " + container1.getParInt());
		System.out.println("container2----parStr: " + container2.getParStr());
		System.out.println("container2----getParInt: " + container2.getParInt());
		
		container1.setParStr("str11");
		container1.setParInt(11);
		System.out.println("container1----parStr: " + container1.getParStr());
		System.out.println("container1----getParInt: " + container1.getParInt());
		System.out.println("container2----parStr: " + container2.getParStr());
		System.out.println("container2----getParInt: " + container2.getParInt());
		
		container2.setParStr("str22");
		container2.setParInt(22);
		System.out.println("container1----parStr: " + container1.getParStr());
		System.out.println("container1----getParInt: " + container1.getParInt());
		System.out.println("container2----parStr: " + container2.getParStr());
		System.out.println("container2----getParInt: " + container2.getParInt());
		
		container1 = null;
		if (container2 == null) {
			System.out.println("container2 is null!!");
		} else {
			System.out.println("container2 is not null!!");
		}
	}

}
