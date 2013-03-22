package mti_test_201209;

public class ThreadStaticShare implements Runnable {

	static Thread t1;
	static Fuga h1, h2;
	
	@Override
	public void run() {
		if (Thread.currentThread().getId() == t1.getId()) {
			h1.adjust();
		} else {
			h2.view();
		}
	}
	
	public static void main(String args[]) {
        h1 = new Fuga();
        h2 = new Fuga();
        t1 = new Thread(new ThreadStaticShare());
        t1.start();
        new Thread(new ThreadStaticShare()).start();
	}

}

class Fuga {
	static int x = 5;

	synchronized void adjust() {
		System.out.print(x-- + " ");
		try {
			Thread.sleep(200);
		} catch (Exception e) {
			;
		}
		view();
	}

	synchronized void view() {
		try {
			Thread.sleep(200);
		} catch (Exception e) {
			;
		}
		if (x > 0)
			adjust();
	}
}