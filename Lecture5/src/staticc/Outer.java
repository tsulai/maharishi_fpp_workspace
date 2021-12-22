package staticc;

public class Outer{
	static int x =10;
	int y = 20;
	
	void show() {
		System.out.println("outer instance show method");
	}
	static void showStatic() {
		System.out.println("outer static show method");
	}
	static class Inner {
		void display() {
			System.out.println(x);
			//System.out.println(y);
			 
			//show();
			showStatic();
			
		}
	}

}
