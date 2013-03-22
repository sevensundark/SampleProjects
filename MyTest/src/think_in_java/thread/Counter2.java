package think_in_java.thread;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Counter2 extends Applet {

	TextField t = new TextField(10);
	private SeparateSubTask sp = null;
	private Button onOff = new Button("Toggle"), start = new Button("Start");

	public void init() {
		add(t);
		start.addActionListener(new StartL());
		add(start);
		onOff.addActionListener(new OnOffL());
		add(onOff);
	}

	class StartL implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (sp == null) {
				sp = new SeparateSubTask(Counter2.this);
			} else {
				sp.start();
			}
		}
	}

	class OnOffL implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (sp != null)
				sp.invertFlag();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Counter2 applet = new Counter2();
		Frame aFrame = new Frame("Counter2");
		aFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		aFrame.add(applet, BorderLayout.CENTER);
		aFrame.setSize(300, 200);
		applet.init();
		applet.start();
		aFrame.setVisible(true);
	}

}


class SeparateSubTask extends Thread {
	private int count = 0;
	private Counter2 c2;
	private boolean runFlag = true;

	public SeparateSubTask(Counter2 c2) {
		this.c2 = c2;
		start();
	}

	public void invertFlag() {
		runFlag = !runFlag;
	}

	public void run() {
		while (true) {
			try {
				sleep(100);
			} catch (InterruptedException e) {
			}
			if (runFlag) {
				c2.t.setText(Integer.toString(count++));
			} else {
				return;
			}
			
			System.out.println("I am run---" + count);
		}
	}
}