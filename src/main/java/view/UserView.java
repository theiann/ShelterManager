package view;

import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

import model.Pet;
import model.Shelter;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Choice;
import java.awt.Label;
import java.awt.Toolkit;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import javax.swing.JPanel;
import java.awt.SystemColor;

public class UserView extends JFrame {
	private MainTable table;
	private JButton helpButton;
	private JComboBox<String> sortByBox;
	private JButton adoptButton;
	private JButton viewButton;
	private JButton removeButton;
	private JButton addButton;
	Shelter<Pet> shelter;
	
	
	public UserView(Shelter<Pet> s) {
		this.shelter = s;
		initialize(s);
	}
	
	
	
	private void initialize(Shelter<Pet> shelter) {
		
		
		setTitle("Shelter Manager");
		setSize(720, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(8, 76, 400, 376);
		getContentPane().add(scrollPane);
		
		table = new MainTable(scrollPane, shelter);
		
		JLabel label = new JLabel("Sort by:");
		label.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		label.setBounds(198, 27, 83, 38);
		getContentPane().add(label);
		
		sortByBox = new JComboBox<String>();
		sortByBox.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 18));
		sortByBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Name", "Species", "Age"}));
		sortByBox.setBounds(267, 30, 141, 35);
		getContentPane().add(sortByBox);
		
		
		
		
        ImageIcon icon;;
		
		
		icon = new ImageIcon("src/main/resources/question mark.png");
		setIconImage(icon.getImage());
		
		Image img = icon.getImage() ;  
		Image newimg = img.getScaledInstance(30, 30,  java.awt.Image.SCALE_SMOOTH ) ;  
		icon = new ImageIcon(newimg);
		
		helpButton = new JButton(icon);
		helpButton.setBounds(668, 6, 30, 30);
		getContentPane().add(helpButton);
		
		JLabel lblNewLabel = new JLabel("All Pets");
		lblNewLabel.setBounds(10, 15, 141, 50);
		getContentPane().add(lblNewLabel);
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 35));
		
		JLabel lblNewLabel_1 = new JLabel("Edit");
		lblNewLabel_1.setBackground(SystemColor.window);
		lblNewLabel_1.setForeground(SystemColor.infoText);
		lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(538, 72, 41, 35);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Create");
		lblNewLabel_1_1.setForeground(SystemColor.infoText);
		lblNewLabel_1_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
		lblNewLabel_1_1.setBackground(SystemColor.window);
		lblNewLabel_1_1.setBounds(526, 262, 70, 38);
		getContentPane().add(lblNewLabel_1_1);
		
		JButton SaveButton = new JButton("Save");
		SaveButton.setToolTipText("Click to save the list as a .json file");
		SaveButton.setFont(new Font("Comic Sans MS", Font.BOLD, 21));
		SaveButton.setBounds(417, 392, 281, 60);
		getContentPane().add(SaveButton);
		
		addButton = new JButton("Add Pet");
		addButton.setToolTipText("Click to add a new pet to the shelter.");
		addButton.setFont(new Font("Comic Sans MS", Font.BOLD, 28));
		addButton.setBounds(417, 292, 281, 100);
		getContentPane().add(addButton);
		
		adoptButton = new JButton("Adopt");
		adoptButton.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		adoptButton.setToolTipText("Click to adopt the selected pet.");
		adoptButton.setBounds(418, 101, 281, 50);
		getContentPane().add(adoptButton);
		
		viewButton = new JButton("View Details");
		viewButton.setToolTipText("Click to view details of the selected pet.");
		viewButton.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		viewButton.setBounds(418, 151, 281, 50);
		getContentPane().add(viewButton);
		
		removeButton = new JButton("Remove");
		removeButton.setToolTipText("Click to remove the selected pet from the shelter.");
		removeButton.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		removeButton.setBounds(418, 201, 281, 50);
		getContentPane().add(removeButton);
		
		
		//Image image = ImageIO.read("src/main/resources/question mark.png")
		
		

		setVisible(true);
	}
	
	
	public void addHelpButtonListener(ActionListener listener) {
		helpButton.addActionListener(listener);
	}
	
	public void addComboBoxListener(ItemListener listener) {
		sortByBox.addItemListener(listener);
	}
	
	public void addViewButtonListener(ActionListener listener) {
		viewButton.addActionListener(listener);
	}
	
	public void addAdoptButtonListener(ActionListener listener) {
		adoptButton.addActionListener(listener);
	}
	
	public void addRemoveButtonListener(ActionListener listener) {
		removeButton.addActionListener(listener);
	}
	public void addAddButtonListener(ActionListener listener) {
		addButton.addActionListener(listener);
	}
	
	public MainTable getMainTable() {
		return table;
	}
	
	public Shelter<Pet> getShelter(){
		return shelter;
	}
}



