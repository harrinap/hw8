import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


public class EnrollmentController implements ModelObserver {
	
	Model model;
	EnrollmentView enrollmentView;

	public EnrollmentController(Model m, EnrollmentView e) {
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
		List<Course> l = model.getStudents().get(model.getSelectedStudent()).getCourses();
		enrollmentView.updateTable(l);
		
		enrollmentView.addDropButtonListenter(new DropListener());
		
	}
	
	
	class DropListener implements ActionListener{		
		public void actionPerformed(ActionEvent e) {			
			model.dropCourse();	
		}
		
	}
	
	class AddListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {			
			model.addCourse();	
		}
		
	}
	
	private class SelectListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			model.selectStudent(model.getSelectedStudent());

		}

	}
}
