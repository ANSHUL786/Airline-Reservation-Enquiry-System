
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;


import sun.management.jdp.JdpGenericPacket;


public class PaymentDetail extends JFrame{
	private JLabel lb1,lb2,lb3,lb4,lb5,lb6,lb7,lb8,lb9,lb10,lb11,lb12,lb13,lb14,lb15,lb16,lb17,lb18,lb19,lb20;
	private JTextField field1,field2,field3,field4,field5,field6,field7,field8;
	private JRadioButton rb1,rb2,rb3,rb4,rb5;
	private JPanel panel1,panel2,panel3,panel4,panel5;
	private JButton button1,button2,button3;
	private ButtonGroup bg;
	private int flag;
	private Cursor c;
public PaymentDetail(){
	super("PAYMENT DETAIL");
	panel1=new JPanel();
	panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS ));
	panel2=new JPanel();
	panel2.setLayout(new GridLayout(8,2));
	panel3=new JPanel();
	panel3.setLayout(null);
	setName();
	setPosition();
	addListener();
	setCursor();
	
}

	public void setName(){
	//lb1.setFont(new Font("SERIF", Font.BOLD,24));
	lb1=new JLabel("PAYMENT DETAIL");
	lb2=new JLabel("TICKET NO");
	lb3=new JLabel("USER ID");
	lb4=new JLabel("FLIGHTID");
	lb5=new JLabel("AMOUNT");
	lb6=new JLabel("MODE");
	
	lb11=new JLabel("");
	lb12=new JLabel("");
	lb13=new JLabel("");
	lb14=new JLabel("");
	lb15=new JLabel("");
	lb16=new JLabel("");
	lb17=new JLabel("");
	lb18=new JLabel("");
	lb19=new JLabel("");
	lb20=new JLabel("");

	field1=new JTextField("",25);
	field2=new JTextField("",15);
	field3=new JTextField("",25);
	field4=new JTextField("",25);
	field5=new JTextField("",15);
	field6=new JTextField("",15);
	field7=new JTextField("",25);
	field8=new JTextField("",15);
	//field9=new JTextField("",25);
	//field10=new JTextField("",15);
	rb1=new JRadioButton("CHEQUE");
	rb2=new JRadioButton("CREDIT CARD");
	rb3=new JRadioButton("CASH");
	bg=new ButtonGroup();
	button1=new JButton("SUBMIT");
	button2=new JButton("SHOW");
	button3=new JButton("CANCEL");
}
public void setPosition(){
	panel3.add(lb1);
	panel2.add(lb2);
	panel2.add(field2);
	panel2.add(lb3);
	panel2.add(field3);
	panel2.add(lb4);
	panel2.add(field4);
	panel2.add(lb5);
	panel2.add(field5);
	panel2.add(lb6);
	
	panel2.add(rb1);
	panel2.add(lb11);
	panel2.add(rb2);
	panel2.add(lb12);
	panel2.add(rb3);
	panel2.add(lb13);
	panel2.add(button1);
	
	bg.add(rb1);
	bg.add(rb2);
	bg.add(rb3);
	
	lb1.setBounds(200,20 ,250,30);
	panel2.setBounds(20,50, 250,300);
	panel3.add(panel2);
	button2.setBounds(300,50,100, 30);
	panel3.add(button2);
	button3.setBounds(275,312,120, 36);
	panel3.add(button3);
	Cursor cu=new Cursor(Cursor.HAND_CURSOR);
	button2.setCursor(cu);
	add(panel3);
	
	
}
public void addListener(){
	button2.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			String ticketno=field2.getText();
			ResultSet rs=null;
			Database db=new Database();
			
			rs=db.paymentDetail(ticketno);
			try {
				while(rs.next()){
					   
						field2.setText(rs.getString("ticketno"));
						field3.setText(rs.getString("userid"));
						field4.setText(rs.getString("flightid"));
						field5.setText(rs.getString("charge"));						
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(getContentPane(),"TicketNo not valid","Payment Getway",JOptionPane.PLAIN_MESSAGE);
			
			  }		
		
		}
	});
		rb1.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				if(rb1.isSelected()){
					flag=1;
				}
				else flag=0;
			}
		});
		rb2.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				if(rb2.isSelected()){
					flag=2;
				}
				else
					flag=0;
			}
		});
		rb3.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				if(rb3.isSelected()){
					flag=3;
				}
				else
					flag=0;
			}
		});
		button1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(flag==1){
					String ticketno = field2.getText();
					String userid = field3.getText();
					String flightno = field4.getText();
					String amount=field5.getText();
					String mode ="CHEQUE";
					Database db =new Database();
					db.addPayment(ticketno,userid,flightno,amount,mode);
						
					ChequeDetail s=new ChequeDetail();
					s.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
					s.setSize(500,300);
					s.setLocation(200,50);
					//s.setResizable(false);
					s.setVisible(true);
                    setVisible(false);

				}
				if(flag==2){
					String ticketno = field2.getText();
					String userid = field3.getText();
					String flightno = field4.getText();
					String amount=field5.getText();
					String mode ="CREDIT";
					Database db =new Database();
					db.addPayment(ticketno,userid,flightno,amount,mode);
					 CreditCardDetails s=new CreditCardDetails();
				        s.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				        s.setSize(600,450);
				        //s.setResizable(false);
				        s.setVisible(true);
	                    setVisible(false);
				    
				}
				if(flag==3){
					String ticketno = field2.getText();
					String userid = field3.getText();
					String flightno = field4.getText();
					String amount=field5.getText();
					String mode ="CASH";
					Database db =new Database();
					db.addPayment(ticketno,userid,flightno,amount,mode);
					JOptionPane.showMessageDialog(getContentPane(),"THANKS FOR RESERVATION","PAYMENT GETWAY",JOptionPane.PLAIN_MESSAGE);
					 UserMenu s=new UserMenu();
	                    s.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	                    s.setSize(1050,670);
	                    s.setLocation(200,00);
	                    s.setVisible(true);
	                    setVisible(false);
				}
			}
		});
		button3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				BookReservation s=new BookReservation();
				
				s.setSize(800,500);
				//s.setResizable(false);
				s.setVisible(true);
				setVisible(false);
				
			}
		});
	}
public void setCursor(){
c =new Cursor(Cursor.HAND_CURSOR);
button3.setCursor(c);
button1.setCursor(c);
button2.setCursor(c);
}



}


