package think_in_java.thread;

public class TestAccess {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ThreadGroup x = new ThreadGroup("x");
		ThreadGroup y = new ThreadGroup(x, "y");
		ThreadGroup z = new ThreadGroup(y, "z");
		
	    Thread one = new TestThread1(x, "one");
	    one.start();
	    Thread two = new TestThread2(z, "two");

	    try {
	    	Thread.sleep(2000);
	    } catch (Exception e) {
	    	
	    }
	    
	    System.out.println("-------------------------");
	    ThreadGroup g = Thread.currentThread().getThreadGroup();
	    g.list();
	    System.out.println("!!!MAIN ThreadGroup name: " + g.getName());
		System.out.println("!!!MAIN activeCount: " + g.activeCount());
		Thread[] gAll = new Thread[g.activeCount()];
		g.enumerate(gAll);
		for (int i = 0; i < gAll.length; i++) {
			gAll[i].setPriority(Thread.MIN_PRIORITY);
			System.out.println("now is runing!:" + gAll[i].getName());
		}
	    System.out.println("-------------------------");
	}

}

class TestThread1 extends Thread {
	private int i;

	TestThread1(ThreadGroup g, String name) {
		super(g, name);
	}

	void f() {
		i++; // modify this thread
		System.out.println(getName() + " f()");
	}
	
	public void run() {
		while(true) {
			
		}
	}
}

class TestThread2 extends TestThread1 {
	TestThread2(ThreadGroup g, String name) {
		super(g, name);
		start();
	}

	public void run() {
		ThreadGroup g = getThreadGroup().getParent().getParent();
		g.list();
		
		System.out.println("ThreadGroup name: " + g.getName());
		System.out.println("activeCount: " + g.activeCount());
		
		Thread[] gAll = new Thread[g.activeCount()];
		g.enumerate(gAll);
		for (int i = 0; i < gAll.length; i++) {
			gAll[i].setPriority(Thread.MIN_PRIORITY);
			((TestThread1) gAll[i]).f();
		}
		g.list();
	}
}
