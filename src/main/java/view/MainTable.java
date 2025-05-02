package view;

import java.awt.Container;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import model.Pet;
import model.Shelter;

public class MainTable{
	private JTable table;
	private DefaultTableModel model;
	
	public MainTable(JScrollPane scrollPane, Shelter<Pet> shelter) {
		
		List<Pet> list = shelter.getAllPets();
		model = new DefaultTableModel() {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int a, int b) {
				return false;
			}
		};
		
		
		
		model.addColumn("Name");
		model.addColumn("Type");
		model.addColumn("Species");
		model.addColumn("Age");
		
		
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		
		for(int i = 0; i < list.size(); i++) {
			model.addRow(new Object[]{list.get(i).getName(), list.get(i).getType(), list.get(i).getSpecies(), list.get(i).getAge()});
		}
		table = new JTable(model);
		table.setRowHeight(50);
		table.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(0).setPreferredWidth(80);
		table.getColumnModel().getColumn(1).setPreferredWidth(80);
		table.getColumnModel().getColumn(2).setPreferredWidth(200);
		table.getColumnModel().getColumn(3).setPreferredWidth(40);
		
		scrollPane.setViewportView(table);
		
	}
	
	public JTable getTable() {
		return table;
	}
	
	
	public void updateTable(List<Pet> list) {
		model.setRowCount(0);
		for(int i = 0; i < list.size(); i++) {
			model.addRow(new Object[]{list.get(i).getName(), list.get(i).getType(), list.get(i).getSpecies(), list.get(i).getAge()});
		}
	}
}
