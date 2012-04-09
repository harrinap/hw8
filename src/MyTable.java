import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionListener;


public class MyTable extends JPanel {
	
	
	private String[] headers;
	ListSelectionModel listSelectionModel;
	JTable table;
	
	
	public MyTable(String[] headers){
		this.headers = headers;
	
	
		 String[][] data = {{"un",     "uno",     "uno"     },
                 {"deux",   "dos",     "due"     },
                 {"trois",  "tres",    "tre"     },
                 { "quatre", "cuatro",  "quattro"},
                 { "cinq",   "cinco",   "cinque" },
                 { "six",    "seis",    "sei"    },
                 { "sept",   "siete",   "sette"  } };
	
		table = new JTable(data, headers);
	
		table.setPreferredScrollableViewportSize(new Dimension(500, 70));
		table.setFillsViewportHeight(true);
		
	
		
		JScrollPane tablePane = new JScrollPane(table);
		add(tablePane);
		
	}


	public void setTableSelectListener(ListSelectionListener l) {
		listSelectionModel = table.getSelectionModel();
		listSelectionModel.addListSelectionListener(new TableSelectionHandler());
		table.setSelectionModel(listSelectionModel);
		
	}
	

}
