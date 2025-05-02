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

public class UserView extends JFrame {
	private MainTable table;
	private JButton helpButton;
	private JComboBox sortByBox;
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
		scrollPane.setBounds(8, 76, 400, 400);
		getContentPane().add(scrollPane);
		
		table = new MainTable(scrollPane, shelter);
		
		JLabel lblNewLabel = new JLabel("All Pets");
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 35));
		lblNewLabel.setBounds(10, 6, 150, 65);
		getContentPane().add(lblNewLabel);
		
		JLabel label = new JLabel("Sort by:");
		label.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		label.setBounds(198, 26, 83, 38);
		getContentPane().add(label);
		
		sortByBox = new JComboBox();
		sortByBox.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 18));
		sortByBox.setModel(new DefaultComboBoxModel(new String[] {"Name", "Species", "Age"}));
		sortByBox.setBounds(268, 29, 141, 35);
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
		
		
		//Image image = ImageIO.read("src/main/resources/question mark.png")
		
		

		setVisible(true);
	}
	
	
	public void addHelpButtonListener(ActionListener listener) {
		helpButton.addActionListener(listener);
	}
	
	public void addComboBoxListener(ItemListener listener) {
		sortByBox.addItemListener(listener);
	}
	
	public MainTable getMainTable() {
		return table;
	}
	
	public Shelter<Pet> getShelter(){
		return shelter;
	}
}



