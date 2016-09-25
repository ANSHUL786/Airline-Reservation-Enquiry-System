import java.awt.*;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.*;

import javax.swing.*;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TicketGeneration extends JPanel {
	private JLabel labeltop,label1,label2,label3,label4,label5,label6,label7,label8,label9,dof;
	private JTextField field1,field2,field3,field4,field5,field6,field7,field8,field9,doffield;
	private JButton button1,button2,button3;
	private JComboBox combobox1,combobox2,combobox3;
	private JPanel panel1,panel2;
	private Cursor c;
public TicketGeneration(){
	
	this.setLayout(null);
	setName();
	setPosition();
	setCursor();
	addListener();
}
public void setName(){
	labeltop=new JLabel("TICKET RECEIPT");
	label1=new JLabel("CUSTOMER ID");
	label2=new JLabel("FLIGHT ID");
	label3=new JLabel("TICKET NO");
	label4=new JLabel("SEAT NO");
	label5=new JLabel("SOURCE ");
	label6=new JLabel("DESTINATION");
	label7=new JLabel("ARRIVAL");
	label8=new JLabel("DEPARTURE");
	label9=new JLabel("CLASS");
	dof=new JLabel("DATE OF JOURNEY");
	field1=new JTextField(10);
	field2=new JTextField(10);
	field3=new JTextField(10);
	field4=new JTextField(10);
	field5=new JTextField(10);
	field6=new JTextField(10);
	field7=new JTextField(10);
	field8=new JTextField(10);
	field9=new JTextField(10);
	doffield=new JTextField(10);
	button1=new JButton("SEARCH");

}
public void setPosition(){
	labeltop.setBounds(150,10,250,40);
	labeltop.setFont(new Font("Arial", Font.BOLD,16 ));
	this.add(labeltop);
	
	label1.setBounds(100,50,100,30);
	this.add(label1);
	
	field1.setBounds(220,50,120,25);	
	this.add(field1);
	label2.setBounds(100,80,100,30);	
	this.add(label2);
	field2.setBounds(220,80,120,25);
	this.add(field2);
	field2.setEditable(false);
	label3.setBounds(100,110,100,30);	
	this.add(label3);
	field3.setBounds(220,110,120,25);
	this.add(field3);
	field3.setEditable(false);
	label4.setBounds(100,140,100,30);
	this.add(label4);
	field4.setBounds(220,140,120,25);
	this.add(field4);
	field4.setEditable(false);
	label5.setBounds(100,170,100,30);
	this.add(label5);
	field5.setBounds(220,170,120,25);
	this.add(field5);
	field5.setEditable(false);
	label6.setBounds(350,170,100,30);
	this.add(label6);
	field6.setBounds(450,170,120,25);
	this.add(field6);
	field6.setEditable(false);
	label7.setBounds(100,200,100,30);
	this.add(label7);
	field7.setBounds(220,200,120,25);
	this.add(field7);
	field7.setEditable(false);
	label8.setBounds(350,200,100,30);
	this.add(label8);
	field8.setBounds(450,200,120,25);
	this.add(field8);
	field8.setEditable(false);
	label9.setBounds(100,230,100,30);
	this.add(label9);
	field9.setBounds(220,230,120,25);
	this.add(field9);
	field9.setEditable(false);
	dof.setBounds(80,260,200,30);
	this.add(dof);
	doffield.setBounds(220,260,120,25);
	this.add(doffield);
	doffield.setEditable(false);
	button1.setBounds(350,50,100,25);
	add(button1);
	
	
}
public void addListener(){
	button1.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			String userid=field1.getText();
			ResultSet rs=null;
			Database db=new Database();
			rs=db.ticketreceipt(userid);
			try {
				while(rs.next()){
					   
						field1.setText(rs.getString("userid"));
						field2.setText(rs.getString("flightid"));
						field3.setText(rs.getString("ticketno"));
						field5.setText(rs.getString("source"));
						field6.setText(rs.getString("destination"));
						field7.setText(rs.getString("arrival"));
						field8.setText(rs.getString("departure"));
						field9.setText(rs.getString("flightclass"));
						doffield.setText(rs.getString("dateofflight"));
						field4.setText(rs.getString("seatno"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			
			  }		
		
		}
	});
}

public void setCursor(){
	c =new Cursor(Cursor.HAND_CURSOR);
	button1.setCursor(c);

}

}