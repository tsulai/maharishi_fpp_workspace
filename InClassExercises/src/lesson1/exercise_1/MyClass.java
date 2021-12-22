package lesson1.exercise_1;

class MyClass {
	 MyClass(){
	 TheSubclass sub = new TheSubclass();
	 System.out.println("The Class constructor");
	 }
	public static void main(String[] args){
	new TheSubclass();
	}
	}
	class TheSubclass extends MyClass {
	 TheSubclass() {
	 System.out.println("The Subclass constructor");
	 }
	}



