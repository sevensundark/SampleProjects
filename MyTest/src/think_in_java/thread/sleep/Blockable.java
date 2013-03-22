package think_in_java.thread.sleep;

import java.awt.Container;
import java.awt.TextField;

class Blockable extends Thread {
	private Peeker peeker;
	protected TextField state = new TextField(60);
	protected int i;
	
	public Blockable(Container c) {
		c.add(state);
		peeker = new Peeker(this, c);
	}

	public synchronized int read() {return i;}
	
	protected synchronized void update() {
		state.setText(getClass().getName() + " state: i = " + i);
	}
	
	public void stopPeeker() {
		peeker.terminate();
	}
}
