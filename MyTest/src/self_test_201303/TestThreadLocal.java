package self_test_201303;

public class TestThreadLocal extends Thread {
	public static ThreadLocal<Integer> num = new ThreadLocal<Integer>();
	public static Integer num2 = 0;

	public static void main(String[] args) throws Exception {
		TestThreadLocal.num.set(0);
		TestThreadLocal.num2 = 0;
		new MyThread().start();
		Thread.sleep(1000);
		System.out.println(TestThreadLocal.num.get());
		System.out.println(TestThreadLocal.num2);
	}

}

class MyThread extends Thread {
	public void run() {
		TestThreadLocal.num.set(1);
		TestThreadLocal.num2 = 1;
	}
}