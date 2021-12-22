package lesson3.exercise_3;

public class CountInstances {
	
	private static int count = 0;
	
	CountInstances(){
		count++;
	}
	
	public static int getCount() {
		return count;
	}

	public static void main(String[] args) {
		for(int i = 1; i<=10; i++) {
			new CountInstances();
		}
		System.out.println(CountInstances.getCount());
	}

}
