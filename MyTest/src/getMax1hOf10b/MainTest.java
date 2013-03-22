package getMax1hOf10b;

import java.util.Arrays;
import java.util.Random;

public class MainTest {

	static int TOTAL = 100000000;
	static final int MAX = Integer.MAX_VALUE;//随机数最大值
	static int ARR_RANGE = 100;
	
	private static int num = 1;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
    	long start = System.nanoTime();//开始
    	
		int[] arr = new int[ARR_RANGE];
		Random random = new Random();
		
		for (int i = 0; i < arr.length; i++) {
//			arr[i] = random.nextInt(MAX);
			arr[i] = num++;
		}
		
		arr = freshArr(arr);
		
		int randowNm;
		for (int i = 100; i < TOTAL - 1; i++) {
//			randowNm = random.nextInt(MAX);
			randowNm = num++;
			if (randowNm > arr[0]) {
				arr[0] = randowNm;
				arr = freshArr(arr);
			}
		}
		
//		for (int i = 0; i < arr.length; i++) {
//			System.out.print(arr[i] + ",");
//			if ((i + 1) % 10 == 0) {
//				System.out.println();
//			}
//		}
		
		System.out.println(Arrays.toString(arr));
		
        long end = System.nanoTime();//结束
        System.out.println("time = " + (end - start) / 1e9 + " seconds");//输出时间
	}

	private static int[] freshArr(int[] arr) {
		int tem = arr[0];
		int index = 0;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] < arr[0]) {
				tem = arr[i];
				index = i;
			}
		}
		
		arr[index] = arr[0];
		arr[0] = tem;
		return arr;
	}
	
}
