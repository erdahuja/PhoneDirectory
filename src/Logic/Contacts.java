package Logic;

import java.util.ArrayList;
import Gui.Search;

public class Contacts implements Comparable {

	String name;
	ArrayList<String> contactNo = new ArrayList<String>();
	ArrayList<String> address = new ArrayList<String>();
	private String search;

	public Contacts(String name, ArrayList<String> numbers, ArrayList<String> address) {
		super();
		this.name = name;
		this.contactNo = numbers;
		this.address = address;
	}

	public Contacts(String search) {
		this.search = search;
	}

	private boolean isDigit() {
		for (int i = 0; i < this.search.length(); i++) {
			if (Character.isDigit(this.search.charAt(i))) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean equals(Object o) {
		boolean isFound = false;
		Contacts arrayElement = (Contacts) o; // Downcasting

		if (this.search.equals(arrayElement.name)) {
			String searchResult = "Name Found :" + arrayElement.name + arrayElement.getContactNo()
					+ arrayElement.getAddress();
			Search.printResult(searchResult);
			/*
			 * System.out.println(
			 * 
			 * "Name Found :" + arrayElement.name + arrayElement.getContactNo()
			 * + arrayElement.getAddress());
			 */
			return true;

		}
		if (isDigit()) {
			for (int i = 0; i <= contactNo.size(); i++) {
				// System.out.println("Number "+arrayElement.contactNo.get(i));
				if (this.search.equals(arrayElement.contactNo.get(i))) {

					String searchResult = "Name Found :" + arrayElement.name + arrayElement.getContactNo()
							+ arrayElement.getAddress();
					Search.printResult(searchResult);
					/*
					 * System.out.println("Number Found :" + arrayElement.name +
					 * arrayElement.contactNo.get(i) +
					 * arrayElement.address.get(i));
					 */return true;
				}
			}
		}
		return isFound;
	}

	@Override
	public int compareTo(Object o) {
		Contacts c = (Contacts) o;

		return this.name.compareTo(c.getName());

	}

	String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}

	ArrayList<String> getContactNo() {
		return contactNo;
	}

	ArrayList<String> getAddress() {
		return address;
	}

	String getSearch() {
		return search;
	}

	@Override
	public String toString() {
		return this.name + " " + this.contactNo + " " + this.address;
	}
}
