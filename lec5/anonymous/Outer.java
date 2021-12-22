package lec5.anonymous;

public class Outer {
	void method() {
		MyAbstractClass m = new MyAbstractClass() {
			public void display() {
				System.out.println("Anonymous Inner Class");
			}
		};
		m.display();
	}
}
