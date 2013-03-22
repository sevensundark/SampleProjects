package Factory_Method;

public class Client {
	
	private static Creator creator1, creator2;
	private static Product product1, product2;
	
	public static void main(String[] arg) {
		creator1 = new ConcreteCreator1();
		product1 = creator1.factory();
		creator2 = new ConcreteCreator2();
		product2 = creator2.factory();
	}
}
