package think_in_java.thread.sleep;

import java.awt.Container;

public class WaitNotify1 extends Blockable {
	public WaitNotify1(Container c) {
		super(c);
	}

	public synchronized void run() {
		while (true) {
			i++;
			update();
			try {
				wait(1000);
			} catch (InterruptedException e) {
			}
		}
	}
}
