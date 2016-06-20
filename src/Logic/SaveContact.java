package Logic;

import java.util.ArrayList;

public class SaveContact {
	static ArrayList<Contacts> contacts;

	public SaveContact(String name, ArrayList<String> numbers, ArrayList<String> address) {
		contacts = new ArrayList<>();

		contacts.add(new Contacts(name, numbers, address));
		System.out.println(contacts);

	}

}
