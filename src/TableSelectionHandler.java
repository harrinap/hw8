import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class TableSelectionHandler implements ListSelectionListener {

	@Override
	public void valueChanged(ListSelectionEvent e) {
	//	System.out.println("testing table handler");
		
		ListSelectionModel lsm = (ListSelectionModel)e.getSource();

        int rowIndex = e.getLastIndex();
        System.out.println(rowIndex);

	}

}
