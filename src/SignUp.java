
import java.awt.*;
import javax.swing.*;


import java.awt.event.*;
import java.util.Enumeration;
public class SignUp extends JFrame {

	private JLabel labell,labelp,labelr,label1, label2,label3,label4,label5,label6, label7,label8,label9,label10,label11,label12,label13,label14,label15,label16, label17,label18,label19,label20,label21;
	private JTextField field1,field2,field3,field4,field5,field6,field7,field8,field9,field10,field11,field12,field13,field14,field15;
	private JPasswordField pass1,pass2;
	private JPanel panel1,panel2,panel3,panel4,panel5;
	private JButton button1,cancel;
	private JTextArea ta1,ta2,ta3,ta4;
	private JRadioButton rb1,rb2,rb3,rb4,rb5;
	private JScrollPane scrollpane;
	private ButtonGroup bg1,bg2;
	private JComboBox day,mon,year,sq;
	private String seq_que[]={"What is the name of your childhood friend?","What is your favorite movie?","Who is your childhood sports hero?","What is your favorite team?","What is your first mobile number?"};

	private String date[] = {"1","2","3","4","5","6","7","8","9","10",
			"11","12","13","14","15","16","17","18","19","20",
			"21","22","23","24","25","26","27","28","29","30","31"};
	
	private String month[] = {"01","02","03","04","05","06","07","08","09","10",
			"11","12"};
	
