package prog9_1_soln;

public class MyStringStack {
	private MyStringLinkedList list;
	
	public MyStringStack(){
		list = new MyStringLinkedList();
	}

	public String pop() {
		String val = peek();
		list.remove(val);
		return val;
	}
	
	public void push(String str){
		list.addFirst(str);
	}
	
	public String peek(){
		return list.get(0);
	}
	
	public static void main(String[] args) {
		MyStringStack stack = new MyStringStack();
		stack.push("Bob");
		stack.push("Harry");
		stack.push("Alice");
		System.out.println("Popping..."+stack.pop());
		System.out.println("Peeking..."+stack.peek());
		System.out.println("Popping..."+stack.pop());
	}

}
