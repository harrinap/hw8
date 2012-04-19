package view;

import java.awt.Dimension;
import java.util.Arrays;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class MyTable extends JPanel {

	private JTable table;
	private Vector<String> headers;

	public MyTable(String[] headers) {
		this.headers = new Vector<String>(Arrays.asList(headers));

		/*
		 * String[][] data = {{"un", "uno", "uno" }, {"deux", "dos", "due" },
		 * {"trois", "tres", "tre" }, { "quatre", "cuatro", "quattro"}, {
		 * "cinq", "cinco", "cinque" }, { "six", "seis", "sei" }, { "sept",
		 * "siete", "sette" } };
		 */

		table = new JTable();

		table.setPreferredScrollableViewportSize(new Dimension(500, 70));
		table.setFillsViewportHeight(true);

		JScrollPane tablePane = new JScrollPane(table);

		add(tablePane);

	}

	public void setRowSelection(int i, int j) {
		table.setRowSelectionInterval(i, j);
	}

	public TableModel getModel() {
		return table.getModel();
	}

	public void setTableModel(DefaultTableModel t) {
		t.setColumnIdentifiers(headers);

		this.table.setModel(t);

	}

	public int getRowCount() {
		return table.getSelectedRow();
	}

	public int getSelectedRow() {
		return table.getSelectedRow();
	}

}
