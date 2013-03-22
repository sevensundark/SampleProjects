package think_in_java.thread.sleep;

import java.awt.Container;
import java.awt.TextField;

class Peeker extends Thread {
	private Blockable b;
	private int session;
	private TextField status = new TextField(50);
	private boolean stop = false;
	
	public Peeker(Blockable b, Container c) {
		c.add(status);
		this.b = b;
		start();
	}

	public void terminate() {
		stop = true;
	}
	
	public void run() {
		while (!stop) {
			status.setText(b.getClass().getName() + " Peeker " + (++session) + "; value = " + b.read());
//			status.setText(b.getClass().getName() + " Peeker " + (++session));
			try {
				sleep(100);
			} catch (InterruptedException e) {
				
			}
		}
	}
}
