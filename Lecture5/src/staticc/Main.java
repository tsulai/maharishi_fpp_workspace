package lec5.staticc;

public class Main {

	public static void main(String[] args) {
		Outer.Inner inner = new Outer.Inner();
		inner.display();
		
		//Outer.Inner i = new Outer().new Inner();
	}

}
