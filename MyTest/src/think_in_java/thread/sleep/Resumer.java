package think_in_java.thread.sleep;

class Resumer extends Thread {
	private SuspendResume sr;

	public Resumer(SuspendResume sr) {
		this.sr = sr;
		start();
	}

	public void run() {
		while (true) {
			try {
				sleep(1000);
			} catch (InterruptedException e) {
			}
//			sr.resume(); // Deprecated in Java 1.2
		}
	}

}
