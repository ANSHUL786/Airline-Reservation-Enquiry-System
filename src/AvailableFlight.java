import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;

public class AvailableFlight extends JPanel{
	  private JLabel schedule_source ,schedule_destination;
	  private JTable schedule_table;
	  private JScrollPane schedule_scrollpane;
	  private JButton schedule_show;
	  private JComboBox source_combobox,destination_combobox;
	  private Cursor c;
	  private ArrayList starting_location=new ArrayList();
	  private ArrayList end_location=new ArrayList();
	  private DefaultTableModel model;
	  private ArrayList fid,fname,src,destin,dep,arr,dat,echarge,eseat,bcharge,bseat,pcharge,pseat;
public AvailableFlight(){
	this.setLayout(null);
	setLocation();
	 setName();
 	setPosition();
 	setCursor();
 	eventshow e = new eventshow();
 	schedule_show.addActionListener(e);
}
public class eventshow implements ActionListener{
	public void actionPerformed(ActionEvent e)
    {
		settable();
    }
}

public void settable(){
	 DefaultTableModel model = new DefaultTableModel();
	 Database db = new Database();
	 
	 ResultSet rs = db.createTable(source_combobox.getSelectedItem().toString(),destination_combobox.getSelectedItem().toString());
	 try{
		 model.addColumn("flightid");
		 model.addColumn("flightname");
		 model.addColumn("source");
		 model.addColumn("destination");
		 model.addColumn("departure");
		 model.addColumn("arrival");
		 model.addColumn("dof");
		 model.addColumn("economycharge");
		 model.addColumn("economyseat");
		 model.addColumn("bussinesscharge");
		 model.addColumn("bussinessseat");
		 model.addColumn("premiumcharge");
		 model.addColumn("premiumseat");
		 
		 String[] a = new String[13];
		 while(rs.next()){
	
			 model.addRow(new String[]{rs.getString("flightid"),rs.getString("flightname"),rs.getString("source"),rs.getString("destination"),rs.getString("departure"),rs.getString("arrival"),rs.getString("dof"),rs.getString("economycharge"),rs.getString("economyseat"),rs.getString("businesscharge"),rs.getString("businessseat"),rs.getString("premiumcharge"),rs.getString("premiumseat")});
			
		 }
		 
		 schedule_table = new JTable(model);
		 schedule_table.setFillsViewportHeight(true);
	     schedule_table.setPreferredScrollableViewportSize(new Dimension(900,500));
		 schedule_scrollpane= new JScrollPane(schedule_table);
		 schedule_scrollpane.setBounds(15,60,1000,400);
		    this.add(schedule_scrollpane);
	 }catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
public void setLocation(){
	Database db = new Database();
	ResultSet rs = db.setlocation();
	
	try {

		//int i = 0;
			while(rs.next()){
				starting_location.add(rs.getString("source"));
				end_location.add(rs.getString("destination"));
				//i++;
				//System.out.println(rs.getString("source")  + rs.getString("destination"));
			}
			source_combobox = new JComboBox(starting_location.toArray());
			destination_combobox = new JComboBox(end_location.toArray());

		

	}catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
public void setName(){
    schedule_source = new JLabel("SOURCE");
    schedule_destination = new JLabel("DESTINATION");
    schedule_show= new JButton("SHOW");
}
public void setPosition(){
	schedule_source.setBounds(20,15,120,40);
    this.add(schedule_source);
    
    source_combobox.setBounds(100,15,150,40);
    this.add(source_combobox);
          
    schedule_destination.setBounds(350,15,120,40);
    this.add(schedule_destination);
    
    destination_combobox.setBounds(450,15,150,40);
    this.add(destination_combobox);
    
    schedule_show.setBounds(730,15,100,40);
    this.add(schedule_show);
    
              
}
public void setCursor(){
	c =new Cursor(Cursor.HAND_CURSOR);
	schedule_show.setCursor(c);

}
}