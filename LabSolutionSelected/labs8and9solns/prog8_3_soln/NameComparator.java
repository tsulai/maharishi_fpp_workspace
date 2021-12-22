package prog8_3_soln;

import java.util.Comparator;



public class NameComparator implements Comparator<Employee> {
	final double tolerance = 0.0000001;
	//compareTo in this case is not consistent with equals
	public int compare(Employee e1, Employee e2) {
		if(e1.getName().compareTo(e2.getName()) != 0) {
			return e1.getName().compareTo(e2.getName());
		}
		else {
			if(Math.abs(e1.getSalary() - e2.getSalary()) > tolerance) {
				if(e1.getSalary() < e2.getSalary()) return -1;
				else return 1;
			}
			return e1.getHireDate().compareTo(e2.getHireDate());
		}
	}
	
}
