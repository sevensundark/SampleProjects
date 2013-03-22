package generic;

import java.util.ArrayList;
import java.util.List;

public class TestMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Integer> intList = new ArrayList<Integer>();
//		List<Number> numberList = intList;
		intList.add(1);
		intList.add(5);
		intList.add(3);
		pirntList(intList);
		
//		pirntList1(intList);
		
		pirntList2(intList);
		
		Lhist<String> li = new Lhist<String>(30);
	}
	
	static void pirntList(List l) {
		for (Object o : l) {
			System.out.println(o);
		}
	}
	
	static void pirntList1(List<Object> l) {
		for (Object o : l) {
			System.out.println(o);
		}
	}
	
	static void pirntList2(List<?> l) {
		for (Object o : l) {
			System.out.println(o);
		}
	}
	
	static void test1() {
		List<Integer> li = new ArrayList<Integer>();
		li.add(new Integer(42));
		List<?> lu = li;
		System.out.println(lu.get(0));
	}

	public static <T> T ifThenElse(boolean b, T first, T second) {
		return b ? first : second;
	}
	
	static void doTest() {
		String s = ifThenElse(false, "111", "bbb");
//		String b = ifThenElse(false, "111", 111);
	}
	
}
