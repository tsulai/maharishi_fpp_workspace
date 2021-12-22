package lesson11.needoverridehashcode;

import java.util.GregorianCalendar;
import java.util.HashMap;

public class Main {

	
	public static void main(String[] args) {
		Person p1 = new Person("Joe", "Smith", 100000, new GregorianCalendar(1988, 5, 5));
		Person p2 = new Person("Anne", "Jones", 80000, new GregorianCalendar(1986, 3, 9));
		
		MyHashtable h = new MyHashtable();
		//HashMap h = new HashMap();
		Pair key1 = new Pair(p1.getFirstName(), p1.getLastName());
		Pair key2 = new Pair(p2.getFirstName(), p2.getLastName());
		//pair က hashmap မှာ key အဖြစ်သုံးမယ့် obj 
		//map ထဲက ပြန်ထုတ်ရင် သူ့ equals method ကိုခေါ်ပြီး ပြန်ထုတ်မှာ 
		//အာ့ကြောင့် key အဖြစ်သုံးမယ့် obj ထဲမှာ equals method ရေးရင် hashCode method လည်း override လုပ်ပြီးရေးထားရမယ်။
		h.put(key1, p1);
		h.put(key2, p2);
		
		Pair lookup = new Pair("Joe", "Smith");//key1 == p1 ဖြစ်သလားရှာမှာ
		System.out.println(lookup.equals(key1));//true //key1 and joe, smith equal
		System.out.println(h.get(lookup));//Joe Smith: 100000.0, 1988
		System.out.println(h.containsKey(lookup));//true
		
		System.out.println(key1.hashCode());
		System.out.println(lookup.hashCode());
		
		
	}

}
