package HashTableYT;
/*https://www.youtube.com/watch?v=SdqN_s-0ZYY*/
public class Main {

	public static void main(String[] args) {
		HashTableArray<String> hm = new HashTableArray<String>(10);
		hm.put(11, "Jenny");
		hm.put(12, "Hellow");
		hm.put(13, "Smith");
		System.out.println(hm.get(12));
	}

}
