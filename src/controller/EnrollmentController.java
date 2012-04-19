package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import view.EnrollmentView;

import model.Course;
import model.Model;
import model.ModelObserver;

public class EnrollmentController implements ModelObserver {

	Model model;
	EnrollmentView enrollmentView;
	StudentController studentController;

	public EnrollmentController(Model m, EnrollmentView e, StudentController s) {
		studentController = s;
		enrollmentView = e;
		model = m;
		m.addEnrollmentController(this);

		enrollmentView.addDropButtonListenter(new DropListener());
		enrollmentView.addAddButtonListener(new AddListener());
		enrollmentView.addSelectButtonListener(new SelectListener());
		updateFromModel();

	}

	@Override
	public void updateFromModel() {
		List<Course> l = model.getStudents().get(model.getSelectedStudent())
				.getCourses();
		enrollmentView.updateTable(l);

		enrollmentView.addDropButtonListenter(new DropListener());

	}

	class DropListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			model.dropCourse(enrollmentView.getSelectedCourse(),
					studentController.getSelectedStudent());
		}

	}

	class AddListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			model.addCourse(enrollmentView.getSelectedCourse(),
					studentController.getSelectedStudent());
		}

	}

	private class SelectListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			model.selectStudent(model.getSelectedStudent());

		}

	}
}
