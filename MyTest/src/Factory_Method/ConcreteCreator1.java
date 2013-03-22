package Factory_Method;

public class ConcreteCreator1 implements Creator {

	public Product factory() {
		return new ConcreteProduct1();
	}
}
