import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.nio.file.attribute.UserPrincipalLookupService;
public class UserMenu extends JFrame {
    
   
    private JPanel flight_reservation_panel,flight_schedule_panel,body_panel;
    private JTabbedPane tabpane;
    private JButton logout;
    private Cursor c;
   
    JScrollPane scrollpane,schedule_scrollpane,status_scrollpane;
    public UserMenu() {
        super("User");
        setLayout(null);
        setName();
    	setPosition();
    	addListener();
    	setCursor();
    }
     public void setName(){   
         logout = new JButton("Logout");
         tabpane=new JTabbedPane();

     }
     public void setPosition(){
    	 StatusPanel sp = new StatusPanel();
        sp.setBounds(0,50,800,500);
        
        BookReservation br = new BookReservation();
        br.setBounds(0,50,800,500);
        SchedulePanel sph = new SchedulePanel();
        sph.setBounds(0,50,800,500);
        TicketCancellation tc = new TicketCancellation();
        tc.setBounds(0,50,800,500);
        TicketGeneration tg = new TicketGeneration();
        tg.setBounds(0,50,800,500);
        tabpane.add("Book Reservation",br);
        tabpane.add("Ticket Receipt",tg);
        tabpane.add("Ticket Cancellation",tc);
        tabpane.add("Flight Schedule", sph);
      
        tabpane.add("Flight Status",sp);
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
  
    	logout.setCursor(c);   
    	}
   
}