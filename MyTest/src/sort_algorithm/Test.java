package sort_algorithm;

import java.util.Arrays;


public class Test {

	private static boolean pC() {
		System.out.println("C");
		return true;
	}
	
	private static void p(String str) {
		System.out.println(str);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int arrs[] = {4, 2, 2, 77, 11, 13, 11, 1, 56};
		
//		for (int i = arrs.length - 1; i >0 ; i--) {
//			arrs[i] = arrs[i - 1];
//		}
		
//		sort(arrs);
//		System.out.println(Arrays.toString(arrs));
//		int index = 0;
//		for (p("A"); pC() && index < 2; p("D")) {
//			index++;
//			p("B");
//		}
		
		System.out.println(5 / 2);
	}
	
	private static void sort(int[] arrs) {
		int temp;
		int index;
		for (int i = 0; i < arrs.length; i++) {
			temp = arrs[i];
			for (index = i; index > 0 && temp < arrs[index - 1]; index--) {
				arrs[index] = arrs[index - 1];
			}
			arrs[index] = temp;
		}
	}

}
