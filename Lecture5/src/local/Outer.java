package lec5.local;

public class Outer {

	void display() {
		class Inner {
			void innerDisplay() {
				System.out.println("Local Inner");
			}
		}

		Inner inner = new Inner();
		inner.innerDisplay();
	}

}
