import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class CreditCardDetails extends JFrame{
    private JLabel heading,ticketNo,cardNo,cardType,holderName,expiryDate,bankName;
    private JTextField ticketNoField,cardNoField,holderNameField,bankNameField;
    private JButton save,cancel;
    private JComboBox cardTypeCombo,dob,mob,yob;
    private String cardtype[]={"VISA","MASTERCARD","RUPAY"};
    private Cursor c;
    String[] day={"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
	String[] month={"1","2","3","4","5","6","7","8","9","10","11","12"};
	String[] year={"2016","2017","2018","2019","2020","2021","2022","2023","2024","2025"};
	private String tickNo,creditNo,holdName,banName,ctype,gday,gmon,gyear;
    public CreditCardDetails(){
        setLayout(null);
        setName();
    	setPosition();
    	addListener();
    	setCursor();
    }
    public void setName(){
        heading = new JLabel("Credit Card Details");
        ticketNo = new JLabel("Ticket Number");
        cardNo = new JLabel("Card Number");
        cardType = new JLabel("Card Type");
        expiryDate = new JLabel("Expiry Date");
        holderName = new JLabel("Holder Name");
        bankName = new JLabel("Bank  Name");
        
        ticketNoField = new JTextField(20);
        cardNoField = new JTextField(20);
        holderNameField = new JTextField(20);
        bankNameField = new JTextField(20);
        
        cardTypeCombo = new JComboBox(cardtype);
        dob = new JComboBox(day);
        mob = new JComboBox(month);
        yob = new JComboBox(year);
        save = new JButton("SAVE");
        cancel = new JButton("CANCEL");
    }
    public void setPosition(){
        heading.setBounds(75,20,500,30);
        heading.setFont(new Font("SERIF", Font.BOLD, 35));
        add(heading);
        
        ticketNo.setBounds(15,75,150,30);
        add(ticketNo);
        
        cardNo.setBounds(15,125,150,30);
        add(cardNo);
        
        cardType.setBounds(15,175,150,30);
        add(cardType);
        
        holderName.setBounds(15,225,150,30);
        add(holderName);
        
        expiryDate.setBounds(15,275,150,30);
        add(expiryDate);
        
        bankName.setBounds(15,315,150,30);
        add(bankName);        
        /////////////////////////////////////////////////
        ticketNoField.setBounds(200,75,250,30);
        add(ticketNoField);
        
        cardNoField.setBounds(200,125,250,30);
        add(cardNoField);
        
        holderNameField.setBounds(200,225,250,30);
        add(holderNameField);
        
        bankNameField.setBounds(200,315,250,30);
        add(bankNameField);
        
        //////////////////////////////////////////////////
        save.setBounds(270,375,100,30);
        add(save);
        cancel.setBounds(370,375,100,30);
        add(cancel);
        
        /////////////////////////////////////////////////
        
        cardTypeCombo.setBounds(200,175,250,30);
        add(cardTypeCombo);
        
        dob.setBounds(200,275,83,30);
        add(dob);
        
        mob.setBounds(280,275,83,30);
        add(mob);
        
        yob.setBounds(360,275,83,30);
        add(yob);
        
        eventsave es = new eventsave();
        save.addActionListener(es);
    }
    public class eventsave implements ActionListener{
    		public void actionPerformed(ActionEvent es) {
    			tickNo = ticketNoField.getText();
    			creditNo = cardNoField.getText();
    			holdName = holderNameField.getText();
    			banName = bankNameField.getText();
    			ctype = cardTypeCombo.getSelectedItem().toString();
    			gmon = mob.getSelectedItem().toString();
    			gday = dob.getSelectedItem().toString();
    			gyear = yob.getSelectedItem().toString();
    			if( tickNo.length()> 0 && creditNo.length() > 0 && holdName.length()>0 && banName.length() > 0)
    			{
    				Database db =new Database();
					db.creditCardSave(tickNo,creditNo,holdName,ctype,banName,gyear+"-"+gmon+"-"+gday);
					JOptionPane.showMessageDialog(getContentPane(),"THANKS FOR RESERVATION","PAYMENT GETWAY",JOptionPane.PLAIN_MESSAGE);
	    			
	                 setVisible(false);
    			}
    			
    			else
    				JOptionPane.showMessageDialog(getContentPane(),"Fill all Entries","PAYMENT GETWAY",JOptionPane.PLAIN_MESSAGE);
    		
    		
    			
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
    	save.setCursor(c);
    }

}