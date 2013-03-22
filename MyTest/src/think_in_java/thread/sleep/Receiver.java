package think_in_java.thread.sleep;

import java.awt.Container;
import java.io.IOException;
import java.io.Reader;

public class Receiver extends Blockable {
	private Reader in;

	public Receiver(Container c, Reader in) {
		super(c);
		this.in = in;
	}

	public void run() {
		try {
			while (true) {
				i++; // Show peeker it's alive
				// Blocks until characters are there:
				state.setText("Receiver read: " + (char) in.read());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
