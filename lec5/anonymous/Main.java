package lec5.anonymous;

public class Main {

	public static void main(String[] args) {
		MyAbstractClass m = new MyAbstractClass() {
			public void display() {
				System.out.println("Anonymous Inner Class extends MyAbstractClass");
			}
		};
		m.display();
		
		MyInterface mi = new MyInterface() {
			public void display() {
				System.out.println("Anonymous Inner Class implements MyInterface");
			}
		};
		mi.display();
	}
}
