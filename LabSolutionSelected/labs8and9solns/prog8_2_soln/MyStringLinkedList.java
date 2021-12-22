package prog8_2_soln;

public class MyStringLinkedList {
	Node header;
	MyStringLinkedList(){
		header = new Node(null);
	}
	/** Adds item to the front of the list */
	public void addFirst(String item){
		Node n = new Node(item);
		//place new node after header and 
		//establish links from new node to 
		//surrounding nodes
		n.next = header.next;
		n.previous = header;
		
		//establish links from surrounding 
		//nodes to the new node
		if(header.next != null){
			header.next.previous = n;
		}		
		header.next = n;	
	}
	
	/** Adds item to the end of the list */
	public void addLast(String item) {
		Node n = new Node(item);
		//find last node
		Node last = header;
		while(last.next != null) {
			last = last.next;
		}
		//now last.next == null
        last.next = n;
        n.previous = last;
	}
	
	/** Removes the node in last position if there is one; otherwise, does nothing */
	public void removeLast( ) {
		//if list is empty, return
		if(header.next == null) return;
		
		Node current = header;
		//traverse the list until current.next is 
		//null - then remove current
		while(current.next != null) {
			current = current.next;
		}
		//now current.next == null, so remove current
		Node previous = current.previous; 
		//previous is not null since current is not header
		previous.next = null;
		current.previous = null;
	}
	
	/** Returns true if input string is in the list, false otherwise */
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
	
	/** Returns Node at position pos */
	private Node getNode(int pos) {
		if (pos >= size()) throw new IndexOutOfBoundsException();		
		Node next = header;
		for(int i = 0; i <= pos; ++i){
			next = next.next;			
		}
		//next is the node we are seeking
		return next;
	}
	
	/** Gets the value stored in the node in position pos */
	public String get(int pos){
		Node node = getNode(pos);
		return (node != null) ? node.value : null;
	}
	/** Returns the index of the String s in the list, if found; 
	 *  returns -1 otherwise 
	 */
	public int find(String s){
		if(s == null) return -1;
		Node currentNode = header;
		int i = -1;
		while(currentNode.next != null){
			++i;
			currentNode = currentNode.next;
			if(s.equals(currentNode.value)) return i;
		}
		return -1;
	}
	
	public int size() {
		int count = 0;
		Node next = header.next;
		while(next != null){
			++count;
			next = next.next;
		}
		return count;
	}
	
	///////////// lab solutions ///////////////
	
	//old
	public boolean recurSearch(String s) {
		return recurSearch(s, header.next);
	}
	
	//old
	private boolean recurSearch(String s, Node n) {
		if(n == null) return false;
		else if(n.value.equals(s)) return true;
		return recurSearch(s, n.next);
	}
	
	public void insert(String s, int pos) {
		if(pos < 0 || pos > size()) {
			throw new IndexOutOfBoundsException("pos = "+pos +
					" and size = "+size());
		}
		//find node previous to insertion point
		Node previous = header;
		for(int i = 0; i < pos; ++i) {
			previous = previous.next;
		}
		//previous is node just before insertion point
		//if previous.next == null, we are adding to the end of the list
		if(previous.next == null) {
			addLast(s);
		}
		
		//otherwise, we are inserting between two nodes
		else {
			//make new node's next be previous.next; 
			//make new node's previous be previous
			Node newNode = new Node(s);
			
			//add links from new node to surrounding nodes
			newNode.next = previous.next;
			newNode.previous = previous;
			
			//add links from surrounding nodes to new node
			previous.next = newNode;
			newNode.next.previous = newNode;
		}
	}
	
//	public void insert2(String s, int pos) {
//		if(pos > size()) {
//			throw new IndexOutOfBoundsException("pos = "+pos +" but size = "+size());
//		}
//		//this block handles pos == size
//		Node next = header;
//		boolean inserted = false;
//		for(int i = 0; i <= pos; ++i){
//			if(next.next == null) {
//				next.next = new Node(null, next, s);
//				inserted = true;
//			} else {
//				next = next.next;
//			}
//		}
//		//this block handles pos < size
//		if(!inserted) {
//			Node previous = next.previous;
//			Node insertNode = new Node(next,previous,s);
//			previous.next = insertNode;
//			next.previous = insertNode;
//		} 		
//	
//		
//	}
//	
//	
//	public void insert(String s, int pos) {
//		//corrected to throw exception
//		if(pos > size()) {
//			throw new IndexOutOfBoundsException("pos = "+pos +" but size = "+size());
//		}
//		Node next = header;
//		Node previous = null;
//		for(int i = 0; i <= pos; ++i){
//			if(i==pos){
//				previous = next;
//			}	
//			next = next.next;
//		}
//		Node insertNode = new Node(next,previous,s);
//		if(next != null){
//			next.previous = insertNode;
//		}
//		previous.next =insertNode;		
//	}

