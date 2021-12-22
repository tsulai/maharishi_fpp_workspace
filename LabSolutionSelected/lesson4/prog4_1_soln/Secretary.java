package prog4_1_soln;

import java.util.Date;

public class Secretary extends DeptEmployee {
	private double overtimeHours;
	public Secretary(String name, double salary, Date hireDate){
		super(name,salary,hireDate);
	}
	public double getOvertimeHours() {
		return overtimeHours;
	}
	public void setOvertimeHours(double overtimeHours) {
		this.overtimeHours = overtimeHours;
	}
	//overrides superclass method
	public double computeSalary() {
		return super.computeSalary() + 12*overtimeHours;
	}
}
