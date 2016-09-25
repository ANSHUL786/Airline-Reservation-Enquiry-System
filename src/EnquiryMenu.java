import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.nio.file.attribute.UserPrincipalLookupService;
public class EnquiryMenu extends JFrame {
    private JTabbedPane tabpane;
    private JButton back,profile;
    
    public EnquiryMenu() {
        super("Enquiry");
        setLayout(null);
        setName();
    	setPosition();
    	addListener();
    }
     public void setName(){  
         back = new JButton("Back");
         tabpane=new JTabbedPane();
     }
      public void setPosition(){
    	FlightEnquiry fe = new FlightEnquiry();
        fe.setBounds(0,50,800,500);
        
        FlightSchedule fs = new FlightSchedule();
        fs.setBounds(0,50,800,500);
        
        tabpane.add("Enquiry",fe);
        tabpane.add("Flight Schedule",fs);
        tabpane.setBounds(0,25,1030,600);
        add(tabpane);
        back.setBounds(890,10,90,25);
        add(back);
      }
      public void addListener(){
    	back.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				MainMenu gui = new MainMenu();
		        
		        gui.setSize(500,300);
		        gui.setLocation(530,200);
		        gui.setVisible(true);
		        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		        setVisible(false);
			}
		});
    	
            
    }

   
}