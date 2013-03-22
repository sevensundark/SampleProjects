package think_in_java.thread.sleep;

import java.awt.Container;

public class WaitNotify2 extends Blockable {
	public WaitNotify2(Container c) {
		super(c);
		new Notifier(this);
	}

	public synchronized void run() {
		while (true) {
			i++;
			update();
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
	}
}
