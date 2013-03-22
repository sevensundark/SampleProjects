package think_in_java.thread.sleep;

import java.awt.Container;

class SuspendResume2 extends Blockable {
	public SuspendResume2(Container c) {
		super(c);
	}

	@SuppressWarnings("deprecation")
	public void run() {
		while (true) {
			change();
			suspend(); // Deprecated in Java 1.2
		}
	}

	public synchronized void change() {
		i++;
		update();
	}
}
