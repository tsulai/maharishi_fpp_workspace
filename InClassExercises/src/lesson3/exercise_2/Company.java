package lesson3.exercise_2;

public class Company {
	private String address;
	private Employee president;
	private int numEmployees;
	public Company(String addr, Employee pres, int num) {
		address = addr;
		president = pres;
		numEmployees = num;
	}
	public String getAddress() {
		return address;
	}
	//this is mutable because president is Employee obj and Employee has setter method
//	public Employee getPresident() {
//		return president;
//	}
	//to fix the mutable 
	public Employee getPresident() {
		Employee temp = new Employee(president.getName(), president.getSalary());
		return temp;
	}
	public int getNumEmployees() {
		return numEmployees;
	}
}


