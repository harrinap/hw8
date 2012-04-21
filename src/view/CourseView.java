package view;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Course;
import model.Student;

public class CourseView extends JFrame {

	private CoursePanel panel;

	public CourseView() {

		setTitle("Course Info");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocation(20, 200);
		setSize(20, 20);
		panel = new CoursePanel(this);
		setContentPane(panel);
		pack();
		setVisible(true);
	}

	public void updateTable(List<Course> l) {
		MyTableModel t = new MyTableModel();
		t.setRowCount(l.size());
		panel.courseTable.setTableModel(t);
		for (int i = 0; i < l.size(); i++) {
			Course c = l.get(i);
			String val = c.getCode();
			panel.courseTable.getModel().setValueAt(val, i, 0);

			val = c.getTitle();
			panel.courseTable.getModel().setValueAt(val, i, 1);

		}
	}

	private class CoursePanel extends JPanel {
		JButton newCourse;
		JTextField code, title;
		MyTable courseTable;
		String[] headers = { "Code", "Title" };

		public CoursePanel(CourseView courseView) {
			setLayout(new FlowLayout());
			newCourse = new JButton("New Course");
			code = new JTextField(10);
			title = new JTextField(10);
			courseTable = new MyTable(headers);
			add(courseTable);
			add(code);
			add(title);
			add(newCourse);

		}

		public int getSelectedRow() {
			return courseTable.getSelectedRow();
		}

	}

	public void addNewCourseListener(ActionListener newCourseButtonListener) {
		panel.newCourse.addActionListener(newCourseButtonListener);

	}

	public String titleToAdd() {
		return panel.title.getText();
	}

	public String codeToAdd() {
		return panel.code.getText();
	}

	public void setFirstRowFocused() {
		if (panel.courseTable.getRowCount() > 0)
			panel.courseTable.setRowSelection(0, 0);

	}

	public void clearFields() {
		panel.code.setText("");
		panel.title.setText("");
	}

	public int getSelectedCourse() {
		return panel.getSelectedRow();
	}
}
