package Logic;
import java.util.Comparator;

public class SortByName implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		
		Contacts contact1=(Contacts)o1;
		Contacts contact2=(Contacts)o2;
	
		// TODO Auto-generated method stub
		return contact1.getName().compareTo(contact2.getName());
	}

}
