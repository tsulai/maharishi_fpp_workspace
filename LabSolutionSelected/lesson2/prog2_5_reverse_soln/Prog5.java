package prog2_5_reverse_soln;

import java.util.Scanner;

public class Prog5 {

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Type in a string: ");
		String input = sc.nextLine();
		
		int len = input.length();
		for(int i = len-1; i >= 0; i--){
			System.out.print(input.charAt(i));
		}
		
		//System.out.println(recurReverse(input));
	}
	
	static String recurReverse(String s) {
		if(s == null || s.length() < 2) {
			return s;
		}
		int mid = s.length()/2;
		String firstHalfReverse = recurReverse(s.substring(0, mid));
		String secondHalfReverse = recurReverse(s.substring(mid, s.length()));
		return secondHalfReverse + firstHalfReverse;
	}

}
