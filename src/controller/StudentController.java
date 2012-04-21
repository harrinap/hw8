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

	}

	class NewStudentListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String name = studentView.getName();
			Integer year = studentView.getGradYear();
			if (!name.isEmpty() && year > 2000) {
				model.addStudent(name, year);
				studentView.clearFields();
			}
		}
	}

	public void updateFromModel() {
		if(model.getSelectedStudent() == -1)//no student is selected yet
			return;
		List<Student> l = model.getStudents();
		System.out.println(l.size());

		studentView.updateTable(l);
		// studentView.addNewStudentListener(new NewStudentListener());
		studentView.setProperRowFocused(model.getSelectedStudent());

	}

	public int getSelectedStudent() {
		return studentView.getSelectedStudent();
	}
}
