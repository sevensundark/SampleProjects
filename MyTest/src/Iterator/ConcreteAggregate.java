package Iterator;

public class ConcreteAggregate extends Aggregate {
	private Object[] obj = {"Monk Tang", "Monkey", "Pigsy", "Sandy", "Horse"};
	
	public Iterator createIterator() {
		return new ConcreteIterator();
	}
	
	private class ConcreteIterator implements Iterator {
		private int currentIndex = 0;

		@Override
		public void first() {
			currentIndex = 0;
		}

		@Override
		public void next() {
			if (currentIndex < obj.length) {
				currentIndex++;
			}
		}

		@Override
		public boolean isDone() {
			return currentIndex == obj.length;
		}

		@Override
		public Object currentItem() {
			return obj[currentIndex];
		}
	}
}
