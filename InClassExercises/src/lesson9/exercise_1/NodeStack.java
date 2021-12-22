package lesson9.exercise_1;
@SuppressWarnings("unused")
public class NodeStack {
	private Node top;
	
	public void push(String s) {
		//implement
		Node newNode = new Node();
		newNode.data = s;		
		newNode.next = top;//top become second
		top = newNode;
		
	}
	public String peek() {
		if(top != null) {
			return top.data;
		}else {
			return null;
		}
		
	}
	public String pop() {		
		if(top != null) {
			String s = peek();
			top = top.next;
			return s;
		}else {
			return null;
		}		
	}
	
	public static void main(String[] args) {
		NodeStack stack = new NodeStack();
		stack.push("A");
		stack.push("B");
		stack.push("C");
		stack.push("D");
		stack.push("E");
		stack.push("F");
		System.out.println(stack.peek());
		System.out.println(stack.top.toString());
		System.out.println(stack.pop());
		System.out.println(stack.top.toString());
		
}
}


