package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import view.EnrollmentView;

import model.Course;
import model.Model;
import model.ModelObserver;
import model.Student;

public class EnrollmentController implements ModelObserver {

	Model model;
	EnrollmentView enrollmentView;
	StudentController studentController;
	CourseController courseController;

	public EnrollmentController(Model m, EnrollmentView e, StudentController s,
			CourseController cc) {
		studentController = s;
		enrollmentView = e;
		courseController = cc;
		model = m;
		m.addObserver(this);

		enrollmentView.addDropButtonListenter(new DropListener());
		enrollmentView.addAddButtonListener(new AddListener());
		enrollmentView.addSelectButtonListener(new SelectListener());
		updateFromModel();

	}

	@Override
	public void updateFromModel() {
		if(model.getSelectedStudent()==-1)//no student is selected yet
			return;
		Student s = model.getStudent(model.getSelectedStudent());
		List<Course> l = s.getCourses();
		enrollmentView.updateTable(l);
		enrollmentView.setTitle("Enrollments for " + s.getName());
		// enrollmentView.addDropButtonListenter(new DropListener());

	}

	class DropListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			int selectedCourse = enrollmentView.getSelectedCourse();

			if (selectedCourse < 0) {

				JOptionPane
						.showMessageDialog(new JFrame(),
								"Please ensure both student and course to add are selected");
			} else {

				model.dropCourse(enrollmentView.getSelectedCourse(),
						studentController.getSelectedStudent());
			}
		}

	}

	class AddListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int selectedCourse = courseController.getSelectedCourse();

			if (selectedCourse < 0) {

				JOptionPane
						.showMessageDialog(new JFrame(),
								"Please ensure both student and course to add are selected");
			} else {

				model.addCourseToStudent(courseController.getSelectedCourse(),
						studentController.getSelectedStudent());
			}
		}

	}

	private class SelectListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			model.setSelectedStudent(studentController.getSelectedStudent());
		}

	}
}
