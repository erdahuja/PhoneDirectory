package Gui;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NewContact extends JFrame {

	public static void main(String[] args) {
		new NewContact();
	}

	private JTextField nameField;
	private ArrayList<JTextField> mblField = new ArrayList<JTextField>();
	private ArrayList<JTextField> addField = new ArrayList<JTextField>();
	private int mblHeight = 80;
	private int addHeight = 180;
	private int btnAddressH = 190;
	private int count1 = 0;
	private int i = 1;
	private int j = 1;
	private int count2 = 0;

	NewContact() {
		JFrame fc2 = new JFrame();
		fc2.setSize(500, 350);
		fc2.setLocation(400, 200);
		JPanel panel = new JPanel();

		panel.setLayout(null);

		JLabel lblName = new JLabel("Name");
		lblName.setBounds(84, 65, 80, 25);
		panel.add(lblName);

		nameField = new JTextField("Name");
		nameField.setBounds(276, 63, 114, 19);
		panel.add(nameField);
		nameField.setColumns(10);

		JButton btnAddMobile = new JButton("");
		btnAddMobile.setBounds(84, 107, 20, 20);
		panel.add(btnAddMobile);
		try {
			Image img = ImageIO.read(getClass().getResource("add-icon.png"));
			btnAddMobile.setIcon(new ImageIcon(img));

			JLabel lblMobile = new JLabel("Mobile");
			lblMobile.setBounds(110, 107, 70, 15);
			panel.add(lblMobile);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		btnAddMobile.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (count1 < 5) {
					mblHeight = mblHeight + 20;
					btnAddressH = btnAddressH + 20;
					mblField.add(new JTextField("Mobile " + i++));
					mblField.get(count1).setBounds(276, mblHeight, 114, 20);
					panel.add(mblField.get(count1));
					mblField.get(count1).setColumns(10);
					panel.add(mblField.get(count1));
					mblField.get(count1).setVisible(true);
					panel.revalidate();
					panel.repaint();
					count1++;

				} else {
					i = 1;
					count1 = 0;
				}
			}

		});

		JButton btnAddAddress = new JButton("");
		btnAddAddress.setBounds(84, btnAddressH, 20, 20);
		panel.add(btnAddAddress);
		try {
			Image img = ImageIO.read(getClass().getResource("add-icon.png"));
			btnAddAddress.setIcon(new ImageIcon(img));

			JLabel lblAddress = new JLabel("Address");
			lblAddress.setBounds(110, btnAddressH, 70, 15);
			panel.add(lblAddress);
			panel.revalidate();
			panel.repaint();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		btnAddAddress.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (count2 < 5) {
					// System.out.println("nnn");
					addField.add(new JTextField("Address " + j++));
					addHeight = addHeight + 20;
					addField.get(count2).setBounds(276, addHeight, 114, 20);
					panel.add(addField.get(count2));
					addField.get(count2).setColumns(10);
					panel.add(addField.get(count2));
					addField.get(count2).setVisible(true);
					panel.revalidate();
					panel.repaint();
					count2++;

				} else {
					j = 1;
					count2 = 0;
				}

			}

		});

		panel.revalidate();
		fc2.getContentPane().add(panel);

		JButton btnSave = new JButton("Save");
		btnSave.setBounds(185, 26, 117, 25);
		btnSave.requestFocus(false);
		panel.add(btnSave);

		btnSave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				String name = nameField.getText();
				int n = mblField.size();
				int m = addField.size();
				ArrayList<String> as = new ArrayList<>();
				ArrayList<String> ps = new ArrayList<>();
				for (int i = 0; i < n; i++) {
					as.add(mblField.get(i).getText());

				}
				for (int i = 0; i < m; i++) {
					ps.add(addField.get(i).getText());

				}

				new Logic.SaveContact(name, as, ps);
				nameField.setText("");
				for (int i = 0; i < count1; i++) {
					mblField.get(i).setText("");

				}
				for (int i = 0; i < count2; i++) {
					addField.get(i).setText("");

				}
				btnSave.requestFocus(false);

			}

		});

		fc2.setTitle("Add New Contact");
		fc2.revalidate();

		fc2.setVisible(true);

	}
}
