package lesson12.exercise_2;

public class StackException extends Exception {
	public StackException() {
		super();
	}
	public StackException(String msg) {
		super(msg);
	}
	public StackException(Throwable t) { 
		super(t);
	}
}
