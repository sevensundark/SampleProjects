package IOC.before;

public class Business {
	private RealWriter writer = new RealWriter();
	
	public void save() {
		System.out.println("Business--save:begin");
		writer.saveToReal();
		System.out.println("Business--save:end");
	}
}
