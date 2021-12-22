package lec5.nested;

public class Main {

	public static void main(String[] args) {
		Outer outer = new Outer();
		outer.outerDisplay();
		
		Outer.Inner i = new Outer().new Inner();
	}

}
