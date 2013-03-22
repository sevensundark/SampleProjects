package think_in_java.thread.sleep;

import java.awt.Container;

class SuspendResume extends Blockable {
	public SuspendResume(Container c) {
		super(c);
		new Resumer(this);
	}
}
