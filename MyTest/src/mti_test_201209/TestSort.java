package mti_test_201209;

import java.util.Arrays;
import java.util.Comparator;

public class TestSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String arrs[] = {"a", "b", "c", "d"};
		MySort ms = new MySort();
		Arrays.sort(arrs, ms);
		System.out.println("after sort:---" + Arrays.toString(arrs));
		System.out.println(Arrays.binarySearch(arrs, "b"));
	}
	
	static int getaa() {
		try {
			return 1;
		} catch(Exception e) {
			return 2;
		}
	}
}

class MySort implements Comparator<String> {

	@Override
	public int compare(String a, String b) {
		return b.compareTo(a);
	}
	
}
