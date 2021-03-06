package practise_final;



public class NodeStack {//LIFO
	private Node top;
	
	public int pop() {			
		int val = peek();
		top = top.next;
		return val;		
	}
	
	public int peek() {		
		return top.data;			
	}
	
	public void push(int val) {
		Node newNode = new Node();
		newNode.data = val;
		
		newNode.next = top;
		top = newNode;		
	}
	
	public class Node{
		Node next;
		int data;	
		
		public String toString() {
			return String.valueOf(data);
		}
		
	}
	@Override
	public String toString() {		
		return String.valueOf(top);
	}
	
	public static void main(String[] args) {
		NodeStack stack = new NodeStack();
		//MyStringStack stack = new MyStringStack();
		stack.push(11);
		stack.push(12);
		stack.push(13);
		System.out.println("stack items: " + stack.toString());
		System.out.println("Popping…"+stack.pop());
		System.out.println("stack items: " + stack.toString());
		System.out.println("Peeking…."+stack.peek());
		System.out.println("stack items: " + stack.toString());
		System.out.println("Popping…"+stack.pop());
		System.out.println("stack items: " + stack.toString());

	}

}
