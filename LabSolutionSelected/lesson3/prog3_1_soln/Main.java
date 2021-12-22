package prog3_1_soln;

public class Main {
	public static void main(String[] args) {
		Employee employee = new Employee("Joe", "Joe", 50000, 10, 5, 5);
		Account checking = new Account(employee,
									   AccountType.CHECKING,
									   300);
		Account savings = new Account(employee,
				   AccountType.SAVINGS,
				   300);
		Account retirement = new Account(employee,
				   AccountType.RETIREMENT,
				   300);
		System.out.println(checking);
		System.out.println(savings);
		System.out.println(retirement);
	}
}
