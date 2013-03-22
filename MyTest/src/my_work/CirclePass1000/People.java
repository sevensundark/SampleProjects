package my_work.CirclePass1000;

public class People {
	private int index;
	private People leftPeople;
	private People rightPeople;
	
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public People getLeftPeople() {
		return leftPeople;
	}
	public void setLeftPeople(People leftPeople) {
		this.leftPeople = leftPeople;
	}
	public People getRightPeople() {
		return rightPeople;
	}
	public void setRightPeople(People rightPeople) {
		this.rightPeople = rightPeople;
	}
	
	public void delete() {
		this.leftPeople.setRightPeople(this.rightPeople);
		this.rightPeople.setLeftPeople(this.leftPeople);
		this.rightPeople = null;
		this.leftPeople = null;
	}
}
