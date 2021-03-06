package practise_final_inclass;

import org.w3c.dom.Node;

//this answer is provided by professor
public class NodeStack {
	private Node topNode = null;
	
	public void push(String val) {
		if(topNode == null) topNode = new Node(val, null);
		else {
			topNode = new Node(val, topNode);
		}
	}
	
	public String peek() {
		if(topNode == null) return null;
		else return topNode.data;
	}
	
	public String pop() {
		if(topNode == null) return null;
		else {
			String retval = topNode.data;
			topNode = topNode.next;
			return retval;
		}
	}
	class Node {
		 private String data;
		 private Node next;
		 Node(String data, Node next) {
		 this.data = data;
		 this.next = next;
		 }
		 }
}
