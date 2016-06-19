package Gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class FirstScreen extends JFrame {

	public static void main(String[] args) {
		new FirstScreen();
	}

	public FirstScreen() {

		JFrame fc = new JFrame();
		fc.setSize(500, 350);
		fc.setLocation(400, 200);
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		fc.add(panel);

		JButton btnAdd = new JButton("New Contact");
		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new NewContact();
				fc.setVisible(false);
				fc.dispose();

			}
		});
		btnAdd.setBounds(72, 80, 160, 55);
		panel.add(btnAdd);

		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(240, 80, 160, 55);
		btnSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Logic.SaveContact.search();
				fc.setVisible(false);
				fc.dispose();

			}
		});
		
		
		panel.add(btnSearch);

		JLabel lblPhonebook = new JLabel("PhoneBook");
		lblPhonebook.setFont(new Font("Dialog", Font.BOLD, 16));
		lblPhonebook.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhonebook.setBounds(72, 24, 331, 34);
		panel.add(lblPhonebook);
		fc.setVisible(true);

	}
}