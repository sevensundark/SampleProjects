package think_in_java.thread;

public class ThreadGroup1 {
	public static void main(String[] args) {
		ThreadGroup sys = Thread.currentThread().getThreadGroup();
		sys.list(); // (1)
		
		System.out.println("----***-------111--------***-------***--------***--------");
		
		// Reduce the system thread group priority:
		sys.setMaxPriority(Thread.MAX_PRIORITY - 1);
		// Increase the main thread priority:
		Thread curr = Thread.currentThread();
		curr.setPriority(curr.getPriority() + 1);
		sys.list(); // (2)
		
		System.out.println("----***-------222--------***-------***--------***--------");

		// Attempt to set a new group to the max:
		ThreadGroup g1 = new ThreadGroup("g1");
		g1.setMaxPriority(Thread.MAX_PRIORITY);
		// Attempt to set a new thread to the max:
		Thread t = new Thread(g1, "A");
		t.setPriority(Thread.MAX_PRIORITY);
		g1.list(); // (3)
		
		System.out.println("----***-------333--------***-------***--------***--------");
		
		// Reduce g1's max priority, then attempt
		// to increase it:
		g1.setMaxPriority(Thread.MAX_PRIORITY - 2);
		g1.setMaxPriority(Thread.MAX_PRIORITY);
		g1.list(); // (4)
		
		System.out.println("----***-------444--------***-------***--------***--------");
		
		// Attempt to set a new thread to the max:
		t = new Thread(g1, "B");
		t.setPriority(Thread.MAX_PRIORITY);
		g1.list(); // (5)
		
		System.out.println("----***-------555--------***-------***--------***--------");
		
		// Lower the max priority below the default
		// thread priority:
		g1.setMaxPriority(Thread.MIN_PRIORITY + 2);
		// Look at a new thread's priority before
		// and after changing it:
		t = new Thread(g1, "C");
		g1.list(); // (6)
		
		System.out.println("----***-------666--------***-------***--------***--------");
		
		t.setPriority(t.getPriority() - 1);
		g1.list(); // (7)
		
		System.out.println("----***-------777--------***-------***--------***--------");
		
		// Make g2 a child Threadgroup of g1 and
		// try to increase its priority:
		ThreadGroup g2 = new ThreadGroup(g1, "g2");
		g2.list(); // (8)
		
		System.out.println("----***-------888--------***-------***--------***--------");
		
		g2.setMaxPriority(Thread.MAX_PRIORITY);
		g2.list(); // (9)
		
		System.out.println("----***-------999--------***-------***--------***--------");
		
		// Add a bunch of new threads to g2:
		for (int i = 0; i < 5; i++)
			new Thread(g2, Integer.toString(i));
		// Show information about all threadgroups
		// and threads:
		sys.list(); // (10)
		
		System.out.println("----***-------***--------***-------***--------***--------");
		
		System.out.println("Starting all threads:");
		Thread[] all = new Thread[sys.activeCount()];
		sys.enumerate(all);
		for (int i = 0; i < all.length; i++)
			if (!all[i].isAlive())
				all[i].start();
		// Suspends & Stops all threads in
		// this group and its subgroups:
		System.out.println("All threads started");
		sys.suspend(); // Deprecated in Java 1.2
		// Never gets here...
		System.out.println("All threads suspended");
		sys.stop(); // Deprecated in Java 1.2
		System.out.println("All threads stopped");

	}
}
