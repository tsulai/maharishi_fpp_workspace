package prog2_3_round_soln;

public class Prog3 {

	
	public static void main(String[] args) {
		float sum = 1.27f + 3.881f + 9.6f;
		int truncate = (int)sum;
		int round = (int)Math.round(sum);
		System.out.println("Trunacated: " + truncate);
		System.out.println("Rounded: " + round);
	}

}
