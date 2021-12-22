package lesson1.exercise_2;

import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import lesson1.exercise_1.MyClass;

public class TestMyClass {
	@Test
	public void testProduct() {
		int a = - 10; 
		//System.out.println(a +" = " + Integer.toBinaryString(a));
		//System.out.println(a>>1 );
		//System.out.println(Integer.toBinaryString(2<<2));
		//System.out.println(3 * 5 / 9 % 2);
		//System.out.println(3 & 5);
		//System.out.println(Integer.toBinaryString(4 ^ 1));
		//System.out.println(2 << 2);
		//System.out.println(13 >> 8);
		//System.out.println(0 ^ 4);
		//System.out.println(13 >> 2 );
		//System.out.println(3 << 2);
		//System.out.println(12 ^ 4);
		//System.out.println(13 >> 2 << 2 ^ 4);
		
		System.out.println(32 | 16/3 >> 2 & 5 );
		
		//int a = (b = 5);
		
		//System.out.println(a);


		int[] str = {2, 5, -3, 11, 1};
		int result = MyClass.product(str);
		int expected = -330;
		assertTrue(expected == result);
		//memory address only include
	}
	
	@Test
	public void testConcatenate() {
		String[] str2 = {"A", "L", "M", "O", "S", "T", " ", "D", "O", "N", "E"};
		String result = MyClass.concatenate(str2);
		String expected = "ALMOST DONE";
		assertEquals(expected, result);//value compare - Primitive type
		//assertTrue - compare only memory address only include
	}
}
