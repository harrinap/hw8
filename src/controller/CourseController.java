package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.CourseView;
import model.Model;
import model.ModelObserver;

public class CourseController implements ModelObserver {
	Model model;
	CourseView courseView;

	public CourseController(Model model, CourseView courseView) {
		this.model = model;
		this.courseView = courseView;
		courseView.addNewCourseListener(new NewCourseButtonListener());
		model.addObserver(this);
		updateFromModel();
		courseView.setFirstRowFocused();
	}

	public void updateFromModel() {
		if(model.getCourses() != null){
		courseView.updateTable(model.getCourses());
		}

	}

	private class NewCourseButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			String code = courseView.codeToAdd();
			String title = courseView.titleToAdd();
			if (!code.isEmpty() && !title.isEmpty()) {
				model.addCourse(code, title);
				courseView.clearFields();
			}
		}

	}

	public int getSelectedCourse() {
		return courseView.getSelectedCourse();
	}

}
