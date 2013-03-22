package Iterator.a_sample;

public class ForwardIterator implements Iterator {

	private int state;
	private Purchase obj;
	
	public ForwardIterator(Purchase anObj) {
		obj = anObj;
	}
	
	@Override
	public void first() {
		state = 0;
	}

	@Override
	public void next() {
		if (!isDone()) {
			state++;
		}
	}

	@Override
	public boolean isDone() {
		if (state > obj.count() - 1) {
			return true;
		}
		return false;
	}

	@Override
	public Object currentItem() {
		return obj.currentItem(state);
	}

}
