package AOP;

public class ProxySubject extends Subject {

	private RealSubject realSubject;
	
	public ProxySubject() {}
	
	public void request() {
		preRequest();
		
		if (realSubject == null) {
			realSubject = new RealSubject();
		}
		realSubject.request();
		
		postRequest();
	}
	
	private void preRequest() {
		System.out.println("do preRequest.");
	}

	private void postRequest() {
		System.out.println("do postRequest.");
	}
}
