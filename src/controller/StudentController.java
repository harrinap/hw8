package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import view.StudentView;

import model.Model;
import model.ModelObserver;
import model.Student;

public class StudentController implements ModelObserver {

	private Model model;
	private StudentView studentView;

	public StudentController(Model model, StudentView studentView) {

		this.model = model;
		this.studentView = studentView;

		studentView.addNewStudentListener(new NewStudentListener());
		model.addObserver(this);
		updateFromModel();
		studentView.setFirstRowFocused();
	}

	class TableSelectionHandler implements ListSelectionListener {

		public void valueChanged(ListSelectionEvent e) {

			int rowIndex = studentView.getSelectedStudent();

			model.setSelectedStudent(rowIndex);

			studentView.update(Integer.toString(model.getSelectedStudent()));
		}
	}

	class NewStudentListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			model.addStudent(studentView.getName(), studentView.getGradYear());

			studentView.clearFields();
		}
	}

	public void updateFromModel() {
		List<Student> l = model.getStudents();
		System.out.println(l.size());

		studentView.updateTable(l);
		// studentView.addNewStudentListener(new NewStudentListener());

	}

	public int getSelectedStudent() {
		return studentView.getSelectedStudent();
	}
}
