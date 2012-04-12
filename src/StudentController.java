import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


public class StudentController implements ModelObserver {
	
	private Model m;
	private StudentView studentView;

	public StudentController(Model model) {
		this.m = model;
		studentView = new StudentView(this);
		
		studentView.addNewStudentListener(new NewStudentListener());
		studentView.addTableSelectListener(new TableSelectionHandler());
		m.addObserver(this);
	}

	
	class TableSelectionHandler implements ListSelectionListener {

		
		public void valueChanged(ListSelectionEvent e) {		
			
			int rowIndex = studentView.getSelectedStudent();
			m.setSelectedStudent(rowIndex);
			//studentView.update(Integer.toString(m.getSelectedStudent()));	        
		}
	}
	
	class NewStudentListener implements ActionListener{

		
		public void actionPerformed(ActionEvent e) {
			
			studentView.update("update called from student button");
			
		}
		
	}
	
	
	public void updateFromModel() {
		TableModel t = m.getStudentTableModel();
		studentView.setTableModel(t);
	}
}
	




