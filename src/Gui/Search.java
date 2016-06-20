package Gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Logic.Contacts;

public class Search extends JFrame {
	static private JTextField textField;
	static private JTextField txtField2;

	public Search() {
		JFrame jf = new JFrame();
		JPanel panel = new JPanel();
		panel.setLayout(null);

		textField = new JTextField();
		textField.setBounds(71, 99, 283, 43);
		panel.add(textField);
		textField.setColumns(10);

		JLabel lblEnterSearchname = new JLabel("Enter Search (Name or Contact Number)");
		lblEnterSearchname.setBounds(71, 61, 283, 15);
		panel.add(lblEnterSearchname);

		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(154, 154, 117, 25);
		btnSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String searchTxt = textField.getText();
				search(searchTxt);

			}

		});

		panel.add(btnSearch);

		txtField2 = new JTextField();
		txtField2.setBounds(71, 214, 283, 36);
		panel.add(txtField2);
		txtField2.setColumns(10);
		txtField2.setVisible(false);

		jf.getContentPane().add(panel, BorderLayout.CENTER);
		jf.setSize(400, 400);
		jf.setVisible(true);

	}

	public static void main(String[] args) {
		new Search();
	}

	public static void search(String searchTxt) {
		// System.out.println("Enter the info to search... ");
		// Scanner scanner = new Scanner(System.in);
		// String searchTxt = scanner.next();

		ArrayList<Contacts> contacts = new ArrayList<>();

		Contacts searchObject = new Contacts(searchTxt);
		int index = contacts.indexOf(searchObject);
		if (index != -1) {
			if (contacts.contains(searchObject))
				System.out.println("Found...");
			txtField2.setVisible(true);
			textField.setText("");

		} else {
			System.out.println("Not Found...");
			textField.setText("");
			txtField2.setVisible(true);
			txtField2.setText("No Result!.");

		}
	}

	public static void printResult(String searchTxt) {

		txtField2.setText(searchTxt);

		// TODO Auto-generated method stub

	}

}
