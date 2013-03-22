package self_test_201303;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MainTest {

	public static void main(String[] args) {
//		testBinarySearch();
//		testArray();

		Scanner sc = new Scanner(System.in);
		
		while (sc.hasNext()) {
			System.out.println(sc.next());
		}
		
		testCalculate();
	}
	
	static void testBinarySearch() {
		String a[] = { "5", "4", "3", "2", "1", "0" };
		System.out.println(Arrays.binarySearch(a, "4"));

		String b[] = { "0", "1", "2", "3", "4", "5" };
		System.out.println(Arrays.binarySearch(b, "4"));
	}
	
	static void testArray() {
		int[] arr1 = new int[] { 1, 2, 3 };
		int[] arr2 = arr1;
		arr2[2] = 4;
		System.out.println(arr1[0] + "," + arr1[1] + "," + arr1[2]);
		System.out.println(arr2[0] + "," + arr2[1] + "," + arr2[2]);

	}
	
	static void testCalculate() {
		System.out.println(0.05 + 0.01);
        System.out.println(0.05 - 0.01);
	}
	
	static void ttt() {
		char c = 'w';
		int i = 8;
		long lg = 15;
		float ft = 8.9f;
		
		i = c + i;
//		c = c + i;
//		lg = ft + lg;
		ft = i + lg + ft;
	}
	
}
