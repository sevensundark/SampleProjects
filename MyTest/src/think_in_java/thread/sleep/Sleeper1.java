package think_in_java.thread.sleep;

import java.awt.Container;

class Sleeper1 extends Blockable {
	public Sleeper1(Container c) {
		super(c);
	}

	public synchronized void run() {
		while (true) {
			i++;
			update();
			
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				
			}
		}
	}
}
