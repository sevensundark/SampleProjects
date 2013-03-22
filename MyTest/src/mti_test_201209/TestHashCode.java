package mti_test_201209;

import java.util.ArrayList;
import java.util.List;

public class TestHashCode {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Object obj = new Object();
		System.out.println(obj.hashCode());

		List<String> l = new ArrayList<String>();
		l.hashCode();
		System.out.println(l.hashCode());
		l.add("aaa");
		System.out.println(l.hashCode());
	}

}
