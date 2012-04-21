package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import model.Student;

public class StudentView extends JFrame {
	private StudentPanel panel;

	public StudentView() {
		setTitle("Student Info");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocation(20, 50);
		setSize(20, 80);
		panel = new StudentPanel();
		setContentPane(panel);
		pack();
		setVisible(true);
	}

	public void addNewStudentListener(ActionListener a) {
		panel.newStudent.addActionListener(a);
	}

	public int getSelectedStudent() {
		return panel.studentTable.getSelectedRow();
	}

	public String getName() {
		return panel.name.getText();
	}

	public int getGradYear() {
		String s = panel.gradyear.getText();
		if (s.isEmpty())
			return 0;
		return Integer.parseInt(panel.gradyear.getText());
	}

	public void setProperRowFocused(int i) {
		// if (panel.studentTable.getRowCount() > 0)
		panel.studentTable.setRowSelection(i, i);
	}

	private class StudentPanel extends JPanel {

		JButton newStudent;
		JTextField name, gradyear;
		MyTable studentTable;

		public StudentPanel() {

			newStudent = new JButton("Add Student");
			name = new JTextField(10);
			gradyear = new JTextField(10);
			String[] headers = { "ID", "Name", "GradYear" };
			studentTable = new MyTable(headers);

			setLayout(new FlowLayout());
			add(studentTable);
			add(name);
			add(gradyear);

			add(newStudent);

		}
	}

	public void update(String string) {
		panel.name.setText(string);

	}

	public void updateTable(List<Student> l) {
		MyTableModel t = new MyTableModel();
		t.setRowCount(l.size());
		panel.studentTable.setTableModel(t);
		for (int i = 0; i < l.size(); i++) {
			Student s = l.get(i);
			String val = Integer.toString(s.getId());
			panel.studentTable.getModel().setValueAt(val, i, 0);

			val = s.getName();
			panel.studentTable.getModel().setValueAt(val, i, 1);
			val = Integer.toString(s.getGradyear());
			panel.studentTable.getModel().setValueAt(val, i, 2);

		}
	}

	public void clearFields() {
		panel.name.setText("");
		panel.gradyear.setText("");
	}

}
