package test;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
//		//System.out.println(22<<2);
//		//System.out.println(13 >> 2 << 2 ^ 4);
//		System.out.println(5 << 6 ); //>> 2 ^ 4);
//		System.out.println(320 >> 2);
//		System.out.println(80 ^ 4);
//		System.out.println(5 << 6 >> 2 ^ 4);
		
//		int[] smallPrimes = { 7, 11, 5, 2, 3};
//		System.out.println(Arrays.toString(Arrays.copyOf(smallPrimes, 3)));
//		Arrays.sort(smallPrimes);
//		System.out.println(Arrays.toString(smallPrimes));
		//System.out.println(~5);
//		String t = "Quizz";
//		System.out.println(t.substring(1));
//		System.out.println(t.charAt(0));
		
		test("Quiz");
	}
	public static void test(String str) {
		if(str == null || str.equals("")){
			return;
		}else {
			test(str.substring(1));
			System.out.println(str.charAt(0));
		}
	}
}
