package recursive_practise;

import recursive_practise.MyStringLinkedList.Node;

public class SinglyLinkedListWithHeader {
	Node header = null; //contains no data, cannot be removed
	
	public SinglyLinkedListWithHeader() {
		//header should never be null
		header = new Node();
	}
	boolean search(String s) {
		if(s == null) return false;
		//start node for searches is header.node
		Node next = header.next;
		while(next != null) {
			String t = next.data;
			if(s.equals(t)) {
				return true;
			}
			next = next.next;
		}
		return false;
	}
	
	void printNodes() {
		Node next = header.next;
		if(next == null) System.out.println("");
		else {
			String s= next.toString();
			System.out.println(s);
		}
	}
	
	void addFirst(String s) {
		Node newNode = new Node();
		newNode.data = s;
		
		//link from newNode to current header.node
		newNode.next = header.next;
		
		//link from header to newNode
		header.next = newNode;		
	}
	
	void addLast(String s) {
		Node newNode = new Node();
		newNode.data = s;
		Node last = header;
		while(last.next != null) {
			last = last.next;
		}
		//now last is the last non-null node
		last.next = newNode;		
	}
	void insert(String s, int pos) {
		int size = size();
		if(pos < 0 || pos > size) {
			throw new IllegalArgumentException(
				"Illegal position for new node");
		}
		if(pos == size) addLast(s); //same as add(s);
		else if(pos == 0) addFirst(s);
		else {
			Node n = new Node();
			n.data = s;
			if(header.next == null) header.next = n;
			else {
				Node temp = header.next;
				int count = 1; 
				while(count < pos) {
					temp = temp.next;
					count++;
				} 
				//insert n between temp and temp.node
				Node last = temp.next;
				temp.next = n;
				n.next = last;  //placing n into position pos
			}
		}
	}
	
	/** size = the number of non-null nodes */
	int size() {
		if(header.next == null) return 0;
		Node temp = header.next;
		int count = 0;
		while(temp != null) {
			count++;
			temp = temp.next;
		}
		return count;	
	}
	
	void remove(String s) {
		if(s == null) return;
		Node next = header.next;
		Node previous = header;
		//if next == null, s cannot be removed
		while(next != null) {
			if(s.equals(next.data)) {
				previous.next = next.next;
				return;
			}
			previous = next;
			next = next.next;		
		}
	}
	//1 -> 2 -> 3 -> 4 -> 5
	//1 <- 2 <- 3 <- 4 <- 5
	// 4  .next = 5;
	//head.next = 5 
	//head.next.next = head means 5.next = 4 // reverse ပြန်လှည့်လိုက်တာ 
	public static Node reverseNode(Node head) {
		if(head == null) return head;
		if(head.next == null) return head;
		
		Node newHeadNode = reverseNode(head.next);
		head.next.next  = head;//4 ထဲကို 4->5 သွားတဲ့ အသွား link ဖြုတ်လိုက်တာ .. reverse link ထည့်တာ
		head.next = null;
		return newHeadNode;
	}
	
	/** Implement as inner class */
	private class Node {
		String data;
		Node next;
		
		@Override
		public String toString() {
		    if(data == null) return "";
			StringBuilder sb = new StringBuilder(data + " ");//1. အစ data နဲ့ " " ကို စထည့်ပေးလိုက်တယ်
			sb = toString(sb, next);//2. StringBuilder return ပြန်တဲ့ နောက် toString method ကို ထပ်ခေါ်လိုက်တယ် 
			return sb.toString();
		}
		private StringBuilder toString(StringBuilder sb, Node n) {
			if(n == null) return sb;//3. next node မရှိတော့ဘူးဆိုရင် sb ကြီး return ပြန် မဟုတ်ရင်
			sb.append(n.data + " ");//4. ရောက်လာတဲ့ sb နဲ့ next node data နဲ့ append လုပ်ပေးလိုက် ပြီး 
			return toString(sb, n.next);//ဒါကိုပဲ next node ထပ်ထည့်ပေးပြီး return ပြန်တယ်
		}
		
		
	}
	
	public static void main(String[] args) {
		String[] stringData = {"Albert", "Billy", "Charles", "David", "Emma"};
		SinglyLinkedListWithHeader sll = new SinglyLinkedListWithHeader();
		//populate
		for(int i = stringData.length -1; i >= 0; i--) {
			sll.addFirst(stringData[i]);
		}
		//sll.printNodes();
		sll.addFirst(sll.reverseNode(sll.header).data);
		sll.printNodes();
//		boolean foundCharles = sll.search("Charles");
//		System.out.println("Found Charles? " + foundCharles);
//		System.out.println("---------------");
//		sll.printNodes();
//		sll.addFirst("Frank");
//		sll.remove("David");
//		sll.printNodes();
//		sll.addLast("Francesca");
//		sll.printNodes();
//		System.out.println(sll.size());
//		sll.insert("Becky", 0);
//		sll.printNodes();
//		sll.insert("Bobby", sll.size());
//		sll.printNodes();
//		sll.insert("Bubba", sll.size()-1);
//		System.out.println("---------------");
//		sll.printNodes();
//		System.out.println("---------------");
//		sll.remove("Bobby");
//		sll.printNodes();
	}
}


