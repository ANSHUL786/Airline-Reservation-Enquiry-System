import java.awt.*;

import javax.print.DocFlavor.STRING;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;


import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class BookReservation extends JPanel{
    private JLabel source,destination,ticket_number,flightclasslabel,customer_id,Fname,Lname,gender,d_o_b,phone_number,address,date_of_journey,flight_id,seat_number_label;
    private JButton book,show,search;
    private JTextField ticket_number_field,customer_field,Fname_field,Lname_field,gender_field,dob,dof,phone_number_field,flight_ID_field,seat_number_field;
    private JTextArea address_area;
    private JComboBox source_combobox,destination_combobox,flightclass,dayof,mof,yof;
    private JTable table;
    private JScrollPane scrollpane;
    private Cursor c;
    private String flightcl[]={"ECONOMY","BUSINESS","PREMIUM"};
    private String[] day={"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
	private String[] month={"1","2","3","4","5","6","7","8","9","10","11","12"};
	private String[] year={"2016","2017"};
	private String economyseat,businessseat,premiumseat,seatno,economycharge,businesscharge,premiumcharge,charge;
	private ArrayList starting_location=new ArrayList();
	private ArrayList end_location=new ArrayList();
	private DefaultTableModel model;
	private ArrayList fid,fname,src,destin,dep,arr,dat,echarge,eseat,bcharge,bseat,pcharge,pseat;
	static String tno;
	
    public BookReservation(){
        this.setLayout(null);    
        setName();
        setTicket();
        setLocation();
    	setPosition();
    	addListener();
    	setCursor();
    	eventshow e = new eventshow();
     	show.addActionListener(e);
    }
   public void setName(){
        source = new JLabel("Source");
        destination = new JLabel("Destination");
        ticket_number = new JLabel("Ticket Number");
        customer_id = new JLabel("Customer ID");
        Fname = new JLabel("First Name");
        Lname = new JLabel("Last Name");
        gender = new JLabel("Gender");
        d_o_b = new JLabel("DOB");
        phone_number =new JLabel("Phone Number");
        address = new JLabel("Address");
        date_of_journey = new JLabel("Date of Journey");
        flight_id = new JLabel("Flight ID");
        seat_number_label =new JLabel("Seat Number");
        flightclasslabel =new JLabel("Flight Class");
        flightclass=new JComboBox(flightcl);
        ticket_number_field = new JTextField(20);
        customer_field = new JTextField(20);
        Fname_field = new JTextField(20);
        Lname_field = new JTextField(20);
        gender_field = new JTextField(20);
        phone_number_field = new JTextField(20);
        flight_ID_field = new JTextField(20);
        seat_number_field = new JTextField(20);
      
        show = new JButton("Show");
        search = new JButton("Search");
        book = new JButton("Book");
        
        scrollpane = new JScrollPane();
        
        dob = new JTextField(20);
              
        dayof=new JComboBox(day);
        mof=new JComboBox(month);
        yof=new JComboBox(year);
    
       address_area = new JTextArea(4, 7);
       
       
    }
    public void setPosition(){
          
       source.setBounds(5,10,70,30);
       this.add(source);
       
       source_combobox.setBounds(80,10,100,30);
       this.add(source_combobox);
       
       destination.setBounds(200,10,100,30);
       this.add(destination);
       
       destination_combobox.setBounds(300,10,100,30);
       this.add(destination_combobox);
       
       show.setBounds(450,10,100,30);
       this.add(show);
        
      
       
       ticket_number.setBounds(600,10,150,30);
       this.add(ticket_number);
       
       customer_id.setBounds(600,50,150,30);
       this.add(customer_id);
       
       Fname.setBounds(600,90,150,30);
       this.add(Fname);
       
       Lname.setBounds(600,130,150,30);
       this.add(Lname);
       
       gender.setBounds(600,170,150,30);
       this.add(gender);
       
       gender_field.setBounds(750,170,150,30);
       this.add(gender_field);
       
       gender_field.setEditable(false);
       
       d_o_b.setBounds(600,210,150,30);
       this.add(d_o_b);
       
       dob.setBounds(750,210,150,30);
       this.add(dob);
       dob.setEditable(false);
       
       
       phone_number.setBounds(600,250,150,30);
       this.add(phone_number);
       
       address.setBounds(600,290,150,30);
       this.add(address);
       
       date_of_journey.setBounds(600,370,150,30);
       this.add(date_of_journey);
       
       dayof.setBounds(750,370,70,30);
       this.add(dayof);
       mof.setBounds(820,370,70,30);
       this.add(mof);
       yof.setBounds(890,370,70,30);
       this.add(yof);
       
      
    
       flight_id.setBounds(600,410,150,30);
       this.add(flight_id);
       
       
       flightclasslabel.setBounds(600,450,150,30);
       this.add(flightclasslabel);
       
       /////////////////////////////////////////////////////////////
       ticket_number_field.setBounds(750,10,150,30);
       this.add(ticket_number_field);
       ticket_number_field.setEditable(false);
       
       ticket_number_field.setText(tno);
       customer_field.setBounds(750,50,150,30);
       this.add(customer_field);
       
       search.setBounds(920,50,100,30);
       this.add(search);
       
       Fname_field.setBounds(750,90,150,30);
       this.add(Fname_field);
       Fname_field.setEditable(false);
       Lname_field.setBounds(750,130,150,30);
       this.add(Lname_field);
       Lname_field.setEditable(false);
       phone_number_field.setBounds(750,250,150,30);
       this.add(phone_number_field);
       phone_number_field.setEditable(false);
       address_area.setBounds(750,290,150,60);
       this.add(address_area);
       address_area.setEditable(false);
       flight_ID_field.setBounds(750,410,150,30);
       this.add(flight_ID_field);
       
       
       flightclass.setBounds(750,450,150,30);
       this.add(flightclass);
       
       book.setBounds(780,500,100,30);
       this.add(book);
    }
   public void addListener(){
       book.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			String userid=customer_field.getText();
			String ticketno=ticket_number_field.getText();
			String flightno=flight_ID_field.getText();
			String gday=dayof.getSelectedItem().toString();
			String  gmon=mof.getSelectedItem().toString();
			String  gyear=yof.getSelectedItem().toString();
			String flighclasss=flightclass.getSelectedItem().toString();
			Database db=new Database();
			ResultSet rs=null;
			
			if(flighclasss=="ECONOMY" && flightno.length()>0){
				rs=db.getEconomySeat(flightno);
				try {
					while(rs.next()){
						economyseat=rs.getString("economyseat");
						economycharge=rs.getString("economycharge");

					}
					seatno=economyseat;
					charge=economycharge;
					int ecoseat=Integer.parseInt(economyseat);
					ecoseat=ecoseat-1;
					String updateEcoseat=Integer.toString(ecoseat);
					db.setEcoSeat(flightno,updateEcoseat);
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if(flighclasss=="BUSINESS" && flightno.length()>0){
				rs=db.getBusinessSeat(flightno);
				try {
					while(rs.next()){
						businessseat=rs.getString("businessseat");
						businesscharge=rs.getString("businesscharge");
					}
					seatno=businessseat;
					charge=businesscharge;
					int busseat=Integer.parseInt(businessseat);
					busseat=busseat-1;
					String updateBusseat=Integer.toString(busseat);
					db.setBusSeat(flightno,updateBusseat);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if(flighclasss=="PREMIUM" && flightno.length()>0){
				rs=db.getPremiumSeat(flightno);
				try {
					while(rs.next()){
						premiumseat=rs.getString("premiumseat");
						premiumcharge=rs.getString("premiumcharge");
					}
					seatno=premiumseat;
					charge=premiumcharge;
					int preseat=Integer.parseInt(premiumseat);
					preseat=preseat-1;
					String updatePreseat=Integer.toString(preseat);
					db.setPreSeat(flightno,updatePreseat);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else
				JOptionPane.showMessageDialog(null,"Fill all Entries","Book up",JOptionPane.PLAIN_MESSAGE);

			Database db1=new Database();
			
			if(userid.length()>0 && flightno.length()>0){
				db1.bookreservation(userid,flightno,ticketno,gyear+"-"+gmon+"-"+gday,flighclasss,seatno,charge);
			
				int tnos=Integer.parseInt(tno);
				tnos=tnos+1;
				Database db2=new Database();
				db2.setticketno(Integer.toString(tnos));
				
			PaymentDetail s=new PaymentDetail();
			s.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			s.setSize(500,500);
	        s.setLocation(200,00);
			s.setVisible(true);
				
			}
			else
				JOptionPane.showMessageDialog(null,"Fill all Entries","Book up",JOptionPane.PLAIN_MESSAGE);

		}
	});
       search.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			String userid=customer_field.getText();
			ResultSet rs=null;
			Database db=new Database();
			rs=db.searchreservation(userid);
			try {
				while(rs.next()){
					   
						customer_field.setText(rs.getString("userid"));
						Fname_field.setText(rs.getString("fname"));
						Lname_field.setText(rs.getString("lname"));
						gender_field.setText(rs.getString("gender"));
						phone_number_field.setText(rs.getString("mobileno"));
						address_area.setText(rs.getString("address"));
						dob.setText(rs.getString("dob"));		

				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  }		
		
	});
    }
    public class eventshow implements ActionListener{
    	public void actionPerformed(ActionEvent e)
        {
    		settable();
        }
    }

    public void settable(){
    	  model = new DefaultTableModel();
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
    		 
    		 table = new JTable(model);
    		 table.setEnabled(false);
    		 scrollpane= new JScrollPane(table);
    		 scrollpane.setBounds(10,60,560,500);
    		    this.add(scrollpane);
    	 }catch (SQLException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    }
    public void setTicket(){
    	ResultSet rs=null;
        Database db=new Database();
        rs=db.getTicketno();
        try {
			while(rs.next()){
			  tno=rs.getString("ticketno");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
   public  void setLocation(){
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
 public void setCursor(){
    	c =new Cursor(Cursor.HAND_CURSOR);
    	show.setCursor(c);
    	search.setCursor(c);
    	book.setCursor(c);
    }
}