package lesson11.exercise_2;

import java.util.HashMap;

/*Use a hashtable as a fast way to solve the following 
problem:
You are given two arrays arr1 and arr2 of Strings
Determine whether every String contained
in arr1 is also contained in arr2. You may not
use nested loops*/
public class Subarray {

	public static void main(String[] args) {
		String[] arr1 = {"A", "C", "E"};
		String[] arr2 = {"A", "B", "C", "D", "E"};
		String[] arr3 = {"A", "C", "F"};
		System.out.println("Is arr1 a subarray of arr2? (Expected answer: yes) " + isSubArray(arr1, arr2));
		System.out.println("Is arr3 a subarray of arr2? (Expected answer: no) " + isSubArray(arr3, arr2));
	}
	
	/**
	 * Returns true if every string in arr1 is contained
	 * in arr2. Assume that neither array is null.
	 */
	public static boolean isSubArray(String[] arr1, String[] arr2) {
		//implement
		/*The var keyword was introduced in Java 10. Type inference is used in var keyword in which it detects automatically the datatype of a variable based on the surrounding context*/
		var h = new HashMap<String, String>();//create hasMap list
		for(String s: arr2) {//put all arr2 item into hashmap list
			h.put(s, s);
		}
		for(String s: arr1) {//check each item in arr1 contains in hashmap list (i.e. arr2 item)
			if(!h.containsKey(s)) return false;
		}
		return true;
		
	}
}
