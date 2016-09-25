import javax.swing.*;

import java.awt.*;

import javax.swing.event.*;

import java.awt.Event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

public class MainMenu extends JFrame{

	   private JLabel heading,loginAsUser,loginAsAdmin,enquiry,loginLabel,userPasswordLabel,adminPasswordLabel,userIdLabel,adminIdLabel;
	   private JButton userLoginButton,adminLoginButton,enquiryButton,loginUser,loginAdmin,userSignup;
	   private JTextField userIdField,adminIdField;
	   private JPasswordField userPasswordField,adminPasswordField;
	   private JPanel mainpanel,panel2,panel3,panel4;
	   private JSeparator seprator;
	   private Cursor c;

	   public MainMenu()
	   {
		  setPanel();
		  setName();
		  setPosition();
		  addListener();
		  setCursor();
		  
	   } 
		  public void setPanel(){
			mainpanel = new JPanel();
			panel2 = new JPanel();
			panel3 = new JPanel();
			panel4 = new JPanel();
			
			mainpanel.setLayout(null);
			panel2.setLayout(null);
			panel3.setLayout(null);;
			panel4.setLayout(null);
		  
		  
			mainpanel.setBounds(0,0,500,300);
			panel2.setBounds(0,0,150,250);
			panel3.setBounds(160,0,440,300);
			panel4.setBounds(155,0,5,300);
			
	        this.setLayout(null);
	      
		  }
		  public void setName(){
			  userLoginButton = new JButton("Login as User");
	        adminLoginButton = new JButton("Login as Admin");
	        enquiryButton = new JButton("Enquiry");
	        loginUser = new JButton("Login");
	        loginAdmin = new JButton("Login");
	        
	        userIdLabel = new JLabel("User ID");
	        loginLabel = new JLabel("LOGIN");
	        heading = new JLabel("Enquiry");
	        
	        adminIdLabel =new JLabel("Admin ID");
	        adminIdField = new JTextField(20);  
	        adminPasswordField = new JPasswordField(20);
	        adminPasswordLabel = new JLabel("Password"); 
	        
	        
	        userPasswordField = new JPasswordField(20);
	        userIdField = new JTextField(20);
	        userPasswordLabel = new JLabel("Password");
	        userSignup=new JButton("Signup");
	        
	        seprator = new JSeparator(JSeparator.VERTICAL);
	        heading.setFont(new Font("Serif", Font.BOLD, 35));
	        loginLabel.setFont(new Font("Serif", Font.BOLD, 20));
		  }
		  
		  public void setPosition(){
	        heading.setBounds(25,10, 300, 50);
	        userLoginButton.setBounds(0,100, 150, 30);
	        adminLoginButton.setBounds(0,130,150,30);
	        enquiryButton.setBounds(0,160,150,30);
	        //loginLabel.setBounds(0,30,150,150);;
	        seprator.setBounds(0,0,3,400);
	        
	        //panel2.add(loginLabel);
	        panel2.add(userLoginButton);
	        panel2.add(adminLoginButton);
	        panel2.add(enquiryButton);
	        panel3.add(heading);
	        panel4.add(seprator);
	        mainpanel.add(panel2);
	        mainpanel.add(panel3);
	        mainpanel.add(panel4);
	        add(mainpanel);
	        }
		 public void addListener(){
	        eventUser userMain = new eventUser();
	        userLoginButton.addActionListener(userMain);
	        
	        eventAdmin adminMain = new eventAdmin();
	        adminLoginButton.addActionListener(adminMain);
	        
	                
	        eventEnquiry e = new eventEnquiry();
	        enquiryButton.addActionListener(e);
	        
	        eventloginAdmin la = new eventloginAdmin();
	        loginAdmin.addActionListener(la);
	        
	        eventloginUser lu = new eventloginUser();
	        loginUser.addActionListener(lu);
	        
	        eventsignupUser su = new eventsignupUser();
	        userSignup.addActionListener(su);
	}
	   public class eventloginAdmin implements ActionListener{
		   public void actionPerformed(ActionEvent e)
		   {
			   String adminid=adminIdField.getText();
			   String adminpass=new String(adminPasswordField.getPassword());
			   int idcheck=adminid.compareTo("admin");
			   int passcheck=adminpass.compareTo("fan");
			   if(idcheck==0&&passcheck==0){
			   AdminMenu s=new AdminMenu();
               s.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
               s.setSize(1050,670);
               s.setLocation(200,00);
               s.setVisible(true);
               setVisible(false);
			   }
			   else
					JOptionPane.showMessageDialog(null,"UserId and Password not matched","Login",JOptionPane.PLAIN_MESSAGE);
		   }
       }
	   public class eventloginUser implements ActionListener{
		   public void actionPerformed(ActionEvent e)
		   {
			   String userid= userIdField.getText();
           	String password=new String(userPasswordField.getPassword());
           	Database db=new Database();
           	boolean check=db.checkLogin(userid, password);
           	if(check){
           		UserMenu s=new UserMenu();
           		s.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
           		s.setSize(1050,670);
           		s.setLocation(200,00);
           		s.setVisible(true);
           		setVisible(false);
           	}
           	else
				JOptionPane.showMessageDialog(null,"UserId and Password not matched","Login",JOptionPane.PLAIN_MESSAGE);

           }
      }
	   
