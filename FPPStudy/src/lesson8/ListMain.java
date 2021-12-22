package lesson8;

import java.util.ArrayList;
import java.util.List;

public class ListMain {

	private List<Address> listOfAddresses;
	private StringBuilder output = new StringBuilder();
	
	
	private void loadDate() {
		listOfAddresses = new ArrayList<>();
		listOfAddresses.add(new Address("Jim", "101 Adams", "Fairfield", "IA", "52556"));
		listOfAddresses.add(new Address("Tom", "30 W. Burlington", "Fairfield", "IA", "52556"));
		listOfAddresses.add(new Address("Hal", "14 E. Court", "Fairfield", "IA", "52556"));
		listOfAddresses.add(new Address("Sally", "410 W. Jefferson", "Fairfield", "IA", "52556"));
		listOfAddresses.add(new Address("MUM", "1000 N. 4th St", "Fairfield", "IA", "52556"));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
