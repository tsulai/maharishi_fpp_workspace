package lesson8.exercise_2;

public class Main {

	public static void main(String[] args) {
		//Single-node list
		Node startNode = new Node();
		startNode.data = "A";
		System.out.println(startNode);
		
		//Two-node list
		Node next = new Node();
		next.data = "B";
		startNode.next = next;
		System.out.println(startNode);
		
		//Three-node list -- add a node C to the list; (expected: A B C)
		Node C = new Node();
		C.data = "C";
		next.next = C;
		
		//implement
		System.out.println(startNode);
		
		//Remove B from the list (expected output: A C)
		
		  //implement
		startNode.next = C;
		System.out.println(startNode);
		
		//Insert X into position 1  (expected output: A X C)
		     //implement
		Node X = new Node();
		X.data = "X";
		startNode.next = X;
		X.next = C;
		
		System.out.println(startNode);

	}

}
