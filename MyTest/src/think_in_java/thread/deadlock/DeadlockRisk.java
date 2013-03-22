package think_in_java.thread.deadlock;

class DeadlockRisk {
	private static class Resource {
		public int value;
	}

	private Resource resourceA = new Resource();
	private Resource resourceB = new Resource();

	public void read() {
		System.out.println("===========read  begin===========");
		synchronized (resourceA) {
			System.out.println("read():" + Thread.currentThread().getName()
					+ "获取了resourceA 的锁！");
			synchronized (resourceB) {
				System.out.println("read():" + Thread.currentThread().getName()
						+ "获取了resourceB 的锁！");
			}
		}
		System.out.println("===========read  end=============");
	}

	public void write(int a, int b) {
		System.out.println("===========write begin===========");
		synchronized (resourceB) {
			System.out.println("write():" + Thread.currentThread().getName()
					+ "获取了resourceB 的锁！");
			synchronized (resourceA) {
				System.out.println("write():" + Thread.currentThread().getName()
						+ "获取了resourceA 的锁！");
				resourceA.value = a;
				resourceB.value = b;
			}
		}
		System.out.println("===========write end=============");
	}
}
