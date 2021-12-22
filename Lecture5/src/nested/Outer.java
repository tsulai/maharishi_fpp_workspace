package lec5.nested;

public class Outer {
	private int x = 10;

	class Inner {
		private int y = 20;

		private void innerDisplay() {
			System.out.println(x + " " + y);
		}
	}

	void outerDisplay() {
		Inner inner = new Inner();
		inner.innerDisplay();
		System.out.println(inner.y);
	}

}
