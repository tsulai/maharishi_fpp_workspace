package HashTableYT;

public class Entry {
	int key;
	Object value;
	Entry next;//array ထဲမှာ linkedlist နဲ့ သိမ်းမှာမို့ ဒီ entry ပြီး next entry သိဖို့လို
	public Entry(int key, Object value) {
		this.key = key;
		this.value = value;
		next =null;
	}
	public Entry() {//no args constructor ခေါ်ရင် array ထဲ null တွေထည့်ပြီး initialize
		next = null;//initialise array with null value
	}
	public int GetKey() {
		return key;
	}
	public Object GetValue() {
		return value;
	}
}
