import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class ChequeDetail extends JFrame {
	private JLabel labeltop,label1,label2,label3,label4,label5,label6;
	private JTextField field1,field2,field3,field4,field5,field6,field7,field8;
	private JButton button1,cancel;
	private JComboBox combobox1,combobox2,combobox3;
	private JPanel panel1,panel2;
	private Cursor c;
	String[] day={"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
	String[] month={"1","2","3","4","5","6","7","8","9","10","11","12"};
	String[] year={"2016","2017"};
	private String ticketno,chequeno,bankname,gday,gmon,gyear;
public ChequeDetail(){
	super("CHEQUE DETAIL");
	setLayout(null);
	setName();
	setPosition();
	addListener();
	setCursor();
}

public void setName(){
	labeltop=new JLabel("CHEQUE DETAIL");
	label1=new JLabel("TICKET_NO");
	label2=new JLabel("CHEQUE_NO");
	label3=new JLabel("CHEQUE_DATE");
	label4=new JLabel("BANK NAME");
	
	field1=new JTextField(10);
	field2=new JTextField(10);
	field3=new JTextField(10);
	button1=new JButton("SAVE");	
	cancel=new JButton("CANCEL");	
	
	combobox1=new JComboBox(day);
	combobox2=new JComboBox(month);
	combobox3=new JComboBox(year);
}
public void setPosition(){
	labeltop.setBounds(160,10,150,40);
	labeltop.setFont(new Font("Arial", Font.BOLD,16 ));
	add(labeltop);
	
	label1.setBounds(100,50,100,30);
	add(label1);
	
	field1.setBounds(200,50,100,25);	
	add(field1);
	label2.setBounds(100,80,100,30);	
	add(label2);
	field2.setBounds(200,80,100,25);
	add(field2);
	label3.setBounds(100,110,100,30);	
	add(label3);
	combobox1.setBounds(200,110,50,25);
	add(combobox1);
	combobox2.setBounds(250,110,50,25);
	add(combobox2);
	combobox3.setBounds(300,110,55,25);
	add(combobox3);
	label4.setBounds(100,140,100,30);
	add(label4);
	field3.setBounds(200,140,100,25);
	add(field3);
	
	button1.setBounds(150,190,80,40);
	add(button1);
	cancel.setBounds(250,190,80,40);
	add(cancel);
	
	eventsave es = new eventsave();
	button1.addActionListener(es);
}

public class eventsave implements ActionListener{
	public void actionPerformed(ActionEvent es) {
			
			ticketno = field1.getText();
			chequeno = field2.getText();
			bankname = field3.getText();
			gmon = combobox1.getSelectedItem().toString();
			gday = combobox2.getSelectedItem().toString();
			gyear = combobox3.getSelectedItem().toString();
			if( ticketno.length()> 0 && chequeno.length() > 0 && bankname.length()>0)
			{
				Database db =new Database();
				db.chequesave(ticketno,chequeno,bankname,gyear+"-"+gmon+"-"+gday);
				JOptionPane.showMessageDialog(getContentPane(),"THANKS FOR RESERVATION","PAYMENT GETWAY",JOptionPane.PLAIN_MESSAGE);
			}
			else
			{
				JOptionPane.showMessageDialog(getContentPane(),"Fill all Entries","PAYMENT GETWAY",JOptionPane.PLAIN_MESSAGE);
			}
			UserMenu s=new UserMenu();
       		s.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
       		s.setSize(1050,670);
       		s.setLocation(200,00);
       		s.setVisible(true);
       		setVisible(false);
	}
}
public void addListener(){
	cancel.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			PaymentDetail s=new PaymentDetail();
			s.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			s.setSize(500,500);
	        s.setLocation(200,00);
			s.setVisible(true);
			setVisible(false);
		}
	});
}
public void setCursor(){
	c =new Cursor(Cursor.HAND_CURSOR);
	button1.setCursor(c);

}
}