	   public class eventsignupUser implements ActionListener{
		   public void actionPerformed(ActionEvent e)
		   {
			   SignUp s=new SignUp();
               s.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
               s.setSize(1050,700);
               s.setLocation(220,00);
               s.setVisible(true);
               setVisible(false);
           }
       }
	   
	   public class eventUser implements ActionListener{
			public void actionPerformed(ActionEvent e)
	        {
				panel3.removeAll();
				panel3.repaint();
				panel3.revalidate();
				loginLabel.setBounds(110,10,200,40);
				loginLabel.setFont(new Font("Serif", Font.BOLD, 30));
				panel3.add(loginLabel);
				userIdLabel.setBounds(50,100,100,30);
				userIdField.setBounds(150,100,150,30);
				userPasswordLabel.setBounds(50,150,100,30);
				userPasswordField.setBounds(150,150,150,30);;
				loginUser.setBounds(65,210,100,30);
				userSignup.setBounds(165,210,100,30);
				panel3.add(userIdLabel);
				panel3.add(userIdField);
				panel3.add(userPasswordField);
				panel3.add(userPasswordLabel);
				panel3.add(loginUser);
				panel3.add(userSignup);
	        }
	        
		}   
	   public class eventAdmin implements ActionListener{
			public void actionPerformed(ActionEvent e)
	        {
				panel3.removeAll();
				panel3.repaint();
				panel3.revalidate();
				loginLabel.setBounds(110,10,200,40);
				loginLabel.setFont(new Font("Serif", Font.BOLD, 30));
				panel3.add(loginLabel);
				adminIdLabel.setBounds(50,100,100,30);
				adminIdField.setBounds(150,100,150,30);
				adminPasswordLabel.setBounds(50,150,100,30);
				adminPasswordField.setBounds(150,150,150,30);;
				loginAdmin.setBounds(100,210,100,30);
				
				panel3.add(adminIdLabel);
				panel3.add(adminIdField);
				panel3.add(adminPasswordField);
				panel3.add(adminPasswordLabel);
				panel3.add(loginAdmin);
				
				
	        }
	        
		}    
	public class eventEnquiry implements ActionListener{
		public void actionPerformed(ActionEvent e)
        {
	                EnquiryMenu s=new EnquiryMenu();
	                s.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	                s.setSize(1050,670);
	                s.setLocation(200,00);
	                s.setVisible(true);
	                setVisible(false);
	                
	    }
        
	}
	public void setCursor(){
		c =new Cursor(Cursor.HAND_CURSOR);
     	userLoginButton.setCursor(c);
    	userSignup.setCursor(c);
      	adminLoginButton.setCursor(c);
    	loginAdmin.setCursor(c);
    	loginUser.setCursor(c);
    	enquiryButton.setCursor(c);
	}
	
}