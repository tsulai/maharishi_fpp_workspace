package practise_final;

import java.util.ArrayList;
import java.util.List;

public class FinalRecursive {

	public static void main(String[] args) {
		
		List<Integer> myList = new ArrayList<Integer>();
		myList.add(8);
		myList.add(4);
		myList.add(4);
		myList.add(5);
		myList.add(1);
		myList.add(3);
		myList.add(7);		
		myList.add(9);
		myList.add(11);		
		myList.add(99);
		
		System.out.println(findMin(myList));
		System.out.println(findMax(myList));
		System.out.println(power(2, 4));
		System.out.println(reverseString("Hello"));
		
		int[] testArr = {9,8,7,6,5,4,3,2,1};
		printReverseArray(testArr);

	}
	//findMin of list
		public static int findMin(List<Integer> list) {
			if(list.size() == 1) {
				return list.get(0);//must have ended condition which return value
			}
			int minVal = list.get(0);
			list.remove(0);
			
			return Math.min(minVal, findMin(list));
		}
		//find Max of list
		public static int findMax(List<Integer> list) {
			if(list.size() == 1) {
				return list.get(0);			
			}
			int maxVal = list.get(0);
			list.remove(0);
			
			return Math.max(maxVal, findMax(list));
		}
		//exponential 
		public static double power(double x, int n) {
			if(n == 0) {
				return 1;
			}
			return x * power(x, n-1);		
		}
		//Reverse String
		public static String reverseString(String str) {
			 int len = str.length();
			 if(len == 1) {
				 return str;
			 }
			 String s = str.substring(len -1);
			 return s + reverseString(str.substring(0,len -1));
		 }
		
		public static void printReverseArray(int[] arr) {
			int len = arr.length;
			if(len == 1) {
				System.out.print(arr[0] );
			}else {
				int[] recurArr = new int[len-1]; 
				System.arraycopy(arr, 0, recurArr, 0, len -1);
				System.out.print(arr[len-1]+ ",");
				printReverseArray(recurArr);
			}		
		}
		
		private void printHelper(int[] arr) {
			
		}
}
