package prog4_6.case1;

import java.util.GregorianCalendar;
import java.util.Objects;

public class Person {

	private String name;
	private GregorianCalendar dateOfBirth;
	Person(String name, GregorianCalendar dob) {
		this.name = name;
		dateOfBirth = dob;
	}
	public String getName() {
		return name;
	}
	
	public GregorianCalendar getDateOfBirth() {
		return (GregorianCalendar)dateOfBirth.clone();
	}
	@Override
	public boolean equals(Object ob) {
		if(ob == null) return false;
		if(!(ob instanceof Person)) return false;
		Person p = (Person)ob;
		return name.equals(p.getName()) && dateOfBirth.equals(p.dateOfBirth);
	}
	
	public int hashCode() {
		int seed = 17;
		int result = 31 * seed + name.hashCode();
		result = 31 * result + dateOfBirth.hashCode();
		return result;
	}
	
//	pubic int hashCode() {
//		Objects.hash(name, dateOfBirth);
//	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
