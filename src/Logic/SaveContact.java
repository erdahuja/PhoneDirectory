package Logic;

import java.util.ArrayList;
import java.util.Scanner;

public class SaveContact {
	static ArrayList<Contacts> contacts;

	public SaveContact(String name, ArrayList<String> numbers, ArrayList<String> address) {
		contacts = new ArrayList<>();

		contacts.add(new Contacts(name, numbers, address));
		System.out.println(contacts);

	}

	public static void search() {
		System.out.println("Enter the info to search... ");
		Scanner scanner = new Scanner(System.in);
		String searchTxt = scanner.next();
		Contacts searchObject = new Contacts(searchTxt);

		int index = contacts.indexOf(searchObject);
		if (index != -1) {
			if (contacts.contains(searchObject))
				System.out.println("Found...");
			search();
		} else {
			System.out.println("Not Found...");
			search();
		}
	}

}
