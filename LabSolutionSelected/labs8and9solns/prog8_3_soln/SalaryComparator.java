package prog8_3_soln;

import java.util.Comparator;

/**
 * This Comparator is not consistent with equals
 */
public class SalaryComparator implements Comparator<Employee> {
	private static final double TOLERANCE = 0.00001;
	//This implementation is acceptable for FPP but not
	//completely safe because we are testing equality of floating point numbers
	public int compare2(Employee e1, Employee e2) {
		double sal1 = e1.getSalary();
		double sal2 = e2.getSalary();
		if(sal1 < sal2) return -1;
		if(sal1 == sal2) return 0;
		return 1;
		
	}
	
	//This implementation is the right way to do it
	public int compare(Employee e1, Employee e2) {
		double sal1 = e1.getSalary();
		double sal2 = e2.getSalary();
		if(Math.abs(sal1 - sal2) < TOLERANCE) return 0;
		else if(sal1 < sal2) return -1;
		else return 1;
		
	}
	
}