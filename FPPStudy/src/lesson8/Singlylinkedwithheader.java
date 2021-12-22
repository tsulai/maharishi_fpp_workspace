package lesson8;

public class Singlylinkedwithheader {
	Node header = null;//contains no data, cannot be removed
	
	public Singlylinkedwithheader() {
		header = new Node();//header is also a node but no data
	}	
	boolean search(String s) {
		if(s== null) return false;
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
			String s = next.toString();
			System.out.println(s);
		}
	}
	void addFirst(String s) {
		Node newNode = new Node();
		newNode.data = s;
		
		newNode.next = header.next;
		
		header.next = newNode;		
	}
	
	void addLast(String s) {
		Node newNode = new Node();
		newNode.data = s;
		Node last = header;//last ဖြစ်မဖြစ်က header ကနေ စရှာ
		while(last.next != null) {
			last = last.next;//nullမဖြစ်သေးသရွေ့ last ထဲ နောက် node တွေထည့်သွား
			//finally left with last node
		}
		last.next = newNode;
	}
	void insert(String s, int pos) {//insert လုပ်တဲ့အတွက် နေရာသိရမယ် ပါရမယ်
		int size = size();
		if(pos< 0 || pos > size) {
			throw new IllegalArgumentException("Illegal postion for new node");			
		}
		if(pos == size) addLast(s);
		else if(pos == 0) addFirst(s);//start from 0
		else {
			Node n = new Node();
			n.data = s;
			if(header.next == null) header.next = n;//nothing insert yet - first data insert
			else {
				Node temp = header.next;
				int count = 1;
				while(count < pos) {
					temp = temp.next;
					count++;
				}
				//temp - ရှာတွေ့တဲ့နောက်မှာ ထည့်မှာ thats y start count from 1 ထားတာ
				Node last = temp.next;//temp ရဲ့လက်ရှိ next ကိုလည်းသိမ်းရအုံးမယ်။
				temp.next = n;//new Node
				n.next = last;
			}
		}
	}
	
	/** size = the number of non-null nodes */
	int size() {
		if(header.next == null) return 0;
		Node temp = header.next;//ရှေ့ကကောင်ထည့်ထားတာ
		int count = 0;
		while(temp != null) {
			count++;
			temp = temp.next;
		}
		return  count;
	}
	void remove(String s) {
		if(s == null) return;
		Node next = header.next;
		Node previous = header;//current node
		//if next == null, s cannot removed
		while (next!= null) {
			if(s.equals(next.data)) {//ရှေ့က ကောင်က ရှာတဲ့ကောင်နဲ့တူတယ်ဆိုရင် 
				previous.next = next.next;//လက်ရှိကောင်ရဲ့ next ထဲ ရှေ့ကကောင်ရဲ့ next ပြောင်းလိုက်
				return;
			}
			//if no equal found
			previous = next;//ရှာပြီးသွားတဲ့ဟာ
			next = next.next;
		}
	}
	/** Implement as inner class */
	private class Node{
		String data;
		Node next;		
	//Becky Frank Albert Billy Charles Emma Francesca Bubba Bobby 
	//two types of toString methods in Node
	//this will return StringBuilder when called	
	private StringBuilder toString(StringBuilder sb, Node n)
	{
		//next node အကုန်လုံး till null ထိ append လုပ်မယ့်ကောင်
		//Node n must pass - cz of recursive will retrieve all next node
		if(n == null) return sb;//this is base case, နောက်ဆုံး nullမှာ resultထွက်မှာ 
		sb.append(n.data + " ");//2.Becky" "Frank" "
		return toString(sb, n.next);//3.Becky" "Frank" "Albert" "
		//*** recursive - to append all nodes data next node next node next node 
	}
	//this will return String when called	
	@Override
	public String toString() {//current node.data
		if(data == null) return "";
		StringBuilder sb = new StringBuilder(data + " ");//Becky " " //current node data
		sb = toString(sb, next);//Becky" "Frank" "Albert" " = toString(Becky" ", Frank)//1.
		return sb.toString();
	}	
	}
	
	public static void main(String[] args) {
		String[] stringData =  {"Albert", "Billy", "Charles", "David", "Emma"};
		Singlylinkedwithheader sll = new Singlylinkedwithheader();
		//populate
		for(int i = stringData.length - 1; i>=0; i--) {
			sll.addFirst(stringData[i]);
		}
		boolean foundCharles = sll.search("Charles");
		System.out.println("Found Charles? " + foundCharles);
		
		sll.printNodes();
		
		
	}
}
