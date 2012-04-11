import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionListener;



public class StudentView extends JFrame{
	private StudentPanel panel;
	private StudentController studentController;

	public StudentView(StudentController studentController) {
		
		this.studentController = studentController;
		setTitle("Student Info");
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	    setLocation(20, 50);
	  	setSize(20,20);
	    panel = new StudentPanel();
	    setContentPane(panel);
	    pack();
	    setVisible(true);		
	}
	
	public void addNewStudentListener(ActionListener a){
		panel.newStudent.addActionListener(a);
	}
	
	public int getSelectedStudent(){
		return panel.studentTable.getSelectedStudent();
	}
	
	public void addTableSelectListener(ListSelectionListener l){
		panel.studentTable.setTableSelectListener(l);
	} 
	
	private class StudentPanel extends JPanel{
		
		
		JButton newStudent;
		JTextField name, gradyear;
		MyTable studentTable;
		

		
		
		
		

		public StudentPanel() {		
			
			
			
					
			newStudent = new JButton("Add Student");
			name = new JTextField(10);
			gradyear = new JTextField(10);
			String[] headers = {"ID",
                    "Name",
                    "GradYear"};
			studentTable = new MyTable(headers);
			
			
			
			
			setLayout(new FlowLayout());
			add(studentTable); add(gradyear); 
			add(name); add(newStudent);
		}		
	}

	public void update(String string) {
		panel.name.setText(string);
		
	}
	


}
