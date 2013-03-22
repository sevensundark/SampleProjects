package think_in_java.thread.sleep;

public class Notifier extends Thread {
	private WaitNotify2 wn2;

	public Notifier(WaitNotify2 wn2) {
		this.wn2 = wn2;
		start();
	}

	public void run() {
		while (true) {
			try {
				sleep(2000);
			} catch (InterruptedException e) {
			}
			synchronized (wn2) {
				wn2.notify();
			}
		}
	}
}