	/** remove object at specified index */
	public boolean remove(int index){
		Node toBeRemoved = getNode(index);
		if(toBeRemoved == null) return false;
		Node previous = toBeRemoved.previous;
		Node next = toBeRemoved.next;
		previous.next = toBeRemoved.next;
		if(next != null){
			next.previous = toBeRemoved.previous;
		}
		toBeRemoved = null;
		return true;
	}
	
	/** remove by specifying object -- removes
	 *  first occurrence of s
	 */
	public boolean remove(String s){
		int pos = find(s);
		if(pos == -1) return false;
		return remove(pos);		
	}	
	
	
	public String toString(){
		Node next = header.next;
		String output = next.toString(); 
		
		return ("[" + output +"]");
	}
	
	/******* sorting ********/

	private void swap(Node s, Node t){
		String temp = s.value;
		s.value = t.value;
		t.value = temp; 
	}
	
	public void sort(){		
		int size = size();
		if(size<=1) return;
		Node curr = header;
		while(curr.next != null){
			curr = curr.next;
			Node min = minNode(curr);
			//this places the min val in curr,
			//so we do not need to reset value of curr here
			swap(min,curr);			
		}		
	}
	
	//find the Node having min value nested inside theNode
	public Node minNode(Node theNode){
		if(theNode == null || theNode.next == null) return theNode;
		String minVal = theNode.value;
		Node minNode = theNode;
		Node currentNode = theNode;
		while(currentNode.next != null){
			currentNode = currentNode.next;
			if(currentNode.value.compareTo(minVal) < 0) {
				minVal = currentNode.value;
				minNode = currentNode;
			}
		}
		return minNode;
	}

	/********* end sorting ********/
	
	/******** optional: binary search methods ********/
	
	//search a sorted array
	//Note: because locating the middle value in
	//the list takes linear time each time it's performed,
	//binary search for linked lists is no more efficient
	//than the usual find method
	boolean binSearch(String val) {
		boolean b = recurse(0, size() - 1, val);
		return b;
	}


	boolean recurse(int lower, int upper, String val) {
		int mid = (lower + upper) / 2;
		if(get(mid).equals(val)) return true;
		if(lower > upper) return false;
		if(val.compareTo(get(mid))>0) 
			return recurse(mid + 1, upper, val);
		return recurse(lower,mid - 1,val);
	}

	/********* end binary search methods *****/
	
	class Node  {
		String value;
		Node next;
		Node previous;
		Node(String value){
			this.value = value;
		}
		@Override
		public String toString() {
		    if(value == null) return "";
			StringBuilder sb = new StringBuilder(value + " ");
			sb = toString(sb, next);
			return sb.toString();
		}
		private StringBuilder toString(StringBuilder sb, Node n) {
			if(n == null) return sb;
			sb.append(n.value + " ");
			return toString(sb, n.next);
		}
	}

	public static void main(String[]args){
		MyStringLinkedList l = new MyStringLinkedList();
		
		l.addFirst("Jim");
		l.addFirst("Jim");
		l.addFirst("Dave");
		l.insert("Tom", 3);
		l.insert("Bob", 0);
		System.out.println("Check insert method: Expect Bob Dave Jim Jim Tom " + l);
		l.addFirst("Jim");
		l.addFirst("Ricardo");
		l.sort();
		System.out.println("Check sort method: Expect Bob Dave Jim Jim Jim Ricardo Tom " + l);
		l.remove("Ricardo");
		System.out.println("Check remove method: Expect Bob Dave Jim Jim Jim Ricardo Tom " + l);
//		l.recurSearch("Dave");
//		System.out.println("Check recurSearch: Expect true " 
//		   + l.recurSearch("Dave"));		
	}
}


