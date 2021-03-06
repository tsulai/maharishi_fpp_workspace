package HashTableYT;

public class HashTableArray<T> {
	Entry[] arrayHash;//entry တွေပါတဲ့ array - entry obj တစ်ခု ကြေငြာတာမဟုတ်
	int size;
	
	public HashTableArray(int size) {
		this.size = size;
		arrayHash = new Entry[size];
		for(int i = 0; i<size; i++) {
			arrayHash[i] = new Entry();//1. Entry obj ထည့်ထားပြီးသား
		}
	}
	//give key from entry
	//GetHash give specific index to keep in array
	int GetHash(int key) {
		return key%size;
	}
	
	public void put(int key, Object value) {
		int HashIndex = GetHash(key);
		Entry ArrayValue = arrayHash[HashIndex];//2. arrayHash ထဲက HashIndexမှာရှိတဲ့ Entry obj value ကိုယူလိုက်တာ  (arrayHash ထဲက value အကုန်လုံးက Entry obj တွေဖြစ်ပြီးသား next= null တွေနဲ့)
		Entry newItem = new Entry(key, value);
		newItem.next = ArrayValue.next;
		ArrayValue.next = newItem;
	}
	public T get(int key) {
		T value = null;
		int HashIndex = GetHash(key);
		Entry ArrayValue = arrayHash[HashIndex];//head ကိုထောက်တာ
		while(ArrayValue != null) {
			if(ArrayValue.GetKey() == key) {
				value = (T) ArrayValue.GetValue();				
				break;
			}
			ArrayValue = ArrayValue.next;
		}
		return value;
	}
	
}
