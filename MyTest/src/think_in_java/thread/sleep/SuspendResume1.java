package think_in_java.thread.sleep;

import java.awt.Container;

class SuspendResume1 extends SuspendResume {
	public SuspendResume1(Container c) {
		super(c);
	}

	@SuppressWarnings("deprecation")
	public synchronized void run() {
		while (true) {
			i++;
			update();
			suspend(); // Deprecated in Java 1.2
		}
	}
}
