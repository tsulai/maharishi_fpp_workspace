package iteratorYT;

import java.util.Iterator;
import java.util.LinkedList;

public class iteratorYT {

	public static void main(String[] args) {
		LinkedList<String> names = new LinkedList<String> ();
		names.push("John");
		names.push("Smith");
		names.push("Bob");
		//push က ရှေ့ကို push သွားတာ
		
		Iterator it = names.iterator();
		System.out.println(it.next());//Bob
		System.out.println(it.next());
		System.out.println(it.next());
		//System.out.println(it.next()); //this gives error - cz only three item exists
		//to prevent the error
		
		if(it.hasNext()) {
			System.out.println(it.next());
		}
		
		//all output coming by using while
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}

}
