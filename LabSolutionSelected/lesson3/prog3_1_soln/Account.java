package prog3_1_soln;

import java.util.Calendar;
import java.util.GregorianCalendar;

class Account {
	private final static double DEFAULT_BALANCE = 0.0;
	private double balance;
	private AccountType acctType;
	private Employee employee;
	
	Account(Employee emp, AccountType acctType, double balance){
		employee = emp;
		this.acctType =acctType;
		this.balance = balance;
	}
	Account(Employee emp, AccountType acctType){
		this(emp, acctType, DEFAULT_BALANCE);		
	}
	public double getBalance() {
		return balance;
	}
	
	public Employee getEmployee() {
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(employee.getHireDay());
		return new Employee(employee.getName(), employee.getNickName(), employee.getSalary(),
				cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH));
	}
	
	public AccountType getAcctType() {
		return acctType;
	}
	public String toString() {
		return "type = " + acctType + ", balance = " + balance;
	}

	public void makeDeposit(double deposit) {
		balance += deposit;
	}
	public boolean makeWithdrawal(double amount) {
		if(amount <= balance) {
			balance -= amount;
			return true;
		}
		return false;
	}
}

