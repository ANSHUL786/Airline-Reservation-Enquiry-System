import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;

public class StatusPanel extends JPanel {
       private JLabel status_cust_id,status_ticket_id,status_flight_id,status_flight_name,status_seat_no,status_fare,status_dof,enquiry;
       private JButton status_search;
       private JTextField status_cust_field,status_ticket_field,dof,status_fid_field,status_fname_field,status_seat_field,status_fare_field;
       private JTextArea address_area;
       
       private JTable status_table;
       private JScrollPane status_scrollpane;
       private Cursor c;
    public StatusPanel(){
        this.setLayout(null);
        setName();
    	setPosition();
    	addListener();
    	setCursor();
    }
    public void setName(){
        enquiry=new JLabel("ENQUIRY");
        status_cust_id=new JLabel("CUSTOMER ID");
        status_ticket_id=new JLabel("TICKET ID");
        status_flight_id=new JLabel("FLIGHT ID");
        status_flight_name=new JLabel("FLIGHT NAME");
        status_seat_no=new JLabel("SEAT NO");
        
        status_dof=new JLabel("DATE OF JOURNEY");
        
        status_search=new JButton("Search");
        
        status_cust_field=new JTextField();
        status_ticket_field=new JTextField();
        status_fid_field=new JTextField();
        status_fname_field=new JTextField();
        status_seat_field=new JTextField();
        
        
        status_table = new JTable(null);
        status_scrollpane= new JScrollPane(status_table);
        dof=new JTextField("");
    }
    public void setPosition(){
        enquiry.setBounds(230, 15,150,40);
        enquiry.setFont(new Font("SERIF", Font.BOLD, 24));
        this.add(enquiry);
        
        status_cust_id.setBounds(80, 55,120,30);
        this.add(status_cust_id);
        
        status_cust_field.setBounds(280, 55,120,30);
        this.add(status_cust_field);
        
        status_ticket_id.setBounds(80, 85,120,30);
        this.add(status_ticket_id);
        
        status_ticket_field.setBounds(280, 85,120,30);
        this.add(status_ticket_field);
        status_ticket_field.setEditable(false);
        status_flight_id.setBounds(80, 115,120,30);
        this.add(status_flight_id);
        
        status_fid_field.setBounds(280, 115,120,30);
        this.add(status_fid_field); 
        status_fid_field.setEditable(false);
        status_flight_name.setBounds(80, 145,120,30);
        this.add(status_flight_name);

        status_fname_field.setBounds(280, 145,120,30);
        this.add(status_fname_field); 
        status_fname_field.setEditable(false);
        status_seat_no.setBounds(80, 175,120,30);
        this.add(status_seat_no);
        
        status_seat_field.setBounds(280, 175,120,30);
        this.add(status_seat_field);
        status_seat_field.setEditable(false); 
       
       
        status_dof.setBounds(80, 205,150,30);
        this.add(status_dof);

        
        dof.setBounds(280, 205,120,30);
        this.add(dof); 
        dof.setEditable(false);
        
        status_search.setBounds(420,55,120,30);
        this.add(status_search);
        
        status_scrollpane.setBounds(600,35,300,400);
        this.add(status_scrollpane);
        
    }
    public void addListener(){
    	status_search.addActionListener(new ActionListener() {
    		
    		@Override
    		public void actionPerformed(ActionEvent arg0) {
    			String userid=status_cust_field.getText();
    			ResultSet rs=null;
    			Database db=new Database();
    			rs=db.enquiry(userid);
    			try {
    				while(rs.next()){
    					   
    						status_cust_field.setText(rs.getString("userid"));
    						status_ticket_field.setText(rs.getString("ticketno"));
    						status_fid_field.setText(rs.getString("flightid"));
    						status_fname_field.setText(rs.getString("flightname"));
    						status_seat_field.setText(rs.getString("seatno"));
    						dof.setText(rs.getString("dateofflight"));
    						
    				}
    			}
    				catch (SQLException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			
    			  }		
    		
    		}
    	});
    }
    public void setCursor(){
    	c =new Cursor(Cursor.HAND_CURSOR);
    	status_search.setCursor(c);
    }
}