import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.nio.file.attribute.UserPrincipalLookupService;
public class AdminMenu extends JFrame {
    private JTabbedPane tabpane;
    private JButton logout,profile;
    private Cursor c;
    public AdminMenu() {
        super("Admin");
        setLayout(null);
        setName();
    	setPosition();
    	addListener();
    	setCursor();
    }
    
    public void setName(){
        profile = new JButton("Profile");
        logout = new JButton("Logout");
    	tabpane=new JTabbedPane();
    }
    
   public void setPosition(){
    	//add & update flight
        FlightPanel fp = new FlightPanel();
        //available flight panel
        AvailableFlight af = new AvailableFlight();
        //search customer panel

        af.setBounds(0,50,800,500);
        tabpane.add("Add/Update",fp);
        tabpane.add("Available Flight", af);
        tabpane.setBounds(0,25,1030,600);
        add(tabpane);
        
       
        
        logout.setBounds(890,10,90,25);
        add(logout);
    }
    public void addListener(){
        logout.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent arg0) {
				
				MainMenu gui = new MainMenu();
			        
				 gui.setSize(500,300);
			        gui.setLocation(530,200);
			        gui.setVisible(true);
			        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			        setVisible(false);
			}});
            
    }
    
    public void setCursor(){
    	c =new Cursor(Cursor.HAND_CURSOR);
    	profile.setCursor(c);
    	logout.setCursor(c);
    }
}