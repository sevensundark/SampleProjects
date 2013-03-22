package Iterator.a_sample;

public class PurchaseOfCopB extends Purchase {
	public PurchaseOfCopB() {}
	
	public Iterator createIterator() {
		return new BackwardIterator(this);
	}
}