	private String years[] = {"1991","1992","1993","1994","1995","1996",
			"1997","1998","1999","2000","2001"};
	private Cursor c;
	private String userid,password,confirmpass,question,answer,fname,lname,gday,gmon,gyear,email,nationality,address,city,state,country;
	private char[] pass,compass;
	private String gender,martial;
	private String mobileno,pincode;
	public SignUp(){
		super("SIGN UP");
		this.setLayout(null);
		setName();
		setPositionAdd();
		addListener();
		setCursor();
	}
	public void setName(){
		labell=new JLabel("Login Detail");
		labelp=new JLabel("Personal Detail");
		labelr=new JLabel("Residential Detail");
		label1=new JLabel("User ID ");
		label2=new JLabel("Security question");
		label3=new JLabel("security answer");
		label4=new JLabel("Password");
		label5=new JLabel("Confirm Password");
		label6=new JLabel("First Name ");
		label7=new JLabel("Last Name");
		label8=new JLabel("Gender");
		label9=new JLabel("DOB");
		label10=new JLabel("");
		label11=new JLabel("Martial Status ");
		label12=new JLabel("");
		label13=new JLabel("Email ID");
		label14=new JLabel("Mobile No.");
		label15=new JLabel("Nationality");
		label16=new JLabel("Address");
		label17=new JLabel("City/Town");
		label18=new JLabel("State");
		label19=new JLabel("Country");
		label20=new JLabel("Pincode");
		label21=new JLabel("Agree to our Term and Condition");

		pass1=new JPasswordField(8);
		pass2=new JPasswordField();
		field1=new JTextField(25);
		field3=new JTextField(25);
		field4=new JTextField("",25);
		field5=new JTextField("",15);
		field6=new JTextField("dd/mm/yy",15);
		field7=new JTextField("",25);
		field8=new JTextField("",15);
		field9=new JTextField("",25);
		field10=new JTextField("",15);
		field11=new JTextField("",25);
		field12=new JTextField("",15);
		field13=new JTextField("",25);
		field14=new JTextField("",25);
		field15=new JTextField("",15);
		rb1=new JRadioButton("Male");
		rb2=new JRadioButton("Female");
		rb3=new JRadioButton("Married");
		rb4=new JRadioButton("Unmarried");
		rb5=new JRadioButton("");
		sq=new JComboBox(seq_que);

		day=new JComboBox(date);
		mon=new JComboBox(month);
		year=new JComboBox(years);
		bg1=new ButtonGroup();
		bg2=new ButtonGroup();
		
		ta1=new JTextArea(3,2);

		button1=new JButton("Confirm");
		cancel=new JButton("Cancel");
	}
	public void setPositionAdd(){
		labell.setBounds(150,15,200,40);
		labell.setFont(new Font("serif",Font.BOLD,24));
		add(labell);
		
		label1.setBounds(20,70,200,30);
		add(label1);
		field1.setBounds(200,70,200,30);
		add(field1);
		label4.setBounds(20,100,200,30);
		add(label4);
		pass1.setBounds(200,100,200,30);
		add(pass1);
		pass1.setToolTipText("password must contain atleast one digit,one lowercase,one uppercase,one special character,no whitespace,atleast of 8 character");
		label5.setBounds(20,130,200,30);		
		add(label5);
		pass2.setBounds(200,130,200,30);
		add(pass2);
		pass2.setToolTipText("password must contain atleast one digit,one lowercase,one uppercase,one special character,no whitespace,atleast of 8 character");
		label2.setBounds(20,160,200,30);
		add(label2);
		sq.setBounds(200,160,250,30);
		add(sq);
		label3.setBounds(20,190,200,30);
		add(label3);
		field3.setBounds(200,190,200,30);
		add(field3);
		 
		
		labelp.setBounds(120,240,200,40);
		labelp.setFont(new Font("serif",Font.BOLD,24));
		//labelp.setForeground(Color.BLUE);
		add(labelp);
		label6.setBounds(20,300,200,30);
		add(label6);
		field4.setBounds(200,300,200,30);
		add(field4);
		label7.setBounds(20,330,200,30);
		add(label7);
		field5.setBounds(200,330,200,30);
		add(field5);
		label8.setBounds(20,360,200,30);
		add(label8);
		bg1.add(rb1);
		bg1.add(rb2);
		bg2.add(rb3);
		bg2.add(rb4);
		rb1.setBounds(200,360,100,30);
		add(rb1);
		rb2.setBounds(300,360,100,30);
		add(rb2);
		label9.setBounds(20,390,200,30);
		add(label9);
		
		day.setBounds(200,390,80,30);
		add(day);
		mon.setBounds(280,390,80,30);
		add(mon);
		year.setBounds(360,390,80,30);
		add(year);
		
		label11.setBounds(20,420,200,30);
		add(label11);
		rb3.setBounds(200,420,100,30);
		add(rb3);		
		rb4.setBounds(300,420,100,30);
		add(rb4);		
		label13.setBounds(20,450,200,30);
		add(label13);
		field7.setBounds(200,450,200,30);
		add(field7);
		label14.setBounds(20,480,200,30);
		add(label14);
		field8.setBounds(200,480,200,30);
		add(field8);
		
		label15.setBounds(20,510,200,30);
		add(label15);
		field9.setBounds(200,510,200,30);
		add(field9);
		labelr.setBounds(600,15,250,40);
		labelr.setFont(new Font("serif",Font.BOLD,24));
		add(labelr);
		label16.setBounds(500,65,200,30);
		add(label16);
		ta1.setBounds(700,65,200,90);
		add(ta1);
		label17.setBounds(500,155,200,30);
		add(label17);
		field11.setBounds(700,155,200,30);
		add(field11);
		label18.setBounds(500,185,200,30);
		add(label18);
		field12.setBounds(700,185,200,30);
		add(field12);
		label19.setBounds(500,215,200,30);
		add(label19);
		field13.setBounds(700,215,200,30);
		add(field13);
		label20.setBounds(500,245,200,30);
		add(label20);
		field14.setBounds(700,245,200,30);
		add(field14);
		rb5.setBounds(20,540,30,30);
		add(rb5);
		label21.setBounds(50,540,200,30);
		add(label21);
		button1.setBounds(400,590,100,40);
		add(button1);
		cancel.setBounds(500,590,100,40);
		add(cancel);
	}
	public void addListener(){
		cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				MainMenu gui = new MainMenu();
		        //add(gui);
		        //gui.pack();
		        gui.setSize(500,300);
		        gui.setLocation(530,200);
		        gui.setVisible(true);
		        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);;
				setVisible(false);
			}
		});
		button1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(rb5.isSelected()){
					  userid=field1.getText();
					 
						 boolean id= isAlphaNumeric(userid);
						 if(id){
							 pass=pass1.getPassword();
							 password=new String(pass);
							 boolean pa=passwordvalidation(password);
							  if(pa){
								  compass=pass2.getPassword();
								  confirmpass=new String(compass);
								  question=sq.getSelectedItem().toString();
								  answer=field3.getText();
								  fname=field4.getText();
								  lname=field5.getText();
								  if(rb1.isSelected())
									  gender="male";
								  else if(rb2.isSelected())
									  gender="female";
								  gday=day.getSelectedItem().toString();
								  gmon=mon.getSelectedItem().toString();
								  gyear=year.getSelectedItem().toString();
								  if(rb3.isSelected())
									  martial="married";
								  else if(rb4.isSelected())
									  martial="unmarried";
								  email=field7.getText();
								  mobileno=field8.getText();
						  try{
							  validateMobile(mobileno);
							
							  nationality=field9.getText();
							  address=ta1.getText();
							  city=field11.getText();
							  state=field12.getText();
							  country=field13.getText();
							  pincode=field14.getText();
							  boolean pin=pincodevalidation(pincode);
							  if(pin)
							  {
							  if( userid.length()> 0 && password.length() > 0 && confirmpass.length()>0 && fname.length()> 0 && lname.length() > 0 && email.length()>0 && mobileno.length()> 0 && pincode.length() > 0 && address.length()>0 &&  state.length()> 0 && gender.length() > 0 &&  state.length()> 0 && country.length() > 0 && martial.length()>0 )
							  {
								  EmailValidator ev =new  EmailValidator();
								  boolean c=ev.check(email);	
								  int comp=password.compareTo(confirmpass);
								  if(comp==0){
									  if(c){
										  Database db =new Database();
										  db.signupdetail(userid,password,question,answer,fname,lname,gender,gyear+"-"+gmon+"-"+gday,martial,email,mobileno,nationality,address,city,state,country,pincode);
										  JOptionPane.showMessageDialog(getContentPane(),"You are Successfully Sign Up","Sign up",JOptionPane.PLAIN_MESSAGE);
				
										  MainMenu gui = new MainMenu();
										  gui.setSize(500,300);
										  gui.setLocation(530,200);
										  gui.setVisible(true);
										  gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);;
										  setVisible(false);
									  }
									  else
										  JOptionPane.showMessageDialog(getContentPane(),"Email not valid","Sign up",JOptionPane.PLAIN_MESSAGE);
								  	}
	
								 else
									 JOptionPane.showMessageDialog(getContentPane(),"Password and confirm password Doesn't Match","Sign up",JOptionPane.ERROR_MESSAGE);
							  		}
							 else
								 JOptionPane.showMessageDialog(getContentPane(),"Fill all Entries","Sign up",JOptionPane.PLAIN_MESSAGE);
							  }
							  else
									 JOptionPane.showMessageDialog(getContentPane(),"Pincode is not correct","Sign up",JOptionPane.PLAIN_MESSAGE);
						  }
						  	catch (  Exception n) {
						  		// TODO Auto-generated catch block
						  		JOptionPane.showMessageDialog(getContentPane(), "    Invalid Number Input", "Error",JOptionPane.ERROR_MESSAGE);				}
							  }
						  
						  else 
						 		JOptionPane.showMessageDialog(getContentPane(), " password must contain atleast one digit,one lowercase,one uppercase,one special character,no whitespace,atleast of 8 character", "Error",JOptionPane.ERROR_MESSAGE);			
						}	  
						 else{
					 		JOptionPane.showMessageDialog(getContentPane(), "    Invalid UserId Type Not a alphanumeric code", "Error",JOptionPane.ERROR_MESSAGE);				}
					}
				else{
					JOptionPane.showMessageDialog(getContentPane(),"Agree To our Term and Condition","Sign up",JOptionPane.PLAIN_MESSAGE);
				}
			}
		});
	}

	public void validateMobile(String str) throws Exception
	{
		Long a;
			
		 a=Long.parseLong(str);
		if(str.length()>10 || a<0)
			throw new NumberFormatException();

	}
	public boolean isAlphaNumeric(String s){
	    String pattern= "^[a-zA-Z0-9]*$";
	        if(s.matches(pattern)){
	            return true;
	        }
	        return false;   
	}
	public boolean passwordvalidation(String str) { 
		    String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{5,10}";
		    if(str.matches(pattern)){
		    	return true;
		    }
		    else
		    	return false;
		  }
	public boolean pincodevalidation(String str) { 
	    String pattern = "^[1-9][0-9]{5}$";
	    if(str.matches(pattern)){
	    	return true;
	    }
	    else
	    	return false;
	  }

	 public void setCursor(){
	     	c =new Cursor(Cursor.HAND_CURSOR);
	     	button1.setCursor(c);
	    	cancel.setCursor(c); 
	    	}
}