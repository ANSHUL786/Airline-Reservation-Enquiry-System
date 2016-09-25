import javax.swing.JFrame;

public class Test {
	public static void main(String args[])
    {
		new CreateTable();
        MainMenu gui = new MainMenu();
        //add(gui);
        //gui.pack();
        gui.setSize(500,300);
        gui.setLocation(530,200);
        gui.setVisible(true);
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);;
        
    }
}
