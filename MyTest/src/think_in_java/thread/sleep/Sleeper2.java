package think_in_java.thread.sleep;

import java.awt.Container;

class Sleeper2 extends Blockable {
	public Sleeper2(Container c) {
		super(c);
	}

	public void run() {
		while (true) {
			change();
			
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				
			}
		}
	}
	
	public synchronized void change() {
		i++;
		update();
	}
}
