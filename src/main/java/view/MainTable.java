package view;

import java.awt.Container;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class MainTable{
	private static JTable table;
	
	public class TestClass{
		int age;
		String name;
		String type;
		String species;
		
		public TestClass(int a, String n, String t, String s) {
			this.age = a;
			this.name = n;
			this.type = t;
			this.species = s;
		}
	}
	
	public MainTable(Container contentPlane, Border border, JScrollPane scrollPane) {
		ArrayList<TestClass> list = new ArrayList<TestClass>();
		TestClass object1 = new TestClass(2, "Jeff", "Dog", "Labrador");
		TestClass object2 = new TestClass(4, "Car", "Cat", "Orange");
		list.add(object1);
		list.add(object2);
		list.add(object1);
		list.add(object2);
		list.add(object1);
		list.add(object2);
		list.add(object1);
		list.add(object2);
		list.add(object1);
		list.add(object2);
		list.add(object1);
		list.add(object2);
		list.add(object1);
		list.add(object2);
		list.add(object1);
		list.add(object2);
		list.add(object1);
		list.add(object2);
		
		
		
		DefaultTableModel model = new DefaultTableModel();
		
		
		
		model.addColumn("Name");
		model.addColumn("Type");
		model.addColumn("Species");
		model.addColumn("Age");
		
		
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		
		for(int i = 0; i < list.size(); i++) {
			model.addRow(new Object[]{list.get(i).name, list.get(i).type, list.get(i).species, list.get(i).age});
		}
		table = new JTable(model);
		table.setRowHeight(50);
		table.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(0).setPreferredWidth(300);
		table.getColumnModel().getColumn(1).setPreferredWidth(130);
		table.getColumnModel().getColumn(2).setPreferredWidth(130);
		table.getColumnModel().getColumn(3).setPreferredWidth(40);
		scrollPane.setViewportView(table);
		scrollPane.setBorder(border);
		
	}
}
