package prog9_4_soln;

public class NodeQueue {
	/* stores the element at the front of the queue, if it exists */
	private Node head;
	
	/* stores the element at the end of the queue, if it exists */
	private Node tail;
	
	public void enqueue(String s) {
		Node n = new Node();
		n.data = s;
		
		if(head == null) { //in that case, tail is also null
			head = tail = n;
		} else { //head and tail both non-null
			tail.next = n;
			tail = tail.next;
		}
	}
	
	public String dequeue() throws QueueException {
		if(isEmpty()) throw new QueueException("Cannot dequeue an empty queue");
		String val = head.data;
		head = head.next;
		return val;
	}
	
	public String peek() throws QueueException {
		if(isEmpty()) throw new QueueException("Cannot peek at an empty queue");
		String val = head.data;
		return val;
	}
	
	public boolean isEmpty() {
		return head == null;
	}
	
	@Override
	public String toString() {
		if(isEmpty()) return "<empty queue>";
		return head.toString();
	}
	
}
