package view;

import javax.swing.JFrame;

public class UserView extends JFrame {
	public UserView() {
		initialize();
	}
	
	private void initialize() {
		setTitle("Shelter Manager");
		setSize(1280, 720);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		
		setVisible(true);
	}
	
}
