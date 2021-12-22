package lesson7.exercise_2;
//1,1,2,3,5,8,13,21,
public class Fib {
	
	public int fib(int n) {
		int fbn1 = 1, fbn2 = 1, nextFbn = 0;
		for(int i = 3; i<=n ; i++) {
			nextFbn = fbn1+ fbn2;			
			fbn1 = fbn2;
			fbn2 = nextFbn;
			
		}
		
		return nextFbn;
		
	}	
	
	public static void main(String[] args) {
		Fib f = new Fib();
		System.out.println(f.fib(10));
		
	}
}


