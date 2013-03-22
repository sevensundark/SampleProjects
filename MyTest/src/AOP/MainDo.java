package AOP;

public class MainDo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Subject proxySubject = new ProxySubject();
		proxySubject.request();
	}

}
