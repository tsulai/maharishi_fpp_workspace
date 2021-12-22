package lesson8.doublylinked;

import lesson8.doublylinked.MyStringLinkedList.Node;

public class MyStringLinkedList {

	Node header;
	MyStringLinkedList(){
		header = new Node(null);
	}
	public void addFirst(String item) {
		Node n = new Node(item);
		n.next = header.next;
		n.previous = header;
		
		if(header.next != null) {
			header.next.previous = n;
		}
		header.next = n;
	}
	
	public void addLast(String item) {
		Node n = new Node(item);
		Node last = header;
		while(last.next != null) {
			last = last.next;
		}
		last.next = n;
		n.previous = last;		
	}
	
	public void removeLast() {
		if(header.next == null) return;
		Node current = header;
		while(current.next != null) {
			current = current.next;
		}
		//we got last node
		Node previous = current.previous;
		previous.next = null;
		current.previous = null;//remove link from previous		
	}
	//determines whether the input string is in the list
	public boolean search(String s) {
			Node next = header.next;
			while(next != null && !next.value.equals(s)) {
				next = next.next;
			}
			//either next == null or next.value is s
			if(next == null) return false;
			else {//next.value.equals(s) 
				return true;
			}
	}
	
	class Node{
		String value;
		Node next;
		Node previous;
		Node(String value){
			this.value = value;
		}
		public String toString() {
			return value == null ? "null" : value;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
