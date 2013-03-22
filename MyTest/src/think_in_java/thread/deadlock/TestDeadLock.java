package think_in_java.thread.deadlock;

public class TestDeadLock {
	public static void main(String[] args) {
		DeadlockRisk dead = new DeadlockRisk();
		MyThread t1 = new MyThread(dead, 1, 2, "线程1");
		MyThread t2 = new MyThread(dead, 3, 4, "线程2");
//		MyThread t3 = new MyThread(dead, 5, 6, "线程3");
//		MyThread t4 = new MyThread(dead, 7, 8, "线程4");
		t1.start();
		t2.start();
//		t3.start();
//		t4.start();
	}
}
