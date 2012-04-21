package view;

import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionListener;

import model.Course;

public class EnrollmentView extends JFrame {
	private EnrollmentPanel panel;

	public EnrollmentView() {

		setTitle("Enrollment Info");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocation(20, 350);
		setSize(20, 200);
		panel = new EnrollmentPanel(this);
		setContentPane(panel);
		pack();
		setVisible(true);

	}

	public void addAddButtonListener(ActionListener a) {
		panel.add.addActionListener(a);
	}

	public void addDropButtonListenter(ActionListener a) {
		panel.drop.addActionListener(a);
	}

	public int getSelectedCourse() {
		return panel.enrollmentTable.getSelectedRow();
	}

	private class EnrollmentPanel extends JPanel {

		JButton add, drop, select;

		MyTable enrollmentTable;

		String[] headers = { "Code", "Title" };

		public EnrollmentPanel(EnrollmentView enrollmentView) {

			add = new JButton("add");
			drop = new JButton("drop");
			select = new JButton("select student");
			enrollmentTable = new MyTable(headers);
			add(add);
			add(drop);
			add(enrollmentTable);
			add(select);
		}

	}

	public void updateTable(List<Course> l) {
		MyTableModel t = new MyTableModel();
		t.setRowCount(l.size());
		panel.enrollmentTable.setTableModel(t);
		for (int i = 0; i < l.size(); i++) {
			Course c = l.get(i);
			panel.enrollmentTable.getModel().setValueAt(c.getCode(), i, 0);
			panel.enrollmentTable.getModel().setValueAt(c.getTitle(), i, 1);
		}

	}

	public void addSelectButtonListener(ActionListener selectListener) {
		panel.select.addActionListener(selectListener);

	}

}
