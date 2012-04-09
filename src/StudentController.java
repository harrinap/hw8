import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class StudentController {
	
	private Model m;
	private StudentView studentView;

	public StudentController(Model model) {
		this.m = m;
		studentView = new StudentView(this);
		studentView.update("shit");
		studentView.addNewStudentListener(new NewStudentListener());
		studentView.addTableSelectListener(new TableSelectionHandler());
	}
	
	class NewStudentListener implements ActionListener{

		
		public void actionPerformed(ActionEvent e) {
			System.out.println("new student button");
			
		}
		
	}
	
	class TableSelectionHandler implements ListSelectionListener {
		
		
		
		public void valueChanged(ListSelectionEvent e) {
		//	System.out.println("testing table handler");
			
			ListSelectionModel lsm = (ListSelectionModel)e.getSource();

	        int rowIndex = e.getLastIndex();
	        System.out.println(rowIndex);
	        studentView.update(rowIndex);
		}
		
	 

	}


}
