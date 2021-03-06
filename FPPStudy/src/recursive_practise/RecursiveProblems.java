package recursive_practise;

import recursive_practise.MyStringLinkedList.Node;

/*1. Write a function that reverses a string. The input string is given as an array of characters 
s.
2. Reverse Linked List: Given the head of a singly linked list, reverse the list, and return the 
reversed list.
3. Merge Two Sorted Lists: You are given the heads of two sorted linked lists list1 and list2.
Merge the two lists in a one sorted list. Return the head of the merged linked list.
4. Find the frequency of given element in an array: Given array containing duplicates, find 
given element’s frequency.
5. Find the index of Max element in an array.
 * 
 */
public class RecursiveProblems {
	private MyStringLinkedList list;
	
	RecursiveProblems(MyStringLinkedList list){
		this.list = list;
	}
	//1
	public static String reverseString(char[] arr) {
		int len = arr.length;
		if(arr.length == 1) return String.valueOf(arr[0]);
		char[] recurArr = new char[len-1];
		System.arraycopy(arr, 0, recurArr, 0, len - 1);
		return String.valueOf(arr[len -1]) + reverseString(recurArr); 
		
	}
	//2
	public static void reverseLinkedList(Node header) {
		//if(header == null) return null;
		
		MyStringLinkedList rtnList = new MyStringLinkedList();
		rtnList.addFirst(reverseNode(header).value);		
		
		System.out.println(rtnList.toString());
		
		//return rtnList;
		
		
	}
	
	public static Node reverseNode(Node head) {
		if(head == null) return head;
		if(head.next == null )	return head;
		
		Node ret = reverseNode(head.next);
		head.next.next  = head;
		head.next = null;
		return ret;
	}
	//3
	public static Node mergeTwoLists(Node l1, Node l2) {
		if(l1 == null ) return l2;
		if(l2 == null) return l1;
		if(l1.value.compareTo(l2.value) < 0) {
			l1.next = mergeTwoLists(l1.next, l2);
			return l1;
		}else {
			l2.next = mergeTwoLists(l1, l2.next);
			return l2;
		}
	}
	
	class Node {
		String value;
		Node next;
		Node previous;
		Node(String value){
			this.value = value;
		}
		
		public String toString() {
			return value == null ? "null" : value;
		}
	}
	//4
	public static int frequencyOfElm(int elm, int[] arr) {
		if(arr.length ==  1) return arr[0];
		int[] recurArr = new int[arr.length - 1];
		System.arraycopy(arr, 0, recurArr, 0, arr.length - 1);
		int count = 0;
		if(arr[0] == elm) ) {
			count ++;
		}
		return count;
	}
	static void findFrequencyUtil(int arr[], int low,
            int high, int[] freq)
	{
		// If element at index low is equal to element
		// at index high in the array
		if (arr[low] == arr[high]) {
		// increment the frequency of the element
		// by count of elements between high and low
			freq[arr[low]] += high - low + 1;
	}
	else {
		// Find mid and recurse for left and right
		// subarray
		int mid = (low + high) / 2;
		findFrequencyUtil(arr, low, mid, freq);
		findFrequencyUtil(arr, mid + 1, high, freq);
		}
	}
	static void findFrequency(int arr[], int n)
    {
        // create a empty vector to store frequencies
        // and initialize it by 0. Size of vector is
        // maximum value (which is last value in sorted
        // array) plus 1.
        int[] freq = new int[arr[n - 1] + 1];
 
        // Fill the vector with frequency
        findFrequencyUtil(arr, 0, n - 1, freq);
 
        // Print the frequencies
        for (int i = 0; i <= arr[n - 1]; i++)
            if (freq[i] != 0)
                System.out.println("Element " + i + " occurs " + freq[i] + " times");
    }
	
	public static void main(String[] args) {
		//------- 4 ---------
		int[] arr = new int[] {1, 2, 4, 2, 5, 2, 4, 5}
		//------- 1 ---------
		System.out.println(reverseString(new char[] {'B', 'R', 'O', 'W', 'N'}));
		//------- 2 ---------
		var list = new MyStringLinkedList();
		String[] stringData =  {"big", "small", "tall", "short", "round", "square", 
              "enormous", "tiny","gargantuan", "lilliputian", 
              "numberless", "none", "vast", "miniscule"};
	
		//populate
		for(int i = stringData.length - 1; i>=0; i--) {
			list.addFirst(stringData[i]);
		}
		
		//RecursiveProblems rp = new RecursiveProblems(list);	
		//rp.reverseLinkedList(list.header);
		
		//MyStringLinkedList rtnList = new MyStringLinkedList();
		//System.out.println(rtnList.addFirst(null).reverseLinkedList(list.header));
		//System.out.println(rp.list);
		
		
		
	}
}
