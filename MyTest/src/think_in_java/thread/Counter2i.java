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

public class Counter2i extends Applet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private class SeparateSubTask extends Thread {
		int count = 0;
		boolean runFlag = true;

		SeparateSubTask() {
			start();
		}

		public void run() {
			while (true) {
				try {
					sleep(100);
				} catch (InterruptedException e) {
				}
				if (runFlag)
					t.setText(Integer.toString(count++));
			}
		}
	}

	private SeparateSubTask sp = null;
	private TextField t = new TextField(10);
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
			if (sp == null)
				sp = new SeparateSubTask();
		}
	}

	class OnOffL implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (sp != null)
				sp.runFlag = !sp.runFlag; // invertFlag();
		}
	}

	public static void main(String[] args) {
		Counter2i applet = new Counter2i();
		Frame aFrame = new Frame("Counter2i");
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