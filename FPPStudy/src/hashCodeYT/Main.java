package hashCodeYT;


/*https://www.youtube.com/watch?v=JqOCsnu-Ios*/
public class Main {

	public static void main(String[] args) {
		Employee e1 = new Employee("Sachin", 45, 250000);
		Employee e2 = new Employee("Hello", 45, 250000);
		Employee e3 = new Employee("Smith", 45, 250000);
		
		//System.out.println(e1.equals(e2));		
		//System.out.println(e1.equals(e1));
		
		//default object.hashCode
		System.out.println(e1.hashCode());
		System.out.println(e2.hashCode());
		System.out.println(e3.hashCode());
		
		//
		String str1= "FB";
		String str2 = "Ea";
		System.out.println(str1.hashCode() + " " + str2.hashCode());

	}

}
