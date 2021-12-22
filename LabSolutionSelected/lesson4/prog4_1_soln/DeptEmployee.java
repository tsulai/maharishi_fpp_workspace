package prog4_1_soln;

import java.util.Date;


public class DeptEmployee {

	private String name;
	private double salary;
	private Date hireDate;
	
	public DeptEmployee(String name, double salary, Date hireDate){
		this.name = name;
		this.salary = salary;
		this.hireDate = hireDate;
	}
	//default implementation
	public double computeSalary() {
		return salary;
	}

	public Date getHireDate() {
		return (Date)hireDate.clone();
	}
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
