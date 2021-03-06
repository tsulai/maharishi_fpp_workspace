package Equals_HashCodeYT;

import java.util.Date;
import java.util.GregorianCalendar;

public class Employee {

	private String name;
	private int age;
	private Date hireDate;
	private int salary;
	
	public Employee(String name, int age, int salary, int year, int month, int day){
		this.name = name;
		this.age = age;
		this.salary = salary;
		GregorianCalendar cal = 
			new GregorianCalendar(1989,12,11);
		hireDate= cal.getTime();
	}
	
	public Employee(String name, int age, int salary){
		this.name = name;
		this.age = age;
		this.salary = salary;		
	}

	public Date getHireDate() {
		return (Date)hireDate.clone();
	}
	public String getName() {
		return name;
	}
	public int getSalary() {
		return salary;
	}
	public final boolean equals(Object o){
		if(o==null) return false;
		if(o.getClass() != this.getClass()) {
			return false;
		}
		Employee e = (Employee)o;
		return (e.getName().equals(name)&& 				
				e.getSalary()== salary);
	}
	
	public String toString() {
		String newline = System.getProperty("line.separator");
		return newline+"EMPLOYEE "+name+newline+
				"Salary: "+salary+newline;
	}

	

}
