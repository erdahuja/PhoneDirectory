package Logic;

import java.util.ArrayList;
import javax.swing.*;
import java.util.Collections;

class Contacts implements Comparable {

	public Contacts(String name, String contactNo, String address) {
		super();
		this.name = name;
		this.contactNo = contactNo;
		this.address = address;
	}

	private String name;
	private String contactNo;
	private String address;
	private String search;

	Contacts(String search) {
		this.search = search;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	private boolean isDigit() {
		for (int i = 0; i < this.search.length(); i++) {
			if (!Character.isDigit(this.search.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean equals(Object o) {
		boolean isFound = false;
		Contacts arrayElement = (Contacts) o; // Downcasting

		if (this.search.equals(arrayElement.name)) {
			return true;
		}
		if (isDigit()) {
			if (this.search == arrayElement.contactNo) {
				// if(this.search.equals(arrayElement.id)){
				return true;
			}
		}
		return isFound;
	}

	@Override
	public int compareTo(Object o) {
		Contacts c = (Contacts) o;

		return this.name.compareTo(c.getName());

	}

	@Override
	public String toString() {
		return this.name + " " + this.contactNo + " " + this.address;
	}
}

public class CRUDDemo extends JFrame {
	public CRUDDemo() {

	}

	public static void main(String[] args) {

		ArrayList<Contacts> contacts = new ArrayList<>();
		contacts.add(new Contacts("deepak", "8010099223", "Rohini24"));
		contacts.add(new Contacts("rishab", "8010099224", "Rohini10"));
		contacts.add(new Contacts("ojaswi", "8010099225", "Rani bagh"));
		System.out.println(contacts);
		/*
		 * System.out.println("Enter the info to search... "); Scanner scanner =
		 * new Scanner(System.in); String searchTxt = scanner.next();
		 * 
		 * Contacts searchObject = new Contacts(searchTxt);
		 * 
		 * int index = contacts.indexOf(searchObject); if (index != -1) {
		 * System.out.println("Found..."); } else { System.out.println(
		 * "Not Found..."); }
		 */

		Collections.sort(contacts, new SortByName());
		System.out.println(contacts);

	}

}