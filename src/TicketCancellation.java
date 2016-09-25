import java.awt.*;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;

public class TicketCancellation extends JPanel {
	private JLabel labeltop,label1,label2,label3,label4,dof;
	private JTextField field1,field2,field3,field4,doffield;
	private JButton button1,button2,button3;
	private JComboBox combobox1,combobox2,combobox3;
	private JPanel panel1,panel2;
	private Cursor c;
public TicketCancellation(){
	
	this.setLayout(null);
	setName();
	addListener();
	setPosition();
	setCursor();
}
public void setName(){
	labeltop=new JLabel("TICKET CANCELLATION");
	label1=new JLabel("TICKET_NO");
	label2=new JLabel("FLIGHT ID");
	label3=new JLabel("CUSTOMER ID");
	label4=new JLabel("SEAT NO");
	dof=new JLabel("DATE OF JOURNEY");
	field1=new JTextField(10);
	field2=new JTextField(10);
	field3=new JTextField(10);
	field4=new JTextField(10);
	doffield=new JTextField(10);
	button1=new JButton("SEARCH");
	button2=new JButton("DELETE");

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
	dof.setBounds(50,170,200,30);
	this.add(dof);
	doffield.setBounds(220,170,120,25);
	this.add(doffield);
	doffield.setEditable(false);
	button1.setBounds(350,50,100,25);
	add(button1);
	button2.setBounds(160,220,100,30);
	this.add(button2);
	
}
public void addListener(){
	button1.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			String ticketno=field1.getText();
			ResultSet rs=null;
			Database db=new Database();
			rs=db.ticketcancellation(ticketno);
			try {
				while(rs.next()){
					   
						field1.setText(rs.getString("ticketno"));
						field2.setText(rs.getString("flightid"));
						field3.setText(rs.getString("userid"));
						doffield.setText(rs.getString("dateofflight"));
						field4.setText(rs.getString("seatno"));

							}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			
			  }		
		
		}
	});
	 button2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String ticketno=field1.getText();
				 Database db =new Database();
				  db.deleteTicket(ticketno);
				JOptionPane.showMessageDialog(null,"You are Successfully Delete Ticket","Ticket Detail",JOptionPane.PLAIN_MESSAGE);
				
			}
		});
}

public void setCursor(){
	c =new Cursor(Cursor.HAND_CURSOR);
	button1.setCursor(c);

}

}