package my_work.CirclePass1000;

import java.util.ArrayList;
import java.util.List;

public class Manager {
	public int count;
	public int space;

	public List<People> circle;
	
	public Manager(int num, int space) {
		this.count = num;
		this.space = space;
		
		circle = new ArrayList<People>();
		for (int i = 0; i < count; i++) {
			People p = new People();
			p.setIndex(i + 1);
			circle.add(p);
		}
		
		for (int j = 0; j < circle.size(); j++) {
			if (j == 0) {
				circle.get(j).setRightPeople(circle.get(j + 1));
				circle.get(j).setLeftPeople(circle.get(circle.size() - 1));
			} else if (j == circle.size() - 1) {
				circle.get(j).setRightPeople(circle.get(0));
				circle.get(j).setLeftPeople(circle.get(j - 1));
			} else {
				circle.get(j).setRightPeople(circle.get(j + 1));
				circle.get(j).setLeftPeople(circle.get(j - 1));
			}
		}
	}
	
	public void play() {
		People p = circle.get(0);
		while (p.getLeftPeople() != p && p.getRightPeople() != p) {
			for (int i = 0; i < space; i++) {
				p = p.getRightPeople();
			}
			p.getLeftPeople().delete();
		}
		
		System.out.println(p.getIndex());
	}
}
