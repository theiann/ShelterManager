package view;

import java.util.List;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import model.Pet;

public class MainTable{
	private JTable table;
	private DefaultTableModel model;
	
	
	
	
	/*
	 * This method constructs a new JTable based off whatever list of pets gets initially loaded.
	 */
	
	
	
	public MainTable(JScrollPane scrollPane, List<Pet> pets) {
		
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
		
		for(int i = 0; i < pets.size(); i++) {
			model.addRow(new Object[]{pets.get(i).getName(), pets.get(i).getType(), pets.get(i).getSpecies(), pets.get(i).getAge()});
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
	
	
	/*
	 * This method returns the JTable.
	 */
	public JTable getTable() {
		return table;
	}
	
	
	/*
	 * This method clears the table and reloads the table based off the list of pets provided.
	 * @param list The list of pets being displayed.
	 */
	public void updateTable(List<Pet> list) {
		model.setRowCount(0);
		for(int i = 0; i < list.size(); i++) {
			model.addRow(new Object[]{list.get(i).getName(), list.get(i).getType(), list.get(i).getSpecies(), list.get(i).getAge()});
		}
	}
}
