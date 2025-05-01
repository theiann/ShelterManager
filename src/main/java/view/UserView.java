package view;

import javax.swing.JFrame;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
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
import javax.swing.JLabel;
import java.awt.Font;

public class UserView extends JFrame {
	private JTable table;
	public UserView() {
		initialize();
	}
	
	
	
	private void initialize() {
		Border orangeline = BorderFactory.createLineBorder(Color.blue, 2);
		
		
		setTitle("Shelter Manager");
		setSize(1200, 720);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		MainTable table = new MainTable(getContentPane(), orangeline);
		
		JLabel lblNewLabel = new JLabel("All Available Pets");
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 35));
		lblNewLabel.setBounds(139, 40, 304, 65);
		getContentPane().add(lblNewLabel);
		
		
		
		
		
		
		
		
		
		
		
		
		setVisible(true);
	}
}


