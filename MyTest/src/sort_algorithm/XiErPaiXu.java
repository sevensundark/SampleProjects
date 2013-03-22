package sort_algorithm;

import java.util.Arrays;
import java.util.Random;

/**
 * 基本思想：在要排序的一组数中，假设前面(n-1) [n>=2] 个数已经是排
 * 好顺序的，现在要把第n个数插到前面的有序数中，使得这n个数
 * 也是排好顺序的。如此反复循环，直到全部排好顺序。
 */
public class XiErPaiXu {

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
		
		mySort(arr);
//		baiduSort(arr);
//		performArgs(arr);
	}
	
	
	/**
	 * 思路:按某一增量d（以原数组长度length / 2）开始切分原数组成多个子数组，子数组分别进行直接插入排序，
	 *      预见每次增量切分的数组数量以及每个子数组的数组长度，建立一个中间数组放置切分出的数组并排序，
	 *      排序完后再替换原数组,然后按d / 2循环，重复以上操作，直到增量为1
	 * 
	 */
	private static void mySort(int[] arrs) {
		// 中间的转移数组变量
		int[] temArr;
		// 数组被增量能切分的子数组数量
		int arrCount;
		// 被增量切分的子数组的数组长度
		int temArrLength;
		
		// 按增量来切分循环，getIncrement方法为取得增量的方法，增量按length / 2循环取得，到1完成最后一次排序结束
		for (int inc = getIncrement(arrs.length); inc >= 1; inc = getIncrement(inc)) {
			// 查看增量变化
			System.out.println(inc);
			
			// 求切分后子数组的数量，思路：切分增量小于数组长度，切分后的数组数为切分增量的值，反之，数组数为数组长度
			// 这里实际上，inc必然小于原数组长度，所以 arrCount = inc；
			arrCount = (arrs.length < inc) ? arrs.length : inc;
			
			for (int i = 0; i < arrCount; i++) {
				// 子数组长度，按某一增量切分，原数组被切分的最长子数组为   除尽： length / inc  除不尽  length / inc + 1 
				// arrs.length - i中 - i的目的： 把数组的首项作为切分的起始点，这样按上面的方法求出的最长子数组才能与此数据项为起始点切分出来的数组相符合
				temArrLength = ((arrs.length - i) % inc == 0) ? (arrs.length - i) / inc : (arrs.length - i) / inc + 1;
				
				temArr = new int[temArrLength];
				
				// 切分出的子数组
				for (int j = i, index = 0; j < arrs.length; j += inc, index++) {
					temArr[index] = arrs[j];
				}
				
				// 直接插入排序
				miniSort(temArr);
				
				// 排序后重新替换原数组
				for (int k = i, idx = 0; k < arrs.length; k+=inc, idx++) {
					arrs[k] = temArr[idx];
				}
			}
		}
	}
	
	/*
	 * 切分增量获得，首次无视奇偶，以后的只取奇数
	 */
	private static int getIncrement(int inc) {
		return (inc % 2 == 0 || inc / 2 == 1 || inc / 2 == 0) ? inc / 2 : inc / 2 + 1;
	}

	private static void baiduSort(int[] arrs) {
		int n = arrs.length;
		
		int i, j;
		for (i = 0; i < n; i++) {
		    int temp = arrs[i];
		    for (j = i; j > 0 && temp < arrs[j-1]; j--) {
			    arrs[j] = arrs[j - 1];
		    }
            arrs[j] = temp;
		} 
	}
	
	/*
	 * 直接插入排序
	 */
	private static void miniSort(int[] arrs) {
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
	
	private static void initData(int[] arrs) {
		Random random = new Random();
		for (int i = 0; i < arrs.length ; i++) {
			arrs[i] = random.nextInt(MAX);
		}
		
//		System.out.println("init data: " + Arrays.toString(arrs));
	}
	
	private static void performArgs(int[] arrs) {
		System.out.println("sorted date: " + Arrays.toString(arrs));
	}
}
