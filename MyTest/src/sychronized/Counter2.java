package sychronized;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.*;

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
			if (sp == null)
				sp = new SeparateSubTask(Counter2.this);
		}
	}

	class OnOffL implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (sp != null)
				sp.invertFlag();
		}
	}

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
