package lesson3.exercise_2;

public class Employee {
	private String name;
	private int salary;
	public Employee(String name, int salary) {
		this.name = name;
		this.salary = salary;
	}
	public String getName() {
		return name;
	}
	public int getSalary() {
		return salary;
	}
	//this setter method make mutable
//	public void setSalary(int s) {
//		salary = s;
//	}
	//to be immutable - have to remove setSalary
//	public void setSalary(int s) {
//		salary = s;
//	}
}



