package Iterator.a_sample;

public class PurchaseOfCopA extends Purchase {
	public PurchaseOfCopA() {}
	
	public Iterator createIterator() {
		return new ForwardIterator(this);
	}
}
