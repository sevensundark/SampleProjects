package sort_algorithm;

import java.util.Arrays;
import java.util.Random;

/**
 * 基本思想：在要排序的一组数中，假设前面(n-1) [n>=2] 个数已经是排
 * 好顺序的，现在要把第n个数插到前面的有序数中，使得这n个数
 * 也是排好顺序的。如此反复循环，直到全部排好顺序。
 */
public class ZhiJieChaRu {

	static final int MAX = 10;
	static final int SIZE = 10;
	
	public static void main(String[] args) {
		long start = System.nanoTime();
		
		doSort();
		
		long end = System.nanoTime();
		System.out.println("time = " + (end - start) / 1e9 + " seconds");
	}

	private static void doSort() {
		int[] arr = new int[SIZE];
		initData(arr);
		
//		sort(arr);
		finalSort(arr);
//		performArgs(arr);
	}
	
	private static void initData(int[] arrs) {
		Random random = new Random();
		for (int i = 0; i < arrs.length ; i++) {
			arrs[i] = random.nextInt(MAX);
		}
		
//		System.out.println("init data: " + Arrays.toString(arrs));
	}
	
	/*
	 * 自己写的原始算法
	 */
	private static void sort(int[] arrs) {
		int temData = arrs[0];
		
		if (temData > arrs[1]) {
			arrs[0] = arrs[1];
			arrs[1] = temData;
		}
		
//		int exchangeData;
		for (int i = 2; i < arrs.length; i++) {
			temData = arrs[i];
			if (temData < arrs[i - 1]) {
				for (int j = 0; j < i - 1; j++) {
					if (temData > arrs[j] && temData <= arrs[j + 1]) {
						for (int k = i; k > j + 1; k--) {
							arrs[k] = arrs[k - 1];
						}
						
						arrs[j + 1] = temData;
						break;
					} else if (temData <= arrs[j]) {
						for (int k = i; k > 0; k--) {
							arrs[k] = arrs[k - 1];
						}
						
						arrs[0] = temData;
						break;
					}
				}
			}
		}
	}
	

//	/*
//	 * from baidu.com
//	 */
//	private static void baiduSort(int[] arrs) {
//		int n = arrs.length;
//		
//		int i, j;
//		for (i = 0; i < n; i++) {
//		    int temp = arrs[i];
//		    for (j = i; j > 0 && temp < arrs[j-1]; j--) {
//			    arrs[j] = arrs[j - 1];
//		    }
//            arrs[j] = temp;
//		} 
//	}
	
	/*
	 * 将数组第N个数字，倒序与前面N-1的数组一个个进行比较，大的向后移动一个下标
	 */
	private static void finalSort(int[] arrs) {
		int temp;
		int j;
		for (int i = 0; i < arrs.length; i++) {
			temp = arrs[i];
			for (j = i; j > 0 && temp < arrs[j - 1] ; j--) {
				arrs[j] = arrs[j - 1];
			}
			arrs[j] = temp;
		}
	}
	
	
	private static void performArgs(int[] arrs) {
		System.out.println("sorted date: " + Arrays.toString(arrs));
	}
}
