import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;


public class FlightPanel extends JPanel{
	private JLabel lb1,lb2,lb3,lb30,lb4,lb5,lb6,lb7,lb8,lb9,lb10,lb11,lb12,lb13,lb14,lb15,lb16,lb17,lb18,lb19,lb20,lb21,lb22,lb23,lb24,lb25,lb26,lb27,lb28,lb29;
	private JTextField field1,field2,field3,field4,field5,field6,field7,field8,field9,field10,field11,field12,field13,field14,field15;
	private JPasswordField pass1,pass2;
	private JPanel panel1,panel2,panel3,panel4,panel5;
	private JButton button1,button2,button3,button4;
	private JTextArea ta1,ta2,ta3,ta4;
	private JRadioButton rb1,rb2,rb3,rb4,rb5;
	private Cursor c;
	
	private String fid,dof,flightname,source,destination,departure,arrival,flightclass,charge,seat,economycharge,economyseat,businesscharge,businessseat,premiumcharge,premiumseat;
	public FlightPanel(){
		this.setLayout(null);
		//this.setBounds(10,20,300,400);
		panel1=new JPanel();
		panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS ));
		panel2=new JPanel();
		panel2.setLayout(new GridLayout(11,4));
		setName();
		setPosition();
		addListener();
		setCursor();
	}
	public void setName(){
		lb1=new JLabel("FLIGHT DETAIL           ");
		
		lb2=new JLabel("FLIGHT_ID");
		lb3=new JLabel("FLIGHT_NAME");
		lb4=new JLabel("SOURCE");
		lb5=new JLabel("   DESTINATION");
		lb6=new JLabel("DEPARTURE ");
		lb7=new JLabel("   ARRIVAL TIME");
		lb8=new JLabel("DATE OF FLIGHT");
		lb9=new JLabel("FLIGHT CHARGES");
		lb10=new JLabel("SEATS");
		lb11=new JLabel("");
		lb12=new JLabel("");
		lb13=new JLabel("");
		lb14=new JLabel("CHARGES");
		lb15=new JLabel("");
		lb16=new JLabel("ECONOMY");
		lb17=new JLabel("BUSINESS");
		lb18=new JLabel("PREMIUM");
		lb19=new JLabel("");
		lb20=new JLabel("");
		lb21=new JLabel("");
		lb22=new JLabel("");
		lb23=new JLabel("");
		lb24=new JLabel("");
		lb25=new JLabel("");
		lb26=new JLabel("");
		lb27=new JLabel("YYYY-MM-DD");
		lb28=new JLabel("");
		lb29=new JLabel("FLIGHT CLASS");
		lb30=new JLabel("");
		field1=new JTextField("",25);
		field2=new JTextField("",15);
		field3=new JTextField("",25);
		field4=new JTextField("",25);
		field5=new JTextField("",15);
		field6=new JTextField("",15);
		field7=new JTextField("",25);
		field8=new JTextField("",15);
		field9=new JTextField("",25);
		field10=new JTextField("",15);
		field11=new JTextField("",15);
		field12=new JTextField("",25);
		field13=new JTextField("",15);
		field14=new JTextField("",15);
		button1=new JButton("SEARCH");
		button2=new JButton("ADD FLIGHT");
		button3=new JButton("UPDATE");
		button4=new JButton("DELETE");
	}
		public void setPosition(){
		lb1.setFont(new Font("Serif",Font.BOLD,26));
		panel1.add("Left",lb1);
		panel2.add(lb2);
		panel2.add(field1);
		//button1.setPreferredSize(new Dimension(1*50, 1*300));
	
		panel2.add(button1);
		panel2.add(lb11);
		panel2.add(lb3);
		panel2.add(field2);
		panel2.add(lb12);
		panel2.add(lb13);
		panel2.add(lb4);
		panel2.add(field3);
		panel2.add(lb5);
		panel2.add(field4);
		panel2.add(lb6);
		field5.setToolTipText("TIME FORMAT HH:MM:SS");
		panel2.add(field5);
		panel2.add(lb7);
		field6.setToolTipText("TIME FORMAT HH:MM:SS");		
		
		panel2.add(field6);
		panel2.add(lb8);
		panel2.add(field14);
		panel2.add(lb27);
		panel2.add(lb28);		
		panel2.add(lb24);
		panel2.add(lb25);
		panel2.add(lb26);
		panel2.add(lb30);
		panel2.add(lb29);
		panel2.add(lb14);
		panel2.add(lb10);
		panel2.add(lb19);
		panel2.add(lb16);
		panel2.add(field8);
		panel2.add(field9);
		panel2.add(lb20);
		panel2.add(lb17);
		panel2.add(field10);
		panel2.add(field11);
		panel2.add(lb21);
		panel2.add(lb18);
		panel2.add(field12);
		panel2.add(field13);
		panel2.add(lb22);
		panel2.add(lb23);
		
		panel2.add(button2);
		panel2.add(button3);
		panel2.add(button4);

		panel1.add(panel2);
		panel1.setBounds(100,40,650,400);
		this.add(panel1);
		
	}
	public void addListener(){
		
			button1.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					fid=field1.getText();
					ResultSet rs=null;
					Database db =new Database();
					 rs= db.searchflight(fid);	
					  try {
						while(rs.next()){
							   
								field1.setText(rs.getString("flightid"));
								field2.setText(rs.getString("flightname"));
								field3.setText(rs.getString("source"));
								field4.setText(rs.getString("destination"));
								field5.setText(rs.getString("departure"));
								field6.setText(rs.getString("arrival"));
								field14.setText(rs.getString("dof"));
								field8.setText(rs.getString("economycharge"));
								field9.setText(rs.getString("economyseat"));
								field10.setText(rs.getString("businesscharge"));
								field11.setText(rs.getString("businessseat"));
								field12.setText(rs.getString("premiumcharge"));
								field13.setText(rs.getString("premiumseat"));
								  
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					  }		
				
			});
		
		  //ADD FLIGHT
		  button2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				fid=field1.getText();
				  flightname=field2.getText();
				  source=field3.getText();
				  destination=field4.getText();
				  departure=field5.getText();
				  arrival=field6.getText();
				  dof=field14.getText();
				  economycharge=field8.getText();
				  economyseat=field9.getText();
				  businesscharge=field10.getText();
				  businessseat=field11.getText();
				  premiumcharge=field12.getText();
				  premiumseat=field13.getText();
				  
				  Database db =new Database();
				  db.addflight(fid,flightname,source,destination,departure,arrival,dof,economycharge,economyseat,businesscharge,businessseat,premiumcharge,premiumseat);
				JOptionPane.showMessageDialog(null,"You are Successfully Add flight","Flight Detail",JOptionPane.PLAIN_MESSAGE);

				
			}
		});
		  //update flight
		  button3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				fid=field1.getText();
				  flightname=field2.getText();
				  source=field3.getText();
				  destination=field4.getText();
				  departure=field5.getText();
				  arrival=field6.getText();
				  dof=field14.getText();
				  economycharge=field8.getText();
				  economyseat=field9.getText();
				  businesscharge=field10.getText();
				  businessseat=field11.getText();
				  premiumcharge=field12.getText();
				  premiumseat=field13.getText();
				  
				 Database db =new Database();
				  db.updateflight(fid,flightname,source,destination,departure,arrival,dof,economycharge,economyseat,businesscharge,businessseat,premiumcharge,premiumseat);
				JOptionPane.showMessageDialog(null,"You are Successfully update flight","Flight Detail",JOptionPane.PLAIN_MESSAGE);
				
			}
		});
		  //delete flight
		  button4.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					fid=field1.getText();
					 Database db =new Database();
					  db.deleteflight(fid);
					JOptionPane.showMessageDialog(null,"You are Successfully Delete flight","Flight Detail",JOptionPane.PLAIN_MESSAGE);
					
				}
			});
	}
	public void setCursor(){
    	c =new Cursor(Cursor.HAND_CURSOR);
    	button3.setCursor(c);
    	button1.setCursor(c);
    	button2.setCursor(c);
    	button4.setCursor(c);

	}

	
}