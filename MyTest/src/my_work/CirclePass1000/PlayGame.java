package my_work.CirclePass1000;

public class PlayGame {

	private static final int COUNT = 100000;
	private static final int SPACE = 3;
	
	public static void main(String[] args) {
		long t1 = System.currentTimeMillis();
		Manager m = new Manager(COUNT, SPACE);
		m.play();
		long t2 = System.currentTimeMillis();
		System.out.println(t2 - t1);
		
		System.out.println("-----------------");
		
		t1 = System.currentTimeMillis();
		play();
		t2 = System.currentTimeMillis();
		System.out.println(t2 - t1);
	}

	
	private static void play() {
		int[] arr = new int[COUNT];
		for (int i = 0; i < arr.length; i++) {
			arr[i] =  i + 1;
		}
		
		int index = 0;
		int delCount = 0;
		while (delCount < COUNT - 1) {
			int temCount = 0;
			while (true) {
				index = (index == COUNT) ? 0 : index;
				
				if (arr[index] >= 0) {
					temCount++;
				}
				
				if (temCount == SPACE) {
					break;
				}
				
				index++;
			}
			
//			index = (index + SPACE) % (COUNT);
			arr[index] = -1;
			index++;
			delCount++;
		}
		
		for (int j = 0; j < arr.length; j++) {
			if (arr[j] > 0) {
				System.out.println(arr[j]);
				break;
			}
		}
	}
}